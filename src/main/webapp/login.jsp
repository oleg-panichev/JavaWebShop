<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 25.02.14
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form name="auth" action="/login" method="POST">
        <table>
            <tr>
                <td>Login:</td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
