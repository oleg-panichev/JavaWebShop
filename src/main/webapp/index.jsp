<html>
<head>
    <title>JavaWebShop</title>
    <link type="text/css" rel="stylesheet" href="/mainStyle.css">
</head>
<body>
<div id="bg">
    <div id="outer">
        <div id="header">
            <a href="http://www.javawebshop.com/"><span class="header_text">JavaWebShop</span></a>
                <div id="search">
                    <form action="http://google.com/search">
                        <input class="text" name="q" size="32" maxlength="64" /><input class="button" type="submit" value="Search" />
                        <input type="hidden" name="sitesearch" value="javawebshop.com">
                    </form>
                </div>
        </div>

        <div id="data">
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
                <br><input type="submit" value="Submit"/>
            </form>


        </div>
    </div>
    <div id="copyright">
        &copy; <a href="http://vk.com/asinkingshipfullofoptimists">Oleg Panichev</a>
    </div>
</div>
</body>
</html>
