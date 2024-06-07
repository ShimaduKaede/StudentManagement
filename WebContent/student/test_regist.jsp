<!-- 成績管理一覧S -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<%@include file="sidebar.jsp" %>

<h2>成績管理</h2>

<div id="search">
  <form action="">
    <label for="f1">入学年度</label>
    <select name="f1" id="f1">
      <% for () %>
      <option value="<%=>"><%=></option>
    </select>

    <label for="f2">クラス</label>
    <select name="f2" id="f2">
      <% for () %>
      <option value="<%=>"><%=></option>
    </select>

    <label for="f3">科目</label>
    <select name="f3" id="f3">
      <% for () %>
      <option value="<%=>"><%=></option>
    </select>

    <label for="f4">回数</label>
    <select name="f4" id="f4">
      <% for () %>
      <option value="<%=>"><%=></option>
    </select>
    <button type="submit">検索</button>
  </form>
</div>

<%@include file="../footer.jsp" %>
