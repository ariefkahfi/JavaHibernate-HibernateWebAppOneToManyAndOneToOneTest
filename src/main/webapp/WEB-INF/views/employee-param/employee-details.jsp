<%@ page import="com.arief.hibernate.model.dao.DepartmentDAO" %>
<%@ page import="com.arief.hibernate.model.entity.Department" %>
<%@ page import="com.arief.hibernate.model.entity.Employee" %>
<%@ page import="org.hibernate.Hibernate" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Details Page</title>
</head>
<body>
    <%
        String pathParam = (String) request.getAttribute("param");
        DepartmentDAO departmentDAO = (DepartmentDAO)getServletConfig().getServletContext().getAttribute("departmentDAO");
        Department d = departmentDAO.findOne(pathParam);
        List<Employee> employeeList = d.getEmployeeList();
    %>

    <h1>Employee List of  <%=d.getDepartmentName()%></h1>

    <table border="2">
        <tr>
            <td>Employee ID</td>
            <td>Employee Name</td>
            <td>Employee Address</td>
        </tr>
        <%
            for(Employee e : employeeList){
        %>
            <tr>
                <td><%=e.getEmployeeId()%></td>
                <td><%=e.getEmployeeName()%></td>
                <td><%=e.getEmployeeAddress()%></td>
            </tr>
        <%
            }
        %>
    </table>

    <a href="${pageContext.servletContext.contextPath}/list/department">Back</a>
</body>
</html>
