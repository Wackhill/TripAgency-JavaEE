package com.shpakovskiy.trippy.app.controller.auth;

import com.shpakovskiy.trippy.app.service.user.DefaultUserService;
import com.shpakovskiy.trippy.app.service.user.UserService;
import com.shpakovskiy.trippy.utils.Consts;
import com.shpakovskiy.trippy.utils.cookies.CookiesUtil;
import com.shpakovskiy.trippy.utils.hash.PasswordHasher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthController extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {

        String email = httpServletRequest.getParameter(Consts.EMAIL);
        String password = httpServletRequest.getParameter(Consts.PASSWORD);
        password = (new PasswordHasher().getHash(password));

        System.out.println("Form data: " + email + ", " + password);

        if (email != null && password != null) {
            UserService userService = new DefaultUserService();
            if (userService.isUserExists(email, password)) {
                CookiesUtil cookiesUtil = new CookiesUtil();
                cookiesUtil.setCookies(httpServletResponse, Consts.EMAIL, email);
                cookiesUtil.setCookies(httpServletResponse, Consts.PASSWORD, password);
            }
        }

        try {
            httpServletResponse.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
