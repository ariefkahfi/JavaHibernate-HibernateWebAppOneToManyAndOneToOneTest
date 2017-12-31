package com.arief.hibernate.controllers.detail;

import com.arief.hibernate.controllers.AbstractController;
import com.arief.hibernate.model.dao.EmployeeDAO;
import com.arief.hibernate.model.entity.Employee;
import com.arief.hibernate.model.entity.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/detail/project"},name = "ProjectDetailsServlet")
public class ProjectDetailsController extends AbstractController{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardRequest(
                "/WEB-INF/views/project-details/project-details",
                req,resp
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId =
                Integer.parseInt(req.getParameter("employee_id"));
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter htmlWriter = resp.getWriter();

        EmployeeDAO employeeDAO = (EmployeeDAO)getServletContext().getAttribute("employeeDAO");
        Employee e = employeeDAO.findOne(employeeId);

        Project p = e.getProject();

        if(p == null){
            p = new Project();
            p.setProjectId("You haven't project yet");
            p.setProjectName("You haven't project yet");
        }

        htmlWriter.write(
                "<h1>" +e.getEmployeeName() + "</h1>" +
                   "<div>" +
                        "<p>" +e.getEmployeeAddress()+ "</p>" +
                        "<p> Your Project below : </p>" +
                        "<ul>" +
                        "   <li>Project ID  : " + p.getProjectId() + "</li>" +
                        "   <li>Project Name : " +p.getProjectName()+ "</li>" +
                        "</ul>" +
                        "</div>"
        );

    }
}
