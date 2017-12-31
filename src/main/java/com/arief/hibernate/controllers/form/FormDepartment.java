package com.arief.hibernate.controllers.form;

import com.arief.hibernate.controllers.AbstractController;
import com.arief.hibernate.model.dao.DepartmentDAO;
import com.arief.hibernate.model.entity.Department;
import com.arief.hibernate.model.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(
        urlPatterns = {"/form/department"}
        ,name = "FormServletDepartment"
)
public class FormDepartment extends AbstractController{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardRequest(
                "/WEB-INF/views/form/form-department",
                req,
                resp
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptId = req.getParameter
                ("department_id");
        String deptName  = req.getParameter
                ("department_name");
        String deptLocation = req.getParameter
                ("department_location");

        DepartmentDAO departmentDAO =
                (DepartmentDAO)
                        getServletContext()
                                .getAttribute("departmentDAO");

        Department d = new Department();
        d.setDepartmentId(deptId);
        d.setDepartmentName(deptName);
        d.setDepartmentLocation(deptLocation);
        d.setEmployeeList(new ArrayList<Employee>());

        departmentDAO.save(d);

        redirectToContextPath(resp);
    }
}
