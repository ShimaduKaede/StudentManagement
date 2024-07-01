<!-- 科目別成績一覧 -->
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="../header.jsp" %>
<div id="main">
<%@include file="sidebar.jsp" %>
<div id="contents">
<h2>成績参照(科目)</h2>

<div id="test_list_student">
  <div id="search_test">
    <div id="search_subject">
      <p>科目情報</p>
      <div id="search_subject_input">
        <label for="f1">入学年度</label>
        <label for="f2">クラス</label>
        <label for="f3">科目</label>
        <form action="TestRegist.action">
          <select name="f1" id="f1">
            <option value="2023">2023</option>
          </select>

          <select name="f2" id="f2">
            <option value="101">101</option>
          </select>

          <select name="f3" id="f3">
            <option value="国語">国語</option>
          </select>

          <button type="submit">検索</button>
        </form>
      </div>
    </div>


  <div id="search_test">
    <div id="search_student">
      <p>学生情報</p>
      <div id="search_student_input">
        <div id="text_input">
        <label for="f4">学生番号</label>
        <form action="TestRegist.action">
          <input
            type="text"
            name="f4"
            id="f4"
            placeholder="学生情報を入力してください"/>
        </div>
          <button type="submit">検索</button>
        </form>
      </div>
    </div>
  </div>
</div>
</div>


<div id="search_result">
          <%
          @SuppressWarnings("unchecked")
  List<Test> testlist = (List<Test>) request.getAttribute("testList");%>
    <p>氏名:<c:out value="${studentName}"/>(<c:out value="${studentNo}"/>)</p>
    <table>
      <tr>
        <th>科目名</th>
        <th>科目コード</th>
        <th>回数</th>
        <th>点数</th>
      </tr>
      <%
      for (Test test: testlist) { %>
        <tr>
          <td><%= test.getSubjectname() %></td>
          <td><%= test.getSubject() %></td>
          <td><%= test.getTestNo() %></td>
          <td><%= test.getPoint() %></td>
        </tr>
        <%} %>
    </table>
  </div>
</div>
</div>
</div>
<%@include file="../footer.jsp" %>

