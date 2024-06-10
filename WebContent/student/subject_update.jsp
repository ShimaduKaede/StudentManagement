<!-- 科目変更 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<%@include file="sidebar.jsp" %>

<h2>科目情報変更</h2>
<div id="create">
  <!-- 正しく入力されていたら科目登録完了画面に遷移 -->
  <form action="">
    <label for="cd">科目コード</label>
    <p id="cd">${code}</p>
    <label for="name">科目名</label>
    <input type="text" name="name" id="name" value="${name}" />
    <button type="submit">変更</button>
  </form>
</div>
<!-- 科目管理一覧に遷移 -->
<a href="">戻る</a>

<%@include file="../footer.jsp" %>
