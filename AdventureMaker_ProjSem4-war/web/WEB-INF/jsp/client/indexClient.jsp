<%-- 
    Document   : indexClient
    Created on : 09-Aug-2017, 12:05:34
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
        <h1>${sessionScope.user}</h1>
        <form method="POST" action="clientAction.html">
            <% session.setAttribute("txtAccID", session.getAttribute("user")); %>
            <input type="submit" width="200px" height="60px" name="action" value="Thông tin cá nhân"/><br/>
            <input type="submit" width="200px" height="60px" name="action" value="Lịch sử trò chơi"/><br/>
            <input type="submit" width="200px" height="60px" name="action" value="Nhóm"/><br/>
        </form>
    </body>
</html>
