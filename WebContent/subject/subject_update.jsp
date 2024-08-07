<!-- 科目変更 -->
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>

  <div id="contents">
    <h2>科目情報変更</h2>
    <div id="update">
      <!-- 正しく入力されていたら科目登録完了画面に遷移 -->
      <form action="SubjectUpdateExecute.action">
        <label for="cd">科目コード</label>
        <p id="cd">${subjectCd}</p>
        <label for="name">科目名</label>
        <input required type="text" name="name" id="name" value="${subjectName}" maxlength="20"/>
        <input type="hidden" name="cd" value="${subjectCd}">

        <c:if test="${not empty error_message}">
      <div class="error_message">${error_message}</div>
    </c:if>

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
