<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index Page</title>
    <style>
        a{
            display: block;
        }
        .form-container-a{
            background-color: dodgerblue;
            padding : 5px;
            margin: 10px;
        }
    </style>
</head>
<body>

    <div class="form-container-a">
        <a href="form/department">Form Department</a>
        <a href="form/employee">Form Employee</a>
        <a href="form/project">Form Project</a>
    </div>

    <div class="form-container-a">
        <a href="list/department">List Department</a>
        <a href="list/employee">List Employee</a>
        <%--<a href="list/project">List Project</a>--%>
    </div>

    <div class="form-container-a">
        <a href="detail/project">Show detail your project</a>
    </div>

    <%--<div class="form-container-a">--%>
        <%--<a>Employee list that has taken project</a>--%>
    <%--</div>--%>

</body>
</html>
