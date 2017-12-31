<%@ page import="com.arief.hibernate.model.dao.EmployeeDAO" %>
<%@ page import="com.arief.hibernate.model.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project Details Page</title>
</head>
<body>
    <h1>Project Details page</h1>
    <form method="POST" action="project">
        <div>
            Employee :
            <select name="employee_id">
                <%
                    EmployeeDAO empDAO = (EmployeeDAO)getServletConfig().getServletContext().getAttribute("employeeDAO");
                    List<Employee> employeeList = empDAO.findAll();
                %>
                <%
                    for(Employee e : employeeList){
                %>
                        <option value="<%=e.getEmployeeId()%>">
                            <%=e.getEmployeeName()%>
                        </option>
                <%
                    }
                %>
            </select>
        </div>
        <div>
            <input type="submit" value="Show details project"/>
        </div>
    </form>
</body>
</html>
