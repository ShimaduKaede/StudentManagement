<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
<div id="main">
<%@include file="sidebar.jsp" %>
  <div id="contents">
    <h2>科目情報登録</h2>

    <c:if test="${not empty message}">
      <div class="alert alert-info">${message}</div>
    </c:if>

    <div id="student_create">
      <form action="SubjectCreateExecute.action">

        <label for="cd">科目コード</label>
        <input
          type="text"
          name="SubjectCd"
          id="cd"
          placeholder="科目コードを入力してください"
          required
        />
        <label for="name">科目名</label>
        <input
          type="text"
          name="SubjectName"
          id="name"
          required
          placeholder="科目名を入力してください"
        />
        <div id="change">
          <button type="submit">登録</button>
        </div>
      </form>
    </div>
    <a href="SubjectList.action">戻る</a>
  </div>
</div>
<%@include file="../footer.jsp" %>
