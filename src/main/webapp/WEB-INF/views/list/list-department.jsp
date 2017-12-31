<%@ page import="com.arief.hibernate.model.dao.DepartmentDAO" %>
<%@ page import="com.arief.hibernate.model.entity.Employee" %>
<%@ page import="com.arief.hibernate.model.entity.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Department</title>
</head>
<body>
    <h1>List Department</h1>
    <table border="2">
        <tr>
            <td>Department ID</td>
            <td>Department Name</td>
            <td>Department Location</td>
            <td>Employee List</td>
        </tr>
        <%
            DepartmentDAO dao = (DepartmentDAO)getServletConfig().getServletContext().getAttribute("departmentDAO");
            List<Department> departmentList = dao.findAll();
        %>
        <%
            for(Department d : departmentList){
        %>
            <tr>
                <td><%=d.getDepartmentId()%></td>
                <td><%=d.getDepartmentName()%></td>
                <td><%=d.getDepartmentLocation()%></td>
                <td><a href="${pageContext.servletContext.contextPath}/list/department/get/<%=d.getDepartmentId()%>">See Employee List</a></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
