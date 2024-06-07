<!-- サイドバー -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="sidebar">
  <!-- この前にログイン前の表記を追加すること -->
  <nav class="crumb">
    <ul>
      <li><a href="">メニュー</a></li>
      <li><a href="">学生管理</a></li>
      <li>成績管理</li>
      <li><a href="">成績登録</a></li>
      <li><a href="">成績参照</a></li>
      <li><a href="">科目管理</a></li>
    </ul>
  </nav>
</div>

<%@include file="../footer.jsp" %>
