<!-- 科目登録 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <div id="delete">
      <h2>科目情報削除</h2>

      <p>
        「<c:out value="${subjectCd}" /> (
        <c:out value="${subjectName}" /> )」を削除してもよろしいですか？
      </p>

      <form action="SubjectDeleteExecute.action" method="post">
        <input
          type="hidden"
          name="subjectCd"
          value="<c:out value='${subjectCd}'/>"
        />
         <input
          type="hidden"
          name="subjectName"
          value="<c:out value='${subjectName}'/>"
        />
        <div id="delete_button">
          <button type="submit" class="btn btn-danger">削除</button>
        </div>
      </form>
      <div id="done">
        <a href="SubjectList.action" class="btn btn-secondary">戻る</a>
      </div>
    </div>
  </div>
</div>
<%@include file="../footer.jsp" %>