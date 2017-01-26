<%--
  Created by IntelliJ IDEA.
  User: Vashurin Alexander
  Date: 25.01.2017
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" media="screen" href="@{'/public/stylesheets/main.css'}">
  <script src="@{'/public/javascripts/jquery-1.3.2.min.js'}" type="text/javascript" charset="${_response_encoding}"></script>
  <script src="@{'/public/javascripts/sessvars.js'}" type="text/javascript" charset="${_response_encoding}"></script>
</head>
<body>

<div id="header">
  <h1>ТЗ для РТ</h1>
  <div id="options">
    |
    <a href="${persona.personaId}">Поиск человека</a>
    |
    <a href="${auto.autoId}">Список авто</a>

  </div>
</div>

<div id="content">
  <p class="fError">
    <strong>${flash.error}</strong>
  </p>
  <p class="fSuccess">
    <strong>${flash.success}</strong>
  </p>
</div>



</body>
</html>

