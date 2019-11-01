package Filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AppUser;

public class LoginFilter implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;

    public LoginFilter() {
    }
    private static final String[] adminLoginRequiredURLs = {
        "/admin, /home_admin.jsp", "/orderdetails_admin.jsp", "/orders_admin.jsp"};
    private static final String[] userLoginRequiredURLs = {
        "/buyer, /home_user.jsp", "/orderdetails_user.jsp", "/settings_user.jsp"};

    private String path;
    private String loginURI;

    private boolean isLoggedIn;
    private boolean isLoginRequest;
    private boolean isLoginPage;

    boolean isAdminLoggedIn = false;
    boolean isBuyerLoggedIn = false;

    private HttpServletResponse resp;
    private HttpServletRequest req;
    private HttpSession session;

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        req = (HttpServletRequest) request;
        resp = (HttpServletResponse) response;
        session = req.getSession(false);

        path = req.getRequestURI().substring(req.getContextPath().length());
        loginURI = req.getServletContext().getContextPath() + "/Login";

        isLoggedIn = (session != null && session.getAttribute("user") != null);
        isLoginRequest = req.getRequestURI().equals(loginURI);
        isLoginPage = req.getRequestURI().endsWith("login.jsp");

        if (!isLoggedIn && ((isLoginRequired(adminLoginRequiredURLs) || isLoginRequired(userLoginRequiredURLs)) || (path.startsWith("/admin") || path.startsWith("/buyer")))) {
            String loginPage = "/login.jsp";
            RequestDispatcher dispatcher = req.getRequestDispatcher(loginPage);
            dispatcher.forward(request, response);
        } else if (!isLoggedIn) {
            chain.doFilter(request, response);
        } else {
            AppUser user = (AppUser) session.getAttribute("user");

            switch (user.getUserTypeID().getName()) {
                case "Admin":
                    isAdminLoggedIn = true;
                    redirectToAdminPages(request, response, chain);
                    break;
                case "Buyer":
                    isBuyerLoggedIn = true;
                    redirectToABuyerPages(request, response, chain);
                    break;
                default:
                    chain.doFilter(request, response);
                    break;
            }
        }
    }

    private void redirectToAdminPages(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (isAdminLoggedIn || path.startsWith("/buyer")) {
            if (isLoginRequest || isLoginPage) {
                // the user is already logged in and he's trying to login again
                // then forward to the homepage
                req.getRequestDispatcher("/admin").forward(request, response);
            } else if (isLoginRequired(userLoginRequiredURLs) || path.startsWith("/buyer")) {
                req.getRequestDispatcher("/admin").forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    private void redirectToABuyerPages(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (isBuyerLoggedIn || path.startsWith("/admin")) {
            if (isLoginRequest || isLoginPage) {
                // the user is already logged in and he's trying to login again
                // then forward to the homepage
                req.getRequestDispatcher("/buyer").forward(request, response);
            } else if (isLoginRequired(adminLoginRequiredURLs) || path.startsWith("/admin")) {
                req.getRequestDispatcher("/buyer").forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    private boolean isLoginRequired(String[] restPages) {
        String requestURL = req.getRequestURL().toString();

        for (String loginRequiredURL : restPages) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }
        return false;
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("LoginFilter:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("LoginFilter()");
        }
        StringBuffer sb = new StringBuffer("LoginFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
