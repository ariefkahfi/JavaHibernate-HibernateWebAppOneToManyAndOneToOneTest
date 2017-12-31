package com.arief.hibernate.controllers.form;

import com.arief.hibernate.controllers.AbstractController;
import com.arief.hibernate.model.dao.EmployeeDAO;
import com.arief.hibernate.model.dao.ProjectDAO;
import com.arief.hibernate.model.entity.Employee;
import com.arief.hibernate.model.entity.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/form/project"},
        name = "FormServletProject"
)
public class FormProject extends AbstractController{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardRequest(
                "/WEB-INF/views/form/form-project",
                req,
                resp
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId =
                req.getParameter(
                        "project_id"
                );
        String projectName =
                req.getParameter(
                        "project_name"
                );
        int employeeId =
                Integer.parseInt(
                  req.getParameter(
                          "employee_id"
                  )
                );

        EmployeeDAO employeeDAO =
                (EmployeeDAO)
                getServletContext()
                .getAttribute("employeeDAO");
        Employee e = employeeDAO.findOne(employeeId);



        ProjectDAO projectDAO =
                (ProjectDAO)
                getServletContext()
                .getAttribute(
                        "projectDAO"
                );

        Project p = new Project();
        p.setProjectId(projectId);
        p.setProjectName(projectName);
        p.setEmployee(e);

        projectDAO.save(p);

        redirectToContextPath(resp);
    }
}
