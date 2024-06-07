<!-- メインメニューP15 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<%@include file="sidebar.jsp" %>
<h2>メニュー</h2>
<div id="menu">
  <div id="student">
    <a href="">学生管理</a>
  </div>
  <div id="test">
    <p>成績管理</p>
    <a href="">成績登録</a>
    <a href="">成績参照</a>
  </div>
  <div id="subject">
    <a href="">科目管理</a>
  </div>
</div>

<%@include file="../footer.jsp" %>
