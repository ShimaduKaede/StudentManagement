<!-- ログアウト -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <div id="logout">
      <h2>ログアウト</h2>
      <p>ログアウトしました</p>
      <br />
      <br />
      <a href="login.jsp">ログイン</a>
    </div>
  </div>
</div>
<%@include file="../footer.jsp" %>
