<%-- 
    Document   : createGame
    Created on : 11-Aug-2017, 11:41:14
    Author     : nth15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adventure Maker | Game</title>
    </head>
    <body>
        <h1>Tạo Trò chơi mới</h1>
        <h2>Bước 1</h2>
        <form method="POST" action="createGame.html">
            <table border="1">
                <tr>
                    <td>Tên Trò chơi</td>
                    <td><input type="text" name="txtGameName" required="true" pattern="[a-z0-9. -]{3,}" title="Tên trò chơi phải 3 ký tự trở lên"/></td>
                </tr>
                <tr>
                    <td>Làm thế nào để chiến thắng</td>
                    <td>
                        <select name="selCustomWin">
                            <option value="TRUE">Thắng với số điểm cao nhất</option>
                            <option value="FALSE">Thắng khi tới đích</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Mô tả trò chơi</td>
                    <td>
                        <textarea name="txtDescription" cols="8" rows="10" required="true"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>Thời gian bắt đầu</td>
                    <td><input type="text" name="txtStartTime" required="true" pattern="(0[1-9]|1[012])/(0[1-9]|1[0-9]|2[0-9]|3[01])/([0-9]{4}) (0[1-9]|1[0-9]|2[0-4]):(0[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]):(0[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])" title="Ngày phải được lưu theo định dạng sau: MM/dd/yyyy hh:mm:ss"/></td>
                </tr>
                <tr>
                    <td>Thời gian kết thúc</td>
                    <td><input type="text" name="txtEndTime" required="true" pattern="(0[1-9]|1[012])/(0[1-9]|1[0-9]|2[0-9]|3[01])/([0-9]{4}) (0[1-9]|1[0-9]|2[0-4]):(0[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]):(0[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])" title="Ngày phải được lưu theo định dạng sau: MM/dd/yyyy hh:mm:ss"/></td>
                </tr>
                <tr>
                    <td>Địa điểm bắt đầu</td>
                    <td><input type="text" name="txtLocatStart" required="true"/></td>
                </tr>
                <tr>
                    <td>Địa điểm kết thúc</td>
                    <td><input type="text" name="txtLocatEnd" required="true"/></td>
                </tr>
                <tr>
                    <td>Số lượng người chơi</td>
                    <td><input type="number" name="txtAmtP" required="true" min="1" max="1000" title="Số lượng người chơi phải lớn hơn 0"/></td>
                </tr>
                <tr>
                    <td>Số lượng trạm</td>
                    <td><input type="number" name="txtAmtS" required="true" min="1" max="1000" title="Số lượng trạm phải lớn hơn 0"/></td>
                </tr>
                <tr>
                    <td>Số lượng nhóm</td>
                    <td><input type="number" name="txtAmtT" required="true" min="1" max="1000" title="Số lượng nhóm phải lớn hơn 0"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="action" value="Tiếp theo"/></td>
                    <td><input type="submit" name="action" value="Trở về" formnovalidate=""/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
