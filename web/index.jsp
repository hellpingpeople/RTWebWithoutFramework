<%--
  Created by IntelliJ IDEA.
  User: Vashurin Alexander
  Date: 25.01.2017
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
  <title>ТЗ для РТ</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" type="text/css" media="screen" href="/public/stylesheets/main.css">
  <script src="//code.jquery.com/jquery-1.10.2.js" type="text/javascript" charset="UTF-8"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js" type="text/javascript" charset="UTF-8"></script>
  <script src="/public/javascripts/autocompleter.js" type="text/javascript" charset="UTF-8"></script>

</head>

<body>

<div id="header">
  <h1>ТЗ для РТ</h1>
  <div id="options">
    |
    <a href="${autos.getModelName}">Поиск человека</a>
    |
    <a href="${Autos.index()}">Список авто</a>
    |
    <a href="${Persons.settings()}">Настройки</a>
    |
    <a href="${Application.logout()}">Выход</a>
  </div>
</div>

<div id="content">
  <h1>Поиск людей</h1>

  <p>
    <input type="text" id="search" size="30">
    <input type="submit" id="submit" value="Найти человека">


    <br>
    Показывать по:
    <select id="size">
      <option value="5">5</option>
      <option value="10">10</option>
      <option value="20">20</option>
    </select>
  </p>

  <div id="result">
  </div>

</div>

<div id="footer">
  Сделано с использованием JSP
</div>

</body>
</html>
