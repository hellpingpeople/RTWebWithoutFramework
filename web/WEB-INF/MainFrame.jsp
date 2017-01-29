<%--
  Created by IntelliJ IDEA.
  User: Vashurin Alexander
  Date: 1/26/17
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список людей</title>
</head>

<body>
<form action="<c:url value="/main"/>" method="POST">
    <table>
        <tr>
            <td>Год:<input type="text" name="year" value="${form.year}"/><br/></td>
            <td>Список автомобилей:
                <select name="autoId">
                    <c:forEach var="auto" items="${form.autos}">
                        <c:choose>
                            <c:when test="${auto.autoId==form.autoId}">
                                <option value="${auto.autoId}" selected><c:out value="${auto.nameGroup}"/></option>
                            </c:when>
                            <c:otherwise>
                                <option value="${auto.autoId}"><c:out value="${auto.nameGroup}"/></option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
            <td><input type="submit" name="getList" value="Обновить"/></td>
        </tr>
    </table>

    <p/>
    <b>Список людей для выбранных параметров:<b>
        <br/>
        <table>
            <tr>
                <th> </th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
            </tr>
            <c:forEach var="persona" items="${form.personas}">
                <tr>
                    <td><input type="radio" name="personaId" value="${persona.personaId}"></td>
                    <td><c:out value="${persona.surName}"/></td>
                    <td><c:out value="${persona.firstName}"/></td>
                    <td><c:out value="${persona.patronymic}"/></td>
                </tr>
            </c:forEach>
        </table>

        <table>
            <tr>
                <td><input type="submit" value="Add" name="Add"/></td>
                <td><input type="submit" value="Edit" name="Edit"/></td>
                <td><input type="submit" value="Delete" name="Delete"/></td>
            </tr>
        </table>

        <p/>

</form>
</body>
</html>

