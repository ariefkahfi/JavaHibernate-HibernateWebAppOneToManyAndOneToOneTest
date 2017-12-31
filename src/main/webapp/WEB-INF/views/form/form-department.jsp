<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Department</title>
</head>
<body>
    <h1>Form Department</h1>

    <form method="POST" action="department">
        <div>
            Department ID : <input type="text"
               name="department_id"/>
        </div>
        <div>
            Department Name : <input type="text"
                name="department_name"
            />
        </div>

        <div>
            Department Location : <input type="text"
                name="department_location"
            />
        </div>
        <div>
            <input type="submit"
                value="Save Data"/>
        </div>
    </form>

</body>
</html>
