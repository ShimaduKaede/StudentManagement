<!-- 学生別成績一覧 -->
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
<%@include file="sidebar.jsp" %>

<h2>成績参照(学生)</h2>

<div id="search">
  <p>科目情報</p>
  <form action="">
    <label for="f1">入学年度</label>
    <select name="f1" id="f1">
      <% for () %>
      <option value="<%=>"><%=></option>
      <% } %>
    </select>

    <label for="f2">クラス</label>
    <select name="f2" id="f2">
      <% for () %>
      <option value="<%=>"><%=></option>
      <% } %>
    </select>

    <label for="f3">科目</label>
    <select name="f3" id="f3">
      <% for () %>
      <option value="<%=>"><%=></option>
      <% } %>
    </select>

    <button type="submit">検索</button>
  </form>
</div>

<div id="search">
  <p>学生情報</p>
  <form action="">
    <label for="f4">学生番号</label>
    <input type="text" name="f4" id="f4" value="学生情報を入力してください" />
    <button type="submit">検索</button>
  </form>
</div>

<c:choose>
    <!--null時の書き方がわからないので一旦この書き方にしています -->
	<c:when "f4 =null ">
		<p>科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>

  </table>
	</c:when>
    <c:when "f4 !=null ">
    <h2>科目:<%=>(<%=>回)</h2>
    <table>
      <tr>
        <th>入学年度</th>
        <th>クラス</th>
        <th>学生番号</th>
        <th>氏名</th>
        <% for () { %>
        <th><%=>回</th>
        <% } %>
      </tr>
      <% for (Student p : list) { %>
        <tr>
          <td><%=p.getEntYear() %></td>
          <td><%=p.getClassNum() %></td>
          <td><%=p.getNo() %></td>
          <td><%=p.getName() %></td>
        </tr>
        <% } %>
    </table>
      </c:when>
	<c:otherwise>
		<p>科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>
	</c:otherwise>
</c:choose>







<%@include file="../footer.jsp" %>