<%--
  Created by IntelliJ IDEA.
  User: edu
  Date: 08.10.2023
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create book</title>
</head>
<body>
<form method="post">
    <div>
        <label for="title">title
            <input type="text" name="title" id="title">
        </label>
    </div>
    <div>
        <label for="author">author
            <input type="text" name="author" id="author">
        </label>
    </div>
    <div>
        <label for="isbn">isbn
            <input type="text" name="isbn" id="isbn">
        </label>
    </div>
    <div>
        <input type="submit" value="add">
    </div>
</form>
</body>
</html>
