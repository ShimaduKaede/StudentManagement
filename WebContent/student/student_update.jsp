<!-- 学生変更 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <h2>学生情報変更</h2>
    <div id="student_create">
      <label for="ent_year">入学年度</label>
      <p id="ent_year">2023</p>

      <label for="no">学生番号</label>
      <p id="no">2372054</p>
      <form action="">
        <label for="name">氏名</label>
        <input required type="text" name="name" id="name" />

        <label for="class_num">クラス</label>
        <select name="class_num" id="class_num">
          <option value="a">131</option>
        </select>
        <div id="check_box">
          <label for="si_attend">在学中</label>
          <input required type="checkbox" name="si_attend" id="si_attend" />
        </div>
        <div id="change">
          <button type="submit">変更</button>
        </div>
      </form>

      <a href="">戻る</a>
    </div>
  </div>
</div>
<%@include file="../footer.jsp" %>
