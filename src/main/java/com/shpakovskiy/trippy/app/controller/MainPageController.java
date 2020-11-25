package com.shpakovskiy.trippy.app.controller;

import com.shpakovskiy.trippy.app.entity.User;
import com.shpakovskiy.trippy.dao.user.DefaultUserDao;
import com.shpakovskiy.trippy.dao.user.UserDao;
import com.shpakovskiy.trippy.utils.Consts;
import com.shpakovskiy.trippy.utils.cookies.CookiesUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainPageController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws ServletException, IOException {

        /*
        UserDao userDao = new DefaultUserDao();
        for (User user: userDao.getAllUsers()) {
            System.out.println("User: " + user);
        }
         */

        //Check if user registered
        httpServletRequest.setAttribute(Consts.IS_USER_REGISTERED_ATTRIBUTE_NAME, (true));

        //String password = (new CookiesUtil()).getCookies(httpServletRequest, Consts.PASSWORD_COOKIES_KEY);
        //System.out.println("Password: " + password);

        //(new CookiesUtil()).setCookies(httpServletResponse, Consts.PASSWORD_COOKIES_KEY, "sercer_hash");

        //password = (new CookiesUtil()).getCookies(httpServletRequest, Consts.PASSWORD_COOKIES_KEY);
        //System.out.println("Password: " + password);



        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("views/main.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
