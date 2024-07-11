<!-- 学生登録完了P19 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <div id="logout">
      <h2>学生情報登録</h2>
      <p>登録が完了しました</p>
      <div id="done">
        <a href="StudentCreate.action">戻る</a>
        <a href="StudentList.action">学生一覧</a>
      </div>
    </div>
  </div>
</div>
<%@include file="../footer.jsp" %>
