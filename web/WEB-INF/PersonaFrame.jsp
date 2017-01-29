<%--
  Created by IntelliJ IDEA.
  User: Vashurin Alexander
  Date: 1/26/17
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Список людей</title>
</head>

<body>
<form action="<c:url value="/edit"/>" method="POST">
    <input type="hidden" name="personaId" value="${persona.personaId}"/>
    <table>
        <tr>
            <td>Фамилия:</td><td><input type="text" name="surName" value="${persona.surName}"/></td>
        </tr>
        <tr>
            <td>Имя:</td><td><input type="text" name="firstName" value="${persona.firstName}"/></td>
        </tr>
        <tr>
            <td>Отчество:</td><td><input type="text" name="patronymic" value="${persona.patronymic}"/></td>
        </tr>
        <tr>
            <td>Дата рождения:</td><td><input type="text" name="dateOfBirth" value="${persona.dateOfBirth}"/></td>
        </tr>
        <tr>
            <td>Пол:</td>
            <td>
                <c:choose>
                    <c:when test="${persona.sex==0}">
                        <input type="radio" name="sex" value="0" checked>М</input>
                        <input type="radio" name="sex" value="1">Ж</input>
                    </c:when>
                    <c:otherwise>
                        <input type="radio" name="sex" value="0">М</input>
                        <input type="radio" name="sex" value="1" checked>Ж</input>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td>Авто:</td>
            <td>
                <select name="autoId">
                    <c:forEach var="auto" items="${persona.autos}">
                        <c:choose>
                            <c:when test="${auto.autoId==persona.autoId}">
                                <option value="${auto.autoId}" selected><c:out value="${auto.getModelName}"/></option>
                            </c:when>
                            <c:otherwise>
                                <option value="${auto.autoId}"><c:out value="${auto.getModelName}"/></option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
        </tr>
    </table>
    <table>
        <tr>
            <td><input type="submit" value="OK" name="OK"/></td>
            <td><input type="submit" value="Cancel" name="Cancel"/></td>
        </tr>
    </table>
</form>
</body>
</html>