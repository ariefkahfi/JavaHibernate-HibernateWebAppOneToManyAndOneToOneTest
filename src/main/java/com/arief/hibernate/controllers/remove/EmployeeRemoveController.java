package com.arief.hibernate.controllers.remove;

import com.arief.hibernate.controllers.AbstractController;
import com.arief.hibernate.model.dao.EmployeeDAO;
import com.arief.hibernate.model.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/employee/remove"},name = "EmployeeRemoveServlet")
public class EmployeeRemoveController extends AbstractController{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("employee_id"));

        EmployeeDAO dao  = (EmployeeDAO)getServletContext().getAttribute("employeeDAO");
        dao.delete(employeeId);

        redirectToContextPath(resp);
    }
}
