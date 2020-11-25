package com.shpakovskiy.trippy.app.controller;

import com.shpakovskiy.trippy.app.entity.User;
import com.shpakovskiy.trippy.app.entity.UserRole;
import com.shpakovskiy.trippy.app.service.user.DefaultUserService;
import com.shpakovskiy.trippy.app.service.user.UserService;
import com.shpakovskiy.trippy.utils.Consts;
import com.shpakovskiy.trippy.utils.cookies.CookiesUtil;
import com.shpakovskiy.trippy.utils.hash.PasswordHasher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationController extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {

        String email = httpServletRequest.getParameter(Consts.EMAIL);
        String password = httpServletRequest.getParameter(Consts.PASSWORD);
        String name = httpServletRequest.getParameter(Consts.NAME);

        System.out.println(email + " " + password + " " + name);

        User user = new User
                .Builder()
                .email(email)
                .name(name)
                .password((new PasswordHasher().getHash(password)))
                .role(UserRole.CUSTOMER)
                .build();

        UserService userService = new DefaultUserService();
        userService.addUser(user);

        CookiesUtil cookiesUtil = new CookiesUtil();
        cookiesUtil.setCookies(httpServletResponse, Consts.NAME, user.getName());
        cookiesUtil.setCookies(httpServletResponse, Consts.EMAIL, user.getEmail());
        cookiesUtil.setCookies(httpServletResponse, Consts.PASSWORD, user.getPassword());

        try {
            httpServletResponse.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
