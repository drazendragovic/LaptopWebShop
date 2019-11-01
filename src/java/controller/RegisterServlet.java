package controller;

import dao.BaseDao;
import dao.BaseDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AppUser;
import model.UserType;
import service.BaseService;
import service.BaseServiceImpl;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String msg = "Password and Conform Passwords must be same";
        String page = "register.jsp";

        BaseService baseService = new BaseServiceImpl();

        if (request.getSession().getAttribute("user") != null) {
            
            if (request.getParameter("password").equals(request.getParameter("confPassword"))) {
                
                AppUser user = (AppUser) request.getSession().getAttribute("user");
                user.setUsername(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                user.setName(request.getParameter("name"));
                user.setSurname(request.getParameter("surname"));
                user.setEmail(request.getParameter("email"));

                System.out.println(user.toString());

                msg = baseService.updateUser(user);
                page = "settings_user.jsp";

                request.setAttribute("msg2", msg);
                request.getRequestDispatcher(page).include(request, response);
            }

        } else {
            if (request.getParameter("password").equals(request.getParameter("confPassword"))) {

                AppUser user = new AppUser();
                UserType userType = new UserType();
                userType.setIDUserType(2);
                user.setUsername(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                user.setName(request.getParameter("name"));
                user.setSurname(request.getParameter("surname"));
                user.setEmail(request.getParameter("email"));
                user.setUserTypeID(userType);

                System.out.println(user.toString());

                msg = baseService.registration(user);
                page = "login.jsp";
            }
            request.setAttribute("msg2", msg);
            request.getRequestDispatcher(page).include(request, response);
        }
        request.getRequestDispatcher(page).include(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
