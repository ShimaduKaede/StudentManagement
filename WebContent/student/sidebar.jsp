<!-- サイドバー -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
  <!-- この前にログイン前の表記を追加すること -->
  <nav class="crumb">
    <ul>
      <li><a href="menu.jsp">メニュー</a></li>
      <li><a href="StudentList.action">学生管理</a></li>
      <li>成績管理</li>
      <div id="test_list">
        <li><a href="../test/TestRegist.action">成績登録</a></li>
        <li><a href="../test/TestList.action">成績参照</a></li>
      </div>
      <li><a href="../subject/SubjectList.action">科目管理</a></li>
    </ul>
  </nav>
</div>
