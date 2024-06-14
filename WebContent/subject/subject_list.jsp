<!-- 科目変更一覧 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<%@include file="sidebar.jsp" %>

<h2>科目管理</h2>
<a href="">新規登録</a>
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
    <td><a href="">変更</a></td>
    <td><a href="">削除</a></td>
  </tr>
  <% } %>
</table>

<%@include file="../footer.jsp" %>