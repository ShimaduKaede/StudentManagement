<!-- エラーページP41 -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.Teacher" %>
<%@ page import="tool.Utl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %> <%@include file="../header.jsp" %>

<%  // セッションから学校情報を取得
	Utl utl = new Utl();
	Teacher teacher = utl.getUser(request);

	// Schoolがnullの場合の処理
	if (teacher.getSchoolCd() != null) { %>

<div id="main">
  <%@include file="sidebar.jsp" %>
  <div id="contents">
    <div id="error">
      <ul>
        <li>エラーが発生しました</li>
      </ul>
    </div>
  </div>
</div>
<%  } else{ %>
<div id="main">
  <div id="contents_login">
    <div id="error">
      <ul>
        <li>エラーが発生しました</li>
      </ul>
    </div>
  </div>
</div><%} %>
<%@include file="../footer.jsp" %>
