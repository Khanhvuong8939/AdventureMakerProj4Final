<%-- 
    Document   : editGameB2
    Created on : 21-Aug-2017, 15:28:46
    Author     : nth15
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                        <td><input type="text" name="txtLocat${item.stationID}" value="${item.locationStation}" /></td>
                        <td><input type="text" name="txtQues${item.stationID}" value="${item.keyQuestion}"/></td>
                        <td>
                            <select name="txtAcc${item.stationID}">
                                <c:forEach items="${listAccountID}" var="item1">
                                    <option value="${item1.accID}" ${item.accID.accID==item1.accID?"selected=true":""}>${item1.accID}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </c:forEach>
                <td><input type="submit" name="action" value="Tiep theo"/></td>
            </table>
        </form>
    </body>
</html>
