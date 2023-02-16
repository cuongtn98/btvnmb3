
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Update form</h1>
<form action="/home/updateEmp/${emp.id}" method="post">
  <table>
    <tr>
      <td><label for="name">Name:</label></td>
      <td><input type="text" name="name" id="name" value="${emp.name}"></td>
    </tr>
    <tr>
      <td><label for="age">age:</label></td>
      <td><input type="text" name="age" id="age" value="${emp.age}"></td>
    </tr>
    <tr>
      <td><label for="address">Address:</label></td>
      <td><input type="text" name="address" id="address" value="${emp.address}"></td>
    </tr>
    <tr>
      <td colspan="2">
        <button type="submit">Update</button>
        <a href="/home" style="text-decoration: none">
          <button>Back to home</button>
        </a>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
