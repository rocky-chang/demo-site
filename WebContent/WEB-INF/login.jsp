<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ログイン画面</title>
</head>
<body>
<div id="content" align="center">
        <h3>ログイン</h3>
        <hr>

        <form name="fm" id="fm" method="post">

        <table border="1" cellpadding="0" cellspacing="0" width="300px">
            <tr>
                <td><label for="loginId">ログインID：</label></td>
                <td><input type="text" id="loginId" name="loginId"/></td>
            </tr>
            <tr>
                <td><label for="password">パスワード：</label></td>
                <td><input type="text" id="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="button" name="login" onclick="document.fm.action='login.do';document.fm.submit();" value="登録"/></td>
                <td><input type="button" name="regist" onclick="document.fm.action='toRegist.do';document.fm.submit();" value="アカウント新規登録"/></td>
            </tr>
            <tr>
                <td colspan="2"> <input type="text" name="message" id="message"/></td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>