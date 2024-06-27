<!-- 科目登録完了P35 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>

<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <div id="logout">
      <h2>科目情報登録</h2>
      <p>変更が完了しました</p>
      <div id="done">
        <a href="SubjectCreate.action">戻る</a>
        <a href="SubjectList.action">科目一覧</a>
      </div>
    </div>
  </div>
</div>

<%@include file="../footer.jsp" %>
