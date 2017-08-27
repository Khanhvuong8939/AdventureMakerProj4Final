<%-- 
    Document   : editGame
    Created on : 21-Aug-2017, 15:27:31
    Author     : nth15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="editGame.html">
            <input type="hidden" name="txtGameID" value="${game.gameID}"/>
            <table border="1">
                
                <tr>
                    <td>Tên Trò chơi</td>
                    <td><input type="text" name="txtGameName" value="${game.gameName}" pattern="[a-z0-9.- ]{3,}" title="Tên trò chơi phải 3 ký tự trở lên"/></td>
                </tr>
                <tr>
                    <td>Làm thế nào để chiến thắng</td>
                    <td>
                        <select name="selCustomWin">
                            <option value="TRUE" ${game.customWin ? "selected=true":""}>Thắng với số điểm cao nhất</option>
                            <option value="FALSE" ${game.customWin ? "":"selected=true"}>Thắng khi tới đích</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Mô tả trò chơi</td>
                    <td>
                        <textarea name="txtDescription" cols="8" rows="10" required="true">${game.description}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>Thời gian bắt đầu</td>
                    <td><input type="datetime" step="7" min="2014-09-08" name="txtStartTime" value="<fmt:formatDate pattern="MM/dd/yyyy kk:mm:ss" value="${game.gameDetails.startTime}"/>"/></td>
                </tr>
                <tr>
                    <td>Thời gian kết thúc</td>
                    <td><input type="datetime" step="7" min="2014-09-08" name="txtEndTime" value="<fmt:formatDate pattern="MM/dd/yyyy kk:mm:ss" value="${game.gameDetails.endTime}"/>"/></td>
                </tr>
                <tr>
                    <td>Địa điểm bắt đầu</td>
                    <td><input type="text" name="txtLocatStart" value="${game.gameDetails.locationStart}"/></td>
                </tr>
                <tr>
                    <td>Địa điểm kết thúc</td>
                    <td><input type="text" name="txtLocatEnd" value="${game.gameDetails.locationEnd}"/></td>
                </tr>
                <tr>
                    <td>Số lượng người chơi</td>
                    <td><input type="number" name="txtAmtP" value="${game.gameDetails.amtP}" pattern="[0-9]{1,}" title="Số lượng người chơi phải lớn hơn 0"/></td>
                </tr>
                <tr>
                    <td>Số lượng trạm</td>
                    <td><input type="number" name="txtAmtS" value="${game.gameDetails.amtS}" pattern="[0-9]{1,}" title="Số lượng trạm phải lớn hơn 0"/></td>
                </tr>
                <tr>
                    <td>Số lượng nhóm</td>
                    <td><input type="number" name="txtAmtT" pattern="[0-9]{1,}" title="Số lượng nhóm phải lớn hơn 0"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="action" value="Tiếp Theo"/></td>
                    <td><input type="submit" name="action" value="Trở về trang cá nhân"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
