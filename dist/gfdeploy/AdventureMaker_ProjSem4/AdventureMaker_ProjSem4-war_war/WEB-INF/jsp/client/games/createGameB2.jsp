<%-- 
    Document   : createGameB2
    Created on : 11-Aug-2017, 12:42:56
    Author     : nth15
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entities.Stations"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Stations> listStation = new ArrayList<Stations>();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adventure Maker | Game</title>
    </head>
    <body>
        <h1>Tạo Trò chơi mới</h1>
        <h2>Bước 2</h2>
        <form method="POST" action="createGameB2Controller.html">
            <table border="1">
                <tr>
                    <td>Trạm</td>
                    <td>Vị Trí của trạm</td>
                    <td>Câu hỏi của trạm</td>
                    <td>Trưởng trạm</td>
                    <td></td>
                </tr>
                <c:forEach items="${listStation}" var="item" varStatus="itemStatus">
                    <tr>
                    <input type="hidden" name="txtGameID" value="${item.gameID.gameID}"/>
                        <td>Trạm ${itemStatus.count}</td>
                        <td><input type="text" name="txtLocat${item.stationID}" required="true"/></td>
                        <td><input type="text" name="txtQues${item.stationID}" required="true" pattern="[a-z0-9. -]{3,}" title="Tên trò chơi phải 3 ký tự trở lên"/></td>
                        <td>
                            <select name="txtAcc${item.stationID}">
                                <c:forEach items="${listAccountID}" var="item1">
                                    <option value="${item1.accID}">${item1.accID}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </c:forEach>
                <% session.setAttribute("station", listStation);%>
                <td><input type="submit" name="action" value="Tiep theo"/></td>
            </table>
        </form>
    </body>
</html>
