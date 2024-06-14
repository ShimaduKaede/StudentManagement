<!-- 科目登録 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <h2>科目情報登録</h2>

    <div id="student_create">
      <!-- 正しく入力されていたら科目登録完了画面に遷移 -->
      <form action="">
        <label for="cd">科目コード</label>
        <input
          type="text"
          name="cd"
          id="cd"
          placeholder="科目コードを入力してください"
          required
        />

        <label for="name">科目名</label>
        <input
          type="text"
          name="name"
          id="name"
          required
          placeholder="科目名を入力してください"
        />
        <div id="change">
          <button type="submit">登録</button>
        </div>
      </form>
    </div>
    <!-- 科目管理一覧に遷移 -->
    <a href="">戻る</a>
  </div>
</div>
<%@include file="../footer.jsp" %>
