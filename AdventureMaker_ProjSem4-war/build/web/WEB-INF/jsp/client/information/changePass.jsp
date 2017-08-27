<%-- 
    Document   : changePass
    Created on : 10-Aug-2017, 14:06:49
    Author     : nth15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adventure Maker | Client Page</title>
    </head>
    <body>
        <h1>Change Password!</h1>
        <form name="formChangePassword" action="changePassword.html" method="post" onsubmit=" return validateForm();">
            <table>
                <tr>
                    <td>Account ID</td>
                    <td><input name="txtAccID" type="text" value="${txtAccID}" disable="true"/>
                        <input name="txtAccID" type="hidden" value="${txtAccID}"/>
                    </td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input name="txtPassword" type="password" required="true"/></td>
                </tr>
                <tr>
                    <td>Password confirm</td>
                    <td><input name="txtPasswordConfirm" type="password" required="true"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Change Password"</td>
                    <td><input type="reset" value="Reset"/></td>
                </tr>
            </table>
            <p>${message}</p>
        </form>
    </body>
    <script>
        function validateForm() {
            var pwd = document.forms["formChangePassword"]["txtPassword"].value;
            var pwdConfirm = document.forms["formChangePassword"]["txtPasswordConfirm"].value;
            if (pwd !== pwdConfirm) {
                alert('Password and password confirm is difference');
                return false;
            }
        }
    </script>
</html>
