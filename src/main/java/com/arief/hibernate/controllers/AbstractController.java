package com.arief.hibernate.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController extends HttpServlet{
    protected void forwardRequest(String pathOfJSPFile, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(pathOfJSPFile+".jsp")
                .forward(request,response);
    }

    protected void redirectToContextPath(HttpServletResponse response) throws IOException {
        response.sendRedirect(getServletContext().getContextPath());
    }
}
