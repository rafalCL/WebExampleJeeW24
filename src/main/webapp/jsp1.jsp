<%--
  Created by IntelliJ IDEA.
  User: edu
  Date: 08.10.2023
  Time: 14:39
  To change this template use File | Settings | File Templates.

  Zadanie 1 - rozwiązywane z wykładowcą
W projekcie stwórz jsp1.jsp.

Dołącz do projektu bibliotekę jstl.
W projekcie stwórz servlet Mvc11 dostępny pod adresem /mvc11.
W servlecie w metodzie GET pobierz parametr o nazwie role a następnie zamień zawartość na wielkie litery oraz dodaj prefix ROLE_ (dla wartości manager otrzymamy ROLE_MANAGER).
Ustaw atrybut o nazwie userRole ze zmienioną wartością.
Ustaw plik jsp jako plik widoku dla tego servletu.
W przypadku braku wartości ma się wyświetlić napis guest.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>
<c:out value="${userRole}" default="guest"/>
    </p>
</body>
</html>
