<!-- 成績管理一覧S -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.Student" %>
<%@ page import="bean.Subject" %>
<%@ page import="bean.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
 <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <h2>成績管理</h2>
    <div id="test_regist">
        <div id="search_test">
          <div id="search_subject" style="border-bottom: none;">
            <div id="search_test_input">
              <label for="f1">入学年度</label>
              <label for="f2">クラス</label>
              <label for="f3">科目</label>
              <label for="f4">回数</label>
              <form action="TestRegist.action">
              <% @SuppressWarnings("unchecked")
           List<Student> studentlist = (List<Student>) request.getAttribute("studentList");
		   List<Subject> subjectlist = (List<Subject>) request.getAttribute("subjectList");%>
                <select name="f1" id="f1">
                  <option value="null">------</option>
                  <% for (Student student: studentlist) { %>
              			<option value="<%=student.getEntYear() %>"><%=student.getEntYear() %></option>
              	  <% } %>
                </select>

                <select name="f2" id="f2">
            <option value="null">------</option>
               <% for (Student student: studentlist) { %>
              <option value="<%=student.getClassNum() %>"><%=student.getClassNum() %></option>
              <% } %>
                </select>

                <select name="f3" id="f3">
            <option value="null">------</option>
               <% for (Subject subject: subjectlist) { %>
              <option value="<%=subject.getSubjectName() %>"><%=subject.getSubjectName() %></option>
              <% } %>
                </select>

                <select name="f4" id="f4">
                  <option value="1">1</option>
                  <option value="2">2</option>
                </select>
                <button type="submit">検索</button>
              </form>
            </div>
          </div>
        </div>
      </div>

         <%
         @SuppressWarnings("unchecked")
  			List<Test> testregistList = (List<Test>) request.getAttribute("testregistList");
  			if (testregistList != null) { %>

      <div id="search_result">
      <form action=TestRegistExecute.action">
      <p>科目:${subject_name}(${no}回)</p>
      <table>
        <tr>
          <th>入学年度</th>
          <th>クラス</th>
          <th>学生番号</th>
          <th>氏名</th>
          <th>点数</th>
        </tr>

    		<% for (Test test : testregistList) {
  			%>
        <tr>
          <td>${ent_year}</td>
          <td>${class_num}</td>
          <td><%= test.getStudentno() %></td>
          <td><%= test.getStudentname() %></td>
          <td><input type="text" name="" id="" value="<%=test.getPoint() %>" /></td>
        </tr>

        <%
        }
        %>
                      </table>
        <button type="submit">登録して完了</button>
        </form>
        <%
  			}else{
    		%>
<%} %>
    </div>
    </div>
  </div>
</div>

<%@include file="../footer.jsp" %>
