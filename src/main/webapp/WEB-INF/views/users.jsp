<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Homepage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row justify-content-center align-items-center">
        <div class="col-md-6">
            <div class="d-flex flex-wrap gap-2 justify-content-around align-items-baseline">
                <h1 class=" mt-5 mb-3">Users list</h1>
                <a href="${pageContext.request.contextPath}/users/create" class="btn btn-sm btn-success">Create user</a>
            </div>
            <hr/>
            <div class="table-responsive">
                <table class="table table-striped table-hover table-borderless table-sm">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>SecondName</th>
                        <th>Age</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.secondName}</td>
                            <td>${user.age}</td>
                            <td>
                                <div class="d-flex flex-nowrap">
                                    <a href="${pageContext.request.contextPath}/users/${user.id}" class="btn btn-outline-success btn-sm m-1">Open</a>
                                    <form action="${pageContext.request.contextPath}/users/${user.id}/delete" method="post">
                                        <button type="submit" class="btn btn-outline-danger btn-sm m-1">Delete</button>
                                    </form>
                                    <a href="${pageContext.request.contextPath}/users/${user.id}/update" class="btn btn-outline-primary btn-sm m-1">Update</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>