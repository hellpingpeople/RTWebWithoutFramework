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
  <title>#{get 'title' /}</title>
  <meta http-equiv="Content-Type" content="text/html; charset=${_response_encoding}">
  <link rel="stylesheet" type="text/css" media="screen" href="@{'/public/stylesheets/main.css'}">
  #{get 'moreStyles' /}
  <script src="@{'/public/javascripts/jquery-1.3.2.min.js'}" type="text/javascript" charset="${_response_encoding}"></script>
  <script src="@{'/public/javascripts/sessvars.js'}" type="text/javascript" charset="${_response_encoding}"></script>
  #{get 'moreScripts' /}
</head>
<body>

<div id="header">
  <h1>тестовое задание для РТ</h1>
  #{if user?.id}
  <div id="options">
    Вы вошли как ${user.username}
    |
    <a href="@{Persons.index()}">Поиск человека</a>
    |
    <a href="@{Autos.index()}">Список авто</a>
    |
    <a href="@{Persons.settings()}">Настройки</a>
    |
    <a href="@{Application.logout()}">Выход</a>
  </div>
  #{/if}
</div>

<div id="content">
  #{if flash.error}
  <p class="fError">
    <strong>${flash.error}</strong>
  </p>
  #{/if}
  #{if flash.success}
  <p class="fSuccess">
    <strong>${flash.success}</strong>
  </p>
  #{/if}

  #{doLayout /}
</div>



</body>
</html>

