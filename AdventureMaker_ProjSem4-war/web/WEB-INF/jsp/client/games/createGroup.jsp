<%-- 
    Document   : createGroup
    Created on : 27-Aug-2017, 10:06:07
    Author     : nth15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nhóm mới</h1>
        <form method="POST" action="createGroup.html">
            <table border="1">
                <tr>
                    <td>Tên nhóm</td>
                    <td><input type="text" name="groupName" required="true"/></td>
                </tr>
                <tr>
                    <td>Mô tả</td>
                    <td><input type="text" name="description" required="true"/></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="action" value="Tạo nhóm"/>
                    </td>
                    <td>
                        <input type="submit" name="action" vavalue="Trở về"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
