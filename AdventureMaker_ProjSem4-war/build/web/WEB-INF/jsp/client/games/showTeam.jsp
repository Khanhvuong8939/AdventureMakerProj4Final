<%-- 
    Document   : showTeam
    Created on : 25-Aug-2017, 20:29:34
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
        <h1>${game.gameName}</h1>
        <c:if test="${listTeam[(size-1)].teamName ==null}">
            <form method="POST" action="createTeam.html">
                <table border="1">
                    <tr>
                    <input type="hidden" name="gameID" value="${game.gameID}"/>
                    <td><input type="text" name="teamName"/></td>
                    <td><input type="submit" name="action" value="Tạo đội"/></td>
                    </tr>
                </table>
            </form>
        </c:if>

        <h2 style="color: red">${message}</h2>
        <c:if test="${listTeam[0].teamName !=null}">
            <table border="1">
                <tr>
                    <td>Mã Team</td>
                    <td>Tên Team</td>
                    <td>Action</td>
                </tr>
                <c:forEach items="${listTeam}" var="team">
                    <c:if test="${team.teamName !=null}">
                        <form method="POST" action="createTeamB2.html">
                            <tr>
                                <td>${team.teamID}</td>
                                <td>${team.teamName}</td>
                                <td>
                                    <input type="hidden" name="teamID" value="${team.teamID}"/>
                                    <input type="submit" value="Chọn đội" name="action"/>
                                </td>
                            </tr>
                        </form>
                    </c:if>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>
