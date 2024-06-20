<!-- メインメニューP15 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>

<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <div class="menu">
      <h2>メニュー</h2>
      <div id="menu">
        <div id="student">
          <a href="StudentList.action">学生管理</a>
        </div>
        <div id="test">
          <p>成績管理</p>
          <a href="../test/TestRegist.action">成績登録</a><br />
          <a href="../test/TestList.action">成績参照</a>
        </div>
        <div id="subject">
          <a href="../subject/SubjectList.action">科目管理</a>
        </div>
      </div>
    </div>
  </div>
</div>

<%@include file="../footer.jsp" %>
