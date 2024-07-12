<!-- 学生別成績一覧 -->
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
    <h2>成績参照(学生)</h2>
<div id="test_list_student">
    <div id="search_test">
      <div id="search_subject">
        <p>科目情報</p>
        <div id="search_subject_input">
          <label for="f1">入学年度</label>
          <label for="f2">クラス</label>
          <label for="f3">科目</label>
          <form action="TestList_Subject.action">
           <% @SuppressWarnings("unchecked")
           List<Student> studentlistyear = (List<Student>) request.getAttribute("studentListyear");
           List<Student> studentlistclass = (List<Student>) request.getAttribute("studentListclass");
		   List<Subject> subjectlist = (List<Subject>) request.getAttribute("subjectList");%>

            <select name="f1" id="f1" required>
            <option value="null">------</option>
                  <% for (Student student: studentlistyear) { %>
              <option value="<%=student.getEntYear() %>"><%=student.getEntYear() %></option>
              <% } %>
            </select>

            <select name="f2" id="f2" required>
            <option value="null">------</option>
               <% for (Student student: studentlistclass) { %>
              <option value="<%=student.getClassNum() %>"><%=student.getClassNum() %></option>
              <% } %>
            </select>

            <select name="f3" id="f3" required>
            <option value="null">------</option>
               <% for (Subject subject: subjectlist) { %>
              <option value="<%=subject.getSubjectName() %>"><%=subject.getSubjectName() %></option>
              <% } %>
            </select>

            <button type="submit">検索</button>
          </form>
        </div>
      </div>
    </div>

    <div id="search_test">
      <div id="search_student">
        <p>学生情報</p>
        <div id="search_student_input">
          <div id="text_input">
          <label for="f4">学生番号</label>
          <form action="TestList_Student.action">
            <input
              type="text"
              name="f4"
              id="f4"
              placeholder="学生情報を入力してください"
               required
            />
          </div>
            <button type="submit">検索</button>
          </form>
        </div>
      </div>
    </div>
  </div>
                  <%
          @SuppressWarnings("unchecked")
  List<Test> testlist = (List<Test>) request.getAttribute("testList");
  if (testlist.size()!=0){%>
    <div id="search_result">
      <p>科目:${subjectname}</p>
      <table>
        <tr>
          <th>入学年度</th>
          <th>クラス</th>
          <th>学生番号</th>
          <th>氏名</th>
          <th>1回</th>
          <th>2回</th>
        </tr>
        <tr>



      <%
      for (Test test: testlist) { %>
        <tr>
          <td>${ent_year}</td>
          <td>${class_num}</td>
          <td><%= test.getStudentno() %></td>
          <td><%= test.getStudentname() %></td>
          <% if (test.getPoint()==0){ %>
          <td>-</td>
          <%
          }
          else{
          %>
          <td><%= test.getPoint() %>
          </td><%} %>

		            <% if (test.getPoint2()==0){ %>
          <td>-</td>
          <%
          }
          else{
          %>
          <td><%= test.getPoint2() %>
          </td><%} %>
        </tr>
        <%}} else{ %>
        <p>学生情報が存在しませんでした</p>
        <%} %>
      </table>
    </div>
  </div>
</div>

<%@include file="../footer.jsp" %>
