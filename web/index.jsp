<%--
  Created by IntelliJ IDEA.
  User: Николай
  Date: 31.03.2017
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <meta charset="utf-8">
    <!--<link rel="stylesheet" type="text/css" href="css/index.css">-->
    <link rel="stylesheet" type="text/css" href="css/foundation.css">
    <link rel="stylesheet" type="text/css" href="css/foundation.min.css">
    <link rel="stylesheet" type="text/css" href="css/app.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#show-password').click(function() {
                if ($('#show-password').is(':checked')){
                    $('#password').attr('type', 'text');
                }else {
                    $('#password').attr('type', 'password');
                }
            });
        });
    </script>

</head>

<body>

<div class="row">
    <div class="medium-6 medium-centered large-4 large-centered columns">

        <form action="/hello.do" method="post">
            <div class="row column log-in-form">
                <h4 class="text-center">Log in with you email account</h4>
                <span style="color: red">${wrongLogin}</span>
                <label>Email
                    <input type="email" name="txt_first_name" placeholder="somebody@example.com" required>
                </label>
                <label>Password
                    <input id="password" type="password"  name="txt_last_name" placeholder="Password" required>
                </label>
                <input id="show-password" type="checkbox"><label for="show-password">Show password</label>
                <input type="submit" class="button expanded" value="Log in">
                <!--TODO Forgot your password?-->
                <!--<p class="text-center"><a href="#">Forgot your password?</a></p>-->
                <p class="text-center"><a href="/register">Sign in!</a></p>

            </div>
        </form>
    </div>
</div>
</body>
</html>

