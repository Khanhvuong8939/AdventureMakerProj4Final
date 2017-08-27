<%-- 
    Document   : showGameDetail
    Created on : 14-Aug-2017, 15:56:20
    Author     : nth15
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adventure Maker | Game</title>
    </head>
    <body>
        <h1>Game Details</h1>
        <table border="1">
            <tr>
                <th>Tên trò chơi</th>
                <th>Người tạo</th>
                <th>Cách chơi</th>
                <th>Thời gian bắt đầu</th>
                <th>Thời gian kết thúc</th>
                <th>Vị trí bắt đầu</th>
                <th>Vị trí kết thúc</th>
                <th>Thông tin</th>
            </tr>
            <tr>
                <td>${game.gameName}</td>
                <td>${game.accID.accountDetails.accFirstN} ${game.accID.accountDetails.accLastN}</td>
                <td>${game.customWin?"Thắng với số điểm cao nhất":"Thắng khi tới đích"}</td>
                <td><fmt:formatDate pattern="MM/dd/yyyy kk:mm:ss" value="${game.gameDetails.startTime}"/></td>
                <td><fmt:formatDate pattern="MM/dd/yyyy kk:mm:ss" value="${game.gameDetails.endTime}"/></td>
                <td>${game.gameDetails.locationStart}</td>
                <td>${game.gameDetails.locationEnd}</td>
                <td>${game.description}</td>
            </tr>
        </table>
        <h1>Team</h1>
        <table border="1">
            <tr>
                <th>Đội chơi</th>
                <th>Người chơi</th>
            </tr>
            <c:forEach items="${game.teamsCollection}" var="i">
                <tr><td><c:out value="${i.teamName}">${i.win?"(Winner)":""}</c:out></td>
                    <c:forEach items="${i.accountsCollection}" var="i2">
                        <td>${i2.accountDetails.accFirstN} ${i2.accountDetails.accLastN}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        <h1>Trạm</h1>
        <table border="1">
            <tr>
                <th>Trạm </th>
                <th>Vị trí</th>
                <th>Câu hỏi</th>
                <th>Người quản trạm</th>
            </tr>

            <c:forEach items="${game.stationsCollection}" var="i">
                <tr>
                    <td>${i.stationID}</td>
                    <td>${i.locationStation}</td>
                    <td>${i.keyQuestion}</td>
                    <td><c:if test="${not empty i.accID}">${i.accID.accountDetails.accFirstN} ${i.accID.accountDetails.accLastN}</c:if></td>
                    </tr>
            </c:forEach>
        </table>
        <form method="POST" action="goBackClient.html">
            <input type="submit" name="action" value="Trở về"/>
        </form>
    </body>
</html>
