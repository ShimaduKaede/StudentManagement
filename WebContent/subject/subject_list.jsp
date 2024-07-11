<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<%@ page import="bean.Subject" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<div id="main">
  <%@ include file="sidebar.jsp" %>
  <div id="contents">
    <div id="search_result">
<h2>科目管理</h2>
<div id="search_a">
<a href="SubjectCreate.action" class="btn btn-secondary">新規登録</a>
</div>
<table>
  <tr>
    <th>科目コード</th>
    <th>科目名</th>
    <th></th>
    <th></th>
  </tr>

  <%
  @SuppressWarnings("unchecked")
  List<Subject> subjectList = (List<Subject>) request.getAttribute("subjectList");
  if (subjectList != null) {
    for (Subject s : subjectList) {
  %>
  <tr>
    <td><%= s.getSubjectCd() %></td>
    <td><%= s.getSubjectName() %></td>
    <td><a href="SubjectUpdate.action?cd=<%= s.getSubjectCd() %>&name=<%= java.net.URLEncoder.encode(s.getSubjectName(), "UTF-8") %>" class="btn btn-secondary">変更</a></td>
    <td><a href="SubjectDelete.action?cd=<%= s.getSubjectCd() %>&name=<%= java.net.URLEncoder.encode(s.getSubjectName(), "UTF-8") %>" class="btn btn-secondary">削除</a></td>

  </tr>
  <%
    }
  } else {
  %>
  <tr>
    <td colspan="4">表示する科目がありません。</td>
  </tr>
  <%
  }
  %>
</table>
</div>
</div>
</div>
<%@ include file="../footer.jsp" %>
