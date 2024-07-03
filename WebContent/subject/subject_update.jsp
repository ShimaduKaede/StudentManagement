<!-- 科目変更 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>

  <div id="contents">
    <h2>科目情報変更</h2>
    <div id="update">
      <!-- 正しく入力されていたら科目登録完了画面に遷移 -->
      <form action="SubjectUpateExecute.action">
        <label for="cd">科目コード</label>
        <p id="cd">"${subjectCd}"</p>
        <label for="name">科目名</label>
        <input type="text" name="name" id="id" required value="${subjectName}" />
        <div id="change">
          <button type="submit">変更</button>
        </div>
      </form>
    </div>
    <!-- 科目管理一覧に遷移 -->
    <a href="SubjectList.action">戻る</a>
  </div>
</div>
<%@include file="../footer.jsp" %>
