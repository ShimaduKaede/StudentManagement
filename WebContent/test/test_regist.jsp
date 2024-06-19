<!-- 成績管理一覧S -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
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
                <select name="f1" id="f1">
                  <option value="2023">2023</option>
                </select>

                <select name="f2" id="f2">
                  <option value="101">101</option>
                </select>

                <select name="f3" id="f3">
                  <option value="国語">国語</option>
                </select>

                <select name="f4" id="f4">
                  <option value="1">1</option>
                </select>
                <button type="submit">検索</button>
              </form>
            </div>
          </div>
        </div>
      </div>
      <div id="search_result">
      <p>科目:国語(n回)</p>
      <table>
        <tr>
          <th>入学年度</th>
          <th>クラス</th>
          <th>学生番号</th>
          <th>氏名</th>
          <th>点数</th>
        </tr>
        <tr>
          <td>p.getEntYear()</td>
          <td>p.getClassNum()</td>
          <td>p.getNo()</td>
          <td>p.getName()</td>
          <td><input type="text" name="" id="" value="p.get()" /></td>
        </tr>
      </table>
    </div>
    </div>
  </div>
</div>

<%@include file="../footer.jsp" %>
