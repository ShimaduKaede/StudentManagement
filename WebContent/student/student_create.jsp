<!-- 学生登録 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<%@include file="sidebar.jsp" %>

<h2>学生情報登録</h2>
<form action="">
  <label><p>入学年度</p></label>
  <select name="ent_year" id="ent_year">
    <option value="">--------</option>
    <option value="2014">2014年度</option>
    <option value="2015">2015年度</option>
    <option value="2016">2016年度</option>
    <option value="2017">2017年度</option>
    <option value="2018">2018年度</option>
    <option value="2019">2019年度</option>
    <option value="2020">2020年度</option>
    <option value="2021">2021年度</option>
    <option value="2022">2022年度</option>
    <option value="2023">2023年度</option>
    <option value="2024">2024年度</option>
    <option value="2025">2025年度</option>
    <option value="2026">2026年度</option>
    <option value="2027">2027年度</option>
    <option value="2028">2028年度</option>
    <option value="2029">2029年度</option>
    <option value="2030">2030年度</option>
    <option value="2031">2031年度</option>
    <option value="2032">2032年度</option>
    <option value="2033">2033年度</option>
    <option value="2034">2034年度</option>
  </select>
  <label><p>学生番号</p></label>
  <input type="number" name="no" id="no" />
  <label><p>氏名</p></label>
  <input type="text" name="name" id="name" />
  <label><p>クラス</p></label>
  <input type="number" name="class_num" id="class_num" />
  <button type="submit" name="end">登録して終了</button>
</form>

<a href="">戻る</a>

<%@include file="../footer.jsp" %>