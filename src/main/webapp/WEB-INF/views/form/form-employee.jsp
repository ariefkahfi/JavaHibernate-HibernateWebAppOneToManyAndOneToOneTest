<%@ page import="com.arief.hibernate.model.dao.DepartmentDAO" %>
<%@ page import="com.arief.hibernate.model.entity.Department" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Employee</title>
</head>
<body>
    <h1>Form Employee</h1>
    <form method="POST" action="employee">
        <div>
            Employee Name : <input
                type="text"
                name="employee_name"
        />
        </div>
        <div>
            Employee Address : <input
                type="text"
                name="employee_address"
        />
        </div>
        <div>
            Department :
            <select name="department_id">
                <%
                    DepartmentDAO departmentDAO
                    =(DepartmentDAO)getServletConfig()
                    .getServletContext()
                    .getAttribute("departmentDAO");
                %>
                <%
                    for(Department d : departmentDAO.findAll()){
                %>
                        <option value="<%=d.getDepartmentId()%>">
                            <%=d.getDepartmentName()%>
                        </option>
                <%
                    }
                %>
            </select>
        </div>
        <div>
            <input type="submit"
                   value="Save data"
            />
        </div>
    </form>
</body>
</html>
