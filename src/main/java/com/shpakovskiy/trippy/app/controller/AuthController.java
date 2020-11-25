package com.shpakovskiy.trippy.app.controller;

import com.shpakovskiy.trippy.utils.Consts;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthController extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {

        String email = httpServletRequest.getParameter(Consts.EMAIL);
        String password = httpServletRequest.getParameter(Consts.PASSWORD);

        System.out.println(email + " " + password);

        try {
            httpServletResponse.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
