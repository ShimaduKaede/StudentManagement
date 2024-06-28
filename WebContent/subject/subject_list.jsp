<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<%@ include file="sidebar.jsp" %>
<%@ page import="bean.Subject" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<h2>科目管理</h2>
<a href="SubjectCreate.action" class="btn btn-secondary">新規登録</a>
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
    <td><a href="SubjectEdit.action?cd=<%= s.getSubjectCd() %>">変更</a></td>
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

<%@ include file="../footer.jsp" %>
