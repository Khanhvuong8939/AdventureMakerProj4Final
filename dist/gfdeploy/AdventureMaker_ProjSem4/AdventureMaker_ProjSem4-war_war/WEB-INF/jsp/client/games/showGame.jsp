<%-- 
    Document   : showGame
    Created on : 09-Aug-2017, 02:54:19
    Author     : nth15
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adventure Maker | Game</title>
    </head>
    <body>
        <h1>${message}</h1>
        <h1>Trò chơi</h1>
        <a href="redirectCreateGame.html" style="text-decoration: none"><input type="button" value="Tạo Trò chơi mới"/></a>
        <table border="1">
            <tr>
                <th>Tên Game</th>
                <th>Cách chơi</th>
                <th></th>
            </tr>
            <c:forEach items="${listOwner}" var="i">
                <tr>
                    <td>${i.gameName}</td>
                    <td>
                        ${i.customWin?"Thắng với số điểm cao nhất":"Thắng khi tới đích"}
                    </td>
                    <td>
                        <a href="showgamedetails.html?id=${i.gameID}" style="text-decoration: none"><input type="button" value="Chi tiết"></a>
                        <a href="redirectEditGame.html?id=${i.gameID}" style="text-decoration: none"><input type="button" value="Chỉnh sửa"></a>
                        <c:if test="${i.status == false}">
                            <a href="redirectCreateTeam.html?id=${i.gameID}" style="text-decoration: none"><input type="button" value="Tạo đội"></a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            <c:forEach items="${listPlayer}" var="i2">
                <tr>
                    <td>${i2.gameName}</td>
                    <td>
                        ${i2.customWin?"Thắng với số điểm cao nhất":"Thắng khi tới đích"}
                    </td>
                    <td>
                        <a href="showgamedetails.html?id=${i2.gameID}" style="text-decoration: none"><input type="button" value="Chi tiết"></a>
                        <c:if test="${i2.status == false}">
                            <a href="redirectCreateTeam.html?id=${i2.gameID}" style="text-decoration: none"><input type="button" value="Tạo đội"></a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>

        </table>
        </table>
    </body>
</html>
