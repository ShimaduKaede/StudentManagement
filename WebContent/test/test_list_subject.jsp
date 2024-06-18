<!-- 学生別成績一覧 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
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
          <form action="">
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
    </div>

    <div id="search_test">
      <div id="search_student">
        <p>学生情報</p>
        <div id="search_student_input">
          <div id="text_input">
          <label for="f4">学生番号</label>
          <form action="">
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

    <div id="search_result">
      <p>科目:国語(1回)</p>
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
          <td>p.getEntYear()</td>
          <td>p.getClassNum()</td>
          <td>p.getNo()</td>
          <td>p.getName()</td>
          <td></td>
          <td></td>
        </tr>
      </table>
    </div>
  </div>
</div>

<%@include file="../footer.jsp" %>
