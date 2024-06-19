<!-- 科目変更一覧 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <h2>科目管理</h2>
    <div id="search_result">
      <a href="SubjectCreate.action">新規登録</a>
      <table>
        <tr>
          <th>科目コード</th>
          <th>科目名</th>
          <th></th>
          <th></th>
          <% for () { %>
          <th><%=>回</th>
          <% } %>
        </tr>
        <% for (Student p : list) { %>
        <tr>
          <td><%=p.getCd() %></td>
          <td><%=p.getName() %></td>
          <td><a href="SubjectUpdate.action">変更</a></td>
          <td><a href="SubjectDelete.action">削除</a></td>
        </tr>
        <% } %>
      </table>
    </div>
  </div>
</div>

<%@include file="../footer.jsp" %>
