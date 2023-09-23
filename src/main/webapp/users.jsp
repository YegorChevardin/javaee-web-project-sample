<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Homepage</title>
</head>
<body>
<h1>Users list</h1>
<hr/>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>SecondName</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.secondName}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>