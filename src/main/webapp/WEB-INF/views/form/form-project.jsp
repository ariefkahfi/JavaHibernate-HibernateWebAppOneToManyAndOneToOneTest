<%@ page import="com.arief.hibernate.model.dao.EmployeeDAO" %>
<%@ page import="com.arief.hibernate.model.entity.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Project</title>
</head>
<body>
    <h1>Form Project</h1>

    <form method="POST" action="project">
        <div>
            Project ID : <input type="text"
            name="project_id"
        />
        </div>
        <div>
            Project Name : <input type="text"
            name="project_name"
        />
        </div>
        <div>
            Employees who must take this project
            <select name="employee_id">
                <%
                    EmployeeDAO employeeDAO
                    =(EmployeeDAO)
                    getServletConfig()
                    .getServletContext()
                    .getAttribute("employeeDAO");
                %>
                <%
                    for(
                            Employee e : employeeDAO.findAll()
                    ){
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
            <input type="submit"
                value="Save Data"
            />
        </div>
    </form>

</body>
</html>
