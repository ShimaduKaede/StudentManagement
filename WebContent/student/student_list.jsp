<!-- 学生管理一覧 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<%@include file="sidebar.jsp" %>

<h2>学生管理</h2>
<a href="">新規登録</a>
<form action="">
  <div id="search">
    <label for="f1"><p>入学年度</p></label>
    <label for="f2"><p>クラス</p></label>
    <label for="f3"><p>在学中</p></label>
    <div id="searchselect">
      <!-- 入学年度 -->
      <select name="f1" id="f1">
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
      <!-- クラス -->
      <select name="ent_year" id="ent_year">
        <option value="">--------</option>
        <option value="131">131</option>
      </select>
      <!-- 在学中のチェックボックス -->
      <input type="checkbox" name="f3" id="f3" />
      <button type="submit">絞込み</button>
    </div>
  </div>
</form>

<!-- 一覧 -->
<p id="search_sum">検索結果:<%=>件</p>
<div id="search_result">
  <table>
    <tr>
      <th>入学年度</th>
      <th>学生番号</th>
      <th>氏名</th>
      <th>クラス</th>
      <th>在学中</th>
      <th>　　　</th>
    </tr>
    <% for (Student p : list) { %>
    <tr>
      <td><%=p.getId() %></td>
      <td><%=p.getName() %></td>
      <td>
        <%=p.getCourseId()==1?"システム開発":"AIシステム・データサイエンス" %>
      </td>
      <td><a href="">変更</a></td>
    </tr>
    <% } %>
  </table>
</div>

<%@include file="../footer.jsp" %>
