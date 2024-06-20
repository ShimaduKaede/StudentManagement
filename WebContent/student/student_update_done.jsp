<!-- 学生変更完了P22 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>

  <div id="contents">
    <div id="logout">
      <h2>学生情報変更</h2>
      <p>変更が完了しました</p>
      <div id="done">
        <a href="StudentList.action">学生一覧</a>
      </div>
    </div>
  </div>
</div>

<%@include file="../footer.jsp" %>
