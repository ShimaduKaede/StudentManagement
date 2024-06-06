<!-- ログイン -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<%@include file="sidebar.jsp" %>
<form action="">
  <h2>画面タイトル</h2>
  <input type="text" name="id" id="id" />
  <input type="text" name="password" id="password" />
  <input type="checkbox" name="chk_d_ps" id="chk_d_ps" />
  <label for=""></label>
</form>

<%@include file="../footer.jsp" %>
