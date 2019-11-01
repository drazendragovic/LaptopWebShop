/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AppUser;
import model.Cart;
import model.Logins;
import service.BaseService;
import service.BaseServiceImpl;

/**
 *
 * @author DrazenDragovic
 */
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ArrayList<Cart> cart = (ArrayList<Cart>) request.getSession().getAttribute("cart");

        String page = "login.jsp";

        if (username.trim().length() >= 0 && username != null
                && password.trim().length() >= 0 && password != null) {

            BaseService loginService = new BaseServiceImpl();
            AppUser user = loginService.login(username, password);

            if (user != null) {
                System.out.println("Login success!!!");

                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.setAttribute("msg", "Login Success.....");

                Logins record = new Logins();
                record.setDate(Timestamp.valueOf(LocalDateTime.now()));

                String ip = request.getRemoteAddr();
                if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    String ipAddress = inetAddress.getHostAddress();
                    ip = ipAddress;
                }
                record.setIpAdress(ip);
                record.setUserID(user);

                loginService.addRecord(record);

                if (user.getUserTypeID().getName().equals("Admin")) {
                    page = "/admin";
                } else {
                    if (!cart.isEmpty()) {
                        page = "cart.jsp";
                    } else {
                        page = "/buyer";
                    }
                }
            } else {
                page = "error.jsp";
                request.getRequestDispatcher(page).include(request, response);
            }
        } else {
            request.setAttribute("msg", "Please enter username and password...");
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
