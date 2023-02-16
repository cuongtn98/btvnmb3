
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Employee</h1>
<a href="/home/create">Create new employee</a> <br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="e" items="${employees}">
    <tr>
        <td>${e.id}</td>
        <td>${e.name}</td>
        <td>${e.age}</td>
        <td>${e.address}</td>
        <td><a href="/home/update/${e.id}">
            <button>Update</button>
        </a></td>
        <td><a href="/home/delete/${e.id}">
            <button>Delete</button>
        </a></td>
    </tr>
    </c:forEach>


</body>
</html>
