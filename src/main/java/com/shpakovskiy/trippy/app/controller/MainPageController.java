package com.shpakovskiy.trippy.app.controller;

import com.shpakovskiy.trippy.app.controller.auth.BasePageController;
import com.shpakovskiy.trippy.utils.Consts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainPageController extends BasePageController {

    @Override
    protected void doGet(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws ServletException, IOException {

        super.doGet(httpServletRequest, httpServletResponse);

        System.out.println(currentUser);

        httpServletRequest.setAttribute(Consts.CURRENT_USER, currentUser);

        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("views/main.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
