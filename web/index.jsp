<%--
  Created by IntelliJ IDEA.
  User: Vashurin Alexander
  Date: 25.01.2017
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
  <title>ТЗ для РТ</title>
  <meta charset="UTF-8">

  <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <link rel="stylesheet" type="text/css" media="screen" href="/public/stylesheets/main.css">
  <script src="//code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js" type="text/javascript" ></script>
  <script src="/public/javascripts/autocompleter.js" type="text/javascript"></script>

</head>

<body>

<div id="header">
  <h1>ТЗ для РТ</h1>
  <div id="options">
  </div>
</div>

<div id="content">
  <h1>Поиск людей</h1>

  <p>
  <div class="search-container">
    <div class="ui-widget">
      <input type="text" id="search" name="search" class="search" />
      <input type="submit" id="submit" name="Искать" class="button"/>
    </div>


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
