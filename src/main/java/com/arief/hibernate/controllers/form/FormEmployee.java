package com.arief.hibernate.controllers.form;

import com.arief.hibernate.controllers.AbstractController;
import com.arief.hibernate.model.dao.DepartmentDAO;
import com.arief.hibernate.model.dao.EmployeeDAO;
import com.arief.hibernate.model.entity.Department;
import com.arief.hibernate.model.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(
        urlPatterns = {"/form/employee"},
        name = "FormServletEmployee"
)
public class FormEmployee extends AbstractController{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardRequest(
                "/WEB-INF/views/form/form-employee",
                req,
                resp
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeName =
                req.getParameter("employee_name");
        String employeeAddress =
                req.getParameter("employee_address");
        String departmentId =
                req.getParameter("department_id");


        DepartmentDAO departmentDAO
                =(DepartmentDAO)
                getServletContext()
                .getAttribute("departmentDAO");
        Department d = departmentDAO.findOne(departmentId);

        EmployeeDAO employeeDAO
                =(EmployeeDAO)
                getServletContext()
                .getAttribute("employeeDAO");

        Employee e = new Employee();
        e.setEmployeeName(employeeName);
        e.setEmployeeAddress(employeeAddress);
        e.setDepartment(d);

        employeeDAO.save(e);
        redirectToContextPath(resp);
    }
}
