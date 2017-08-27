<%-- 
    Document   : register
    Created on : 10-Aug-2017, 20:36:28
    Author     : nth15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adventure Maker | Register</title>
    </head>
    <body>
        <form action="register.html" method="POST" onsubmit="return verify()">
            <table>
                <tr>
                    <td>Tài Khoản : </td>
                    <td><input type="text" name="txtID" required="true" id="txtIDRegis" value="${ID}" pattern="[A-Za-z0-9]{3,20}"/></td>
                    <td><b>${message}</b></td>
                </tr>
                <tr>
                    <td>Mật Khẩu : </td>
                    <td><input type="password" name="txtPwd" id="txtPwdRegis1" required="true" pattern="[A-Za-z0-9]{3,20}"/></td>
                    <td style="color: red" id="note1"></td>
                </tr>
                <tr>
                    <td>Nhập Lại Mật Khẩu : </td>
                    <td><input type="password" name="txtPwd" id="txtPwdRegis2" required="true" onBlur="check_pass()" pattern="[A-Za-z0-9]{3,20}"/></td>
                    <td style="color: red" id="note2"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Đăng kí" name="action"/></td>
                    <td><input type="reset" value="Reset"/></td>
                </tr>
            </table>
        </form>
        <form method="POST" action="registerFromExcel.html" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Chọn File Excel từ máy tính: </td>
                    <td><input type="file" name="file"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="action" value="Nhập dữ liệu từ Excel"/></td>
                </tr>
            </table>
        </form>
    </body>
    <script>
        function check_pass() {
            if (document.getElementById("txtPwdRegis1").value != document.getElementById("txtPwdRegis2").value) {
                document.getElementById("note2").innerHTML = "Mật khẩu không khớp nhau"
                return false;
            }
            else {
                document.getElementById("note2").innerHTML = ""
            }
        }
        function verify() {
            if (document.getElementById("note1").innerHTML != "" || document.getElementById("note2").innerHTML != "") {
                return false;
            }
        }
    </script>
</html>
