<!-- 科目登録 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <div id="delete">
      <h2>科目情報削除</h2>

      <p>
        「<c:out value="${subjectName}" /> (
        <c:out value="${subjectCode}" /> )」を削除してもよろしいですか？
      </p>

      <form action="SubjectDelete.action" method="post">
        <input
          type="hidden"
          name="subjectCode"
          value="<c:out value='${subjectCode}'/>"
        />
        <button type="submit" class="btn btn-danger">削除</button>
      </form>

      <a href="SubjectList.action" class="btn btn-secondary">戻る</a>
    </div>
  </div>
</div>
<%@include file="../footer.jsp" %>
