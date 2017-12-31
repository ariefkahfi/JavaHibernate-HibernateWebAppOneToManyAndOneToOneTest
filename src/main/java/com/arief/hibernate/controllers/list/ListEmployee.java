package com.arief.hibernate.controllers.list;

import com.arief.hibernate.controllers.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/list/employee"},
        name = "ListServletEmployee"
)
public class ListEmployee extends AbstractController{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardRequest(
                "/WEB-INF/views/list/list-employee",
                req,resp
        );
    }
}
