package com.arief.hibernate.controllers.list;

import com.arief.hibernate.controllers.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(
        urlPatterns = {"/list/department/*"},
        name = "ListServletDepartment"
)
public class ListDepartment extends AbstractController{


    private static final Logger LOGGER = Logger.getLogger(ListDepartment.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if(pathInfo == null){
            pathInfo = "none";
        }

        LOGGER.info("Path Info : " + pathInfo);


        switch (pathInfo){
            case "none" :
                forwardRequest(
                        "/WEB-INF/views/list/list-department",
                        req,
                        resp
                );
                break;
            default:
                if(pathInfo.toLowerCase().contains("get")){
                    LOGGER.info("contain /get");
                    String pathParam = pathInfo.split("/")[2];
                    req.setAttribute("param",pathParam);
                    LOGGER.info("Path Param : " + pathParam);
                    forwardRequest(
                            "/WEB-INF/views/employee-param/employee-details",
                            req,
                            resp
                    );
                }else{
                    redirectToContextPath(resp);
                }
                break;
        }
    }
}
