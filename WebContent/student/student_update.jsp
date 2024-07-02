<!-- 学生変更 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <h2>学生情報変更</h2>
    <div id="student_create">
    <form action="StudentUpdateExecute.action" method="post">
      <label for="ent_year">入学年度</label>
      <input type="text" name="ent_year" id="ent_year" value="${student.entYear}" readonly/>

      <label for="no">学生番号</label>
      <input type="text" name="no" id="no" value="${student.studentNo}" readonly/>

        <label for="name">氏名</label>
        <input required type="text" name="name" id="name" value="${student.studentName}" />

        <label for="class_num">クラス</label>
        <select id="class_num" name="class_num">
            <option value="">--------------</option>
            <c:forEach var="classItem" items="${classes}">
                <option value="${classItem}">${classItem}</option>
            </c:forEach>
        </select>
        <div id="check_box">
          <label for="si_attend">在学中</label>
          <input required type="checkbox" name="is_attend" id="is_attend" value="true" />
        </div>
        <div id="change">
          <button type="submit">変更</button>
        </div>
      </form>

      <a href="StudentList.action">戻る</a>
    </div>
  </div>
</div>
<%@include file="../footer.jsp" %>
