<%@ page import="com.arief.hibernate.model.dao.EmployeeDAO" %>
<%@ page import="com.arief.hibernate.model.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
    <h1>List Employee</h1>
    <table border="2">
        <tr>
            <td>Employee ID</td>
            <td>Employee Name</td>
            <td>Employee Address</td>
            <td>Delete</td>
        </tr>
        <%
            EmployeeDAO employeeDAO = (EmployeeDAO)getServletConfig().getServletContext().getAttribute("employeeDAO");
            List<Employee> employeeList = employeeDAO.findAll();
        %>
        <%
            for (Employee e : employeeList){
        %>
            <tr>
                <td><%=e.getEmployeeId()%></td>
                <td><%=e.getEmployeeName()%></td>
                <td><%=e.getEmployeeAddress()%></td>
                <td><a href="${pageContext.servletContext.contextPath}/employee/remove?employee_id=<%=e.getEmployeeId()%>">Delete employee</a></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
