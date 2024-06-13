<!-- 科目登録 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<%@include file="sidebar.jsp" %>

<h2>科目情報登録</h2>

<div id="create">
  <!-- 正しく入力されていたら科目登録完了画面に遷移 -->
  <form action="">
    <label for="cd">科目コード</label>
    <input type="text" name="cd" id="cd" value="科目コードを入力してください" />

    <label for="name">科目名</label>
    <input type="text" name="name" id="name" value="科目名を入力してください" />
    <button type="submit">登録</button>
  </form>
</div>
<!-- 科目管理一覧に遷移 -->
<a href="">戻る</a>

<%@include file="../footer.jsp" %>
