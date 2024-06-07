<!-- 学生変更 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<%@include file="sidebar.jsp" %>

<h2>学生情報変更</h2>
<label for="ent_year">入学年度</label>
<p id="ent_year"><%=></p>

<label for="no">学生番号</label>
<p id="no"><%=></p>
<form action="">
  <label for="name">氏名</label>
  <input type="text" name="name" id="name" />

  <label for="class_num">クラス</label>
  <select name="class_num" id="class_num">
    <% for () %>
    <option value="<%=>"><%=></option>
  </select>
  <label for="si_attend">在学中</label>
  <input type="checkbox" name="si_attend" id="si_attend" />

  <button type="submit">変更</button>
</form>

<a href="">戻る</a>

<%@include file="../footer.jsp" %>
