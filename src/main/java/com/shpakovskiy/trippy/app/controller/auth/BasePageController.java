package com.shpakovskiy.trippy.app.controller.auth;

import com.shpakovskiy.trippy.app.entity.User;
import com.shpakovskiy.trippy.app.service.user.DefaultUserService;
import com.shpakovskiy.trippy.app.service.user.UserService;
import com.shpakovskiy.trippy.utils.Consts;
import com.shpakovskiy.trippy.utils.cookies.CookiesUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BasePageController extends HttpServlet {

    protected User currentUser = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CookiesUtil cookiesUtil = new CookiesUtil();
        String email = cookiesUtil.getCookies(request, Consts.EMAIL);
        String password = cookiesUtil.getCookies(request, Consts.PASSWORD);

        System.out.println("BPC Cookies: " + email + ", " + password);

        if (email != null && password != null) {
            UserService userService = new DefaultUserService();
            if (!userService.isUserExists(email, password)) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/main-reg-auth.jsp");
                requestDispatcher.forward(request, response);
            } else {
                currentUser = userService.getUser(email, password);
            }
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/main-reg-auth.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
