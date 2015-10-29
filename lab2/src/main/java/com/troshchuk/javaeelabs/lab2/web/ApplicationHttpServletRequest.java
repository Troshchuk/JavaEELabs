package com.troshchuk.javaeelabs.lab2.web;

import com.troshchuk.javaeelabs.lab1.dao.Operation;
import com.troshchuk.javaeelabs.lab1.dao.impl.GenericDAO;
import com.troshchuk.javaeelabs.lab1.domain.Photo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ApplicationHttpServletRequest extends HttpServlet {
    Operation<Photo, Long> photoDao;

    public ApplicationHttpServletRequest() {
        photoDao = new GenericDAO<Photo, Long>(Photo.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/index.jsp");
            req.setAttribute("photos", photoDao.read());
            dispatcher.forward(req, resp);
        } else {
            super.doGet(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/add_photo")) {
            Map<String, String[]> parameters = req.getParameterMap();
            long id = Long.parseLong(parameters.get("id")[0]);
            String name = parameters.get("name")[0];
            String source = parameters.get("source")[0];
            photoDao.create(new Photo(id, name, source));

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/index.jsp");
            req.setAttribute("photos", photoDao.read());
            dispatcher.forward(req, resp);
        } else {
            super.doPost(req, resp);
        }
    }
}
