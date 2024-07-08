<!-- ログイン -->
<%@page contentType="text/html; charset=UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@include file="../header.jsp" %>
<div id="main">
  <%@include file="sidebar.jsp" %>

  <div id="contents">
    <div id="login">
      <form action="LoginExecute.action">
        <h2>ログイン</h2>
        <c:if test="${not empty error}">
<ul>
<li>ログインに失敗しました。IDまたはパスワードが正しくありません。</li>
</ul>
</c:if>
        <p>ID</p>
        <input
          type="text"
          name="id"
          id="id"
          placeholder="半角でご入力ください"
          maxlength="20"
          required
          pattern="^[0-9A-Za-z]+$"
        />
        <br />
        <p>パスワード</p>
        <input
          type="password"
          name="password"
          id="password"
          placeholder="20文字以内の半角英数字でご入力ください"
          maxlength="20"
          required
          pattern="^[0-9A-Za-z]+$"
        />
        <br />
        <label for="chk_d_ps">パスワード表示</label>
        <input type="checkbox" name="chk_d_ps" id="chk_d_ps" onclick="togglePassword()"/>
        <br />
        <button type="submit">ログイン</button>
      </form>
    </div>
  </div>
</div>
<%@include file="../footer.jsp" %>

<script>
    function togglePassword() {
        var passwordField = document.getElementById("password");
        if (passwordField.type == "password") {
            passwordField.type = "text";
        } else {
            passwordField.type = "password";
        }
    }
</script>
