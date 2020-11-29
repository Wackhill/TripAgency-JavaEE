package com.shpakovskiy.trippy.app.controller.managerControllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditTourController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("views/edit.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);

        try {
            httpServletResponse.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
