<%-- 
    Document   : showInf
    Created on : 09-Aug-2017, 13:14:41
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
        <form action="redirectEditAccountDetails.html" method="post">
            <table>
                <tr>
                    <td>Account ID</td>
                    <td><input name="txtAccID" type="text" value="${accountDetails.accID}" disabled="true"/></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input name="txtFName" type="text" value="${accountDetails.accFirstN}"disabled="true"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input name="txtLName" type="text" value="${accountDetails.accLastN}"disabled="true"/></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <input name="txtGender" type="radio" value="${accountDetails.gender}" ${accountDetails.gender?'':'checked'} disabled="true"/>Male
                        <input name="txtGender" type="radio" value="${accountDetails.gender}" ${accountDetails.gender?'checked':''} disabled="true"/>Female
                    </td>
                </tr>
                <tr>
                    <td>Date of Birth</td>
                    <td><input name="txtDob" type="text" value="${accountDetails.doB}"disabled="true"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input name="txtEmail" type="text" value="${accountDetails.email}"disabled="true"/></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input name="txtPhone" type="text" value="${accountDetails.phone}"disabled="true"/></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input name="txtAddress" type="text" value="${accountDetails.address}"disabled="true"/></td>
                </tr>
                <tr>
                    <td>Company</td>
                    <td><input name="txtCompany" type="text" value="${accountDetails.company}"disabled="true"/></td>
                </tr>
                <tr>
                    <td>Group</td>
                    <td>${accountDetails.groupID.groupName}</td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <input name="txtAccId" type="hidden" value="${accountDetails.accID}"/>
                        <input type="submit" name="action" value="Cập nhật thông tin cá nhân"/>
                        <input type="submit" name="action" value="Thay đổi mật khẩu"/>
                    </td>
                </tr>
            </table>
            <p>${message}</p>
    </body>
</html>
