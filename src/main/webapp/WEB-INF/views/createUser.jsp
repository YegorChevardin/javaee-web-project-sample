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
      <h1 class=" mt-5 mb-3">Create user</h1>
      <hr/>
      <div class="d-flex flex-column justify-content-center align-items-center">
        <form class="d-flex flex-column justify-content-center align-items-start gap-1" action="${pageContext.request.contextPath}/users/create" method="post">
          <input type="hidden" name="id">
          <label for="name">Name:</label>
          <input type="text" id="name" name="name">
          <label for="secondName">Second Name:</label>
          <input type="text" id="secondName" name="secondName">
          <label for="age">Age:</label>
          <input type="text" id="age" name="age">
          <button type="submit" class="btn btn-outline-success btn-sm">Create</button>
        </form>
      </div>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>