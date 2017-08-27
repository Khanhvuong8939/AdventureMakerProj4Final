<%-- 
    Document   : editInf
    Created on : 09-Aug-2017, 12:39:40
    Author     : nth15
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adventure Maker | Client Page</title>
    </head>
    <body>
        <form action="editAccountDetails.html" method="post">
            <table>
                <tr>
                    <td>Tên đăng nhập</td>
                    <td><input name="txtAccID" type="text" value="${accountDetais.accID}" disabled="true"/>
                        <input name="txtAccId" type="hidden" value="${accountDetais.accID}" readonly="true"/>
                    </td>
                </tr>
                <tr>
                    <td>Họ</td>
                    <td><input name="txtFName" type="text" value="${accountDetais.accFirstN}" required="true"/></td>
                </tr>
                <tr>
                    <td>Tên</td>
                    <td><input name="txtLName" type="text" value="${accountDetais.accLastN}" required="true"/></td>
                </tr>
                <tr>
                    <td>Giới tính</td>
                    <td><input name="txtGender" type="radio" value="Male" ${accountDetais.gender?'':'checked'} /> Nam
                        <input name="txtGender" type="radio" value="Female" ${accountDetais.gender?'checked':''} /> Nuwx</td>
                </tr>
                <tr>
                    <td>Ngày sinh</td>
                    <td><input name="txtDob" type="text" value="${accountDetais.doB}" required="true"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input name="txtEmail" type="email" value="${accountDetais.email}" required="true" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"/></td>
                </tr>
                <tr>
                    <td>Số điện thoại</td>
                    <td><input name="txtPhone" type="text" value="${accountDetais.phone}" required="true" pattern="[0-9]{9,20}" title="Số điện thoại phải từ 9 đến 20 kí tự"/></td>
                </tr>
                <tr>
                    <td>Địa chỉ</td>
                    <td><input name="txtAddress" type="text" value="${accountDetais.address}" required="true"/></td>
                </tr>
                <tr>
                    <td>Công ty</td>
                    <td><input name="txtCompany" type="text" value="${accountDetais.company}" required="true"/></td>
                </tr>
                <tr>
                    <td>Nhóm</td>
                    <td>
                        <select name="selgroupID">
                            <c:forEach items="${listGroup}" var="item">
                                <option value="${item.groupID}" ${item.groupName==accountDetais.groupID.groupName?'selected=true':''}>${item.groupName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>   
                <tr>
                    <td><input type="submit" name="action" value="Cập nhật"</td>
                    <td><input type="submit" name="action" value="Trở về"/></td>
                </tr>
            </table>
            <p>${message}</p>
    </body>
    <script>
        function validateForm() {
            var email = document.forms["editInfForm"]["txtEmail"].value;
            var atpos = email.indexOf("@");
            var dotpos = email.lastIndexOf(".");
            if (atpos < 1 || dotpost < atpost + 2 || dotpos + 2 >= email.length) {
                alert('invalid email format.');
                return false;
            }
        }
    </script>
</html>
