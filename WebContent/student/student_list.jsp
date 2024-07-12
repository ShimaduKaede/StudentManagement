<!-- 学生管理一覧 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>

<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <div id="student_list">
      <h2>学生管理</h2>
      <a href="StudentCreate.action"><p>新規登録</p></a>
      <form action="StudentSearch.action">
        <div id="search">
          <div id="entyearselect">
            <!-- 入学年度 -->
            <label for="f1">入学年度</label><br />
            <select name="f1" id="f1">
              <option value="0">--------</option>
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
            <p style="color:orange">${message}</p>
          </div>
          <!-- クラス -->
          <div id="classselect">
            <label for="f2">クラス</label><br />
            <select id="class_num" name="f2">
              <option value="0">--------</option>
              <c:forEach var="classItem" items="${classes}">
                  <option value="${classItem}">${classItem}</option>
              </c:forEach>
            </select>
          </div>
          <!-- 在学中のチェックボックス -->
		  <!-- チェックが入るとvalueの1が送信される -->
          <input type="checkbox" name="f3" id="f3" value="true"/>
          <label for="f3">在学中</label>
          <button type="submit">絞込み</button>
        </div>
      </form>

      <!-- 一覧 -->
      <c:choose>
            <c:when test="${resultCount == null || resultCount == 0}">
            	<p>学生情報は存在しませんでした</p>
            </c:when>
            <c:otherwise>
      <p id="search_sum">検索結果: <c:out value="${resultCount}" /> 件</p>
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
          <c:forEach var="student" items="${studentList}">
           <tr>
             <td>${student.entYear}</td>
             <td>${student.studentNo}</td>
             <td>${student.getStudentName()}</td>
             <td>${student.getClassNum()}</td>
	        <c:choose>
	            <c:when test="${student.isAttend}">
	                <td>〇</td>
	            </c:when>
	            <c:otherwise>
	                <td>✕</td>
	            </c:otherwise>
	        </c:choose>
             <!-- 学生の学番をリクエストパラメータとして付加してStudentUpdateActionを呼び出す -->
             <td><a href="StudentUpdate.action?studentNo=${student.studentNo}">変更</a></td>
           </tr>
          </c:forEach>
        </table>
      </div>
      </c:otherwise>
      </c:choose>
    </div>
  </div>
</div>
<%@include file="../footer.jsp" %>

