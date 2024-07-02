<!-- 成績参照検索 -->
<%@page contentType="text/html; charset=UTF-8" %>
<%@ page import="bean.Student" %>
<%@ page import="bean.Subject" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
           List<Student> studentlist = (List<Student>) request.getAttribute("studentList")
		   List<Subject> subjectlist = (List<Subject>) request.getAttribute("subjectList");%>

            <select name="f1" id="f1">
                  <% for (Student student: studentlist) { %>
              <option value="<%=student.getEntYear() %>">2023</option>
              <% } %>
            </select>

            <select name="f2" id="f2">
              <option value="131">131</option>
            </select>

            <select name="f3" id="f3">
              <option value="国語">国語</option>
              <option value="数学">数学</option>
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
            />
          </div>
            <button type="submit">検索</button>
          </form>
        </div>
      </div>
    </div>
  </div>


<%@include file="../footer.jsp" %>
