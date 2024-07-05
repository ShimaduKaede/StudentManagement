<!DOCTYPE html>
<html
  xmlns:mso="urn:schemas-microsoft-com:office:office"
  xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882"
>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="../css/style.css" />
    <title>Servlet/JSP Samples</title>
  </head>
  <body>
    <%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>
    <div id="header">
      <h1>得点管理システム</h1>
      <div id="logout-name">
      	<% if (session.getAttribute("user") != null){%>
        <span>${user.teacherName}様</span>
        <a href="Logout.action">ログアウト</a>
        <%}%>
      </div>
    </div>

