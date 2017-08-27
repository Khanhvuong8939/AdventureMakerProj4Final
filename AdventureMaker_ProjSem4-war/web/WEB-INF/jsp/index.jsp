<%-- 
    Document   : index
    Created on : 09-Aug-2017, 02:50:27
    Author     : nth15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adventure Maker | Home</title>
    </head>
    ${message}
    <body>
        <h1>Login Form</h1>
        <form action="loginAccounts.html" method="post" >
            
            <table border="1">
                <tr>
                    <td>Tên đăng nhập:</td>
                    <td><input type="text" name="username" required></td>
                </tr>
                <tr>
                    <td>Mật khẩu:</td>
                    <td><input type="password" name="password" required></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="action" value="Đăng nhập"/>
                        <input type="submit" name="action" value="Đăng kí"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
