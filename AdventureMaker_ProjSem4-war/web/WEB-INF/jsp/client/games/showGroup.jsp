<%-- 
    Document   : showGroup
    Created on : 27-Aug-2017, 09:16:48
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
        <h1>Danh sách các nhóm</h1>
        <form method="POST" action="redirectCreateGroup.html">
            <input type="submit" value="Tạo nhóm mới"/>
        </form>
        <table border="1">
            <tr>
                <td>Tên</td>
                <td>Mô tả</td>
                <td></td>
            </tr>
            <c:forEach items="${listGroup}" var="item">
                <form method="POST" action="actionOnGroup.html">
                    <tr>
                        <td>${item.groupName}</td>
                        <td>${item.description}</td>
                        <td>
                            <input type="hidden" name="groupID" value="${item.groupID}"/>
                            <input type="submit" value="Danh sách thành viên"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>    
        <c:if test="${listMem !=null}">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Tên</td>
                </tr>
                <c:forEach items="${listMem}" var="item">
                    <tr>
                        <td>${item.accID}</td>
                        <td>${item.accFirstN} ${item.accLastN}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
