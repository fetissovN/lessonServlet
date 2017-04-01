<%@ page import="com.belhard.utils.StringUtils" %>
<%@ page import="com.belhard.utils.MessageUtils" %><%--
  Created by IntelliJ IDEA.
  User: Николай
  Date: 31.03.2017
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
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
                    $('#password1').attr('type', 'text');
                    $('#password2').attr('type', 'text');
                }else {
                    $('#password1').attr('type', 'password');
                    $('#password2').attr('type', 'password');
                }
            });
        });
    </script>
</head>

<body>

<div class="row">
    <div class="medium-6 medium-centered large-4 large-centered columns">

        <form action="/register" method="post">
            <div class="row column log-in-form">
                <h4 class="text-center">Register please</h4>
                <label>Name
                    <input type="text" name="name" placeholder="Андрей" value="${name}" required>
                </label>
                <label>Surname
                    <input type="text" name="surname" placeholder="Сидоров" value="${surname}" required>
                </label>
                <label>Phone
                    <input type="text" name="phone" placeholder="80333451671" value="${phone}" required>
                </label>
                <label>Email
                    <input type="email" name="email" placeholder="somebody@example.com" required><span style="color: red">${emailErr}</span>
                </label>
                <label>Password
                    <input id="password1" type="password"  name="password" placeholder="Password" required>
                </label>
                <label>Password again
                    <input id="password2" type="password"  name="confirm_password" placeholder="Password" required> <span id='message'></span>
                </label>
                <input id="show-password" type="checkbox"><label for="show-password">Show password</label>
                <input id="btnSubmit" type="submit" class="button expanded" value="Register">
                <!--TODO Forgot your password?-->
                <!--<p class="text-center"><a href="#">Forgot your password?</a></p>-->
                <p class="text-center"><a href="/">Log in</a></p>
                <script type="text/javascript">
                    $(function () {
                        $('#btnSubmit').click(function () {
                            var password = $('#password1').val();
                            var confirmPassword = $('#password2').val();
                            if (password != confirmPassword) {
                                $('#message').html(<%=MessageUtils.PASSWORD_MATCHING_ERROR%>).css('color', 'red');
                                return false;
                            }
                            if ($('#password1').val().length < 4){
                                $('#message').html(<%=MessageUtils.PASSWORD_LENGTH_ERROR%>).css('color', 'red');
                                return false;
                            }
                            return true;
                        });
                    });
                </script>

            </div>
        </form>
    </div>
</div>

</body>
</html>

