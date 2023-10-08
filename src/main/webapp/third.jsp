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
    <title>display a and b request parameters</title>
</head>
<body>
    <p>display a and b request parameters</p>
    <p>a=${empty param.a ? "brak" : param.a}</p>
    <p>b=${empty param.b ? "brak" : param.b}</p>
</body>
</html>
