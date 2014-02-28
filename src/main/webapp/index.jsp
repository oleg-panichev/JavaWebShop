<html>
<head>
    <title>JavaWebShop</title>
    <link type="text/css" rel="stylesheet" href="/mainStyle.css">
</head>
<body>
    <% request.getSession(false); %>
    <h2>Hello!</h2></br>
    <p>Please, log in!</p>
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
