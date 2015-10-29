package com.troshchuk.javaeelabs.lab2.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationHttpServletRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/index.jsp");
            dispatcher.forward(req, resp);
        } else {
            super.doGet(req, resp);
        }
    }
}
