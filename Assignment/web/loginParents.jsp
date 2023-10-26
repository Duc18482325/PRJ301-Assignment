<%-- 
    Document   : loginParents
    Created on : Oct 7, 2023, 7:44:57 PM
    Author     : DUC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <style>
            body{
                background-image: url('images/fpt1.jpg');
                background-size: cover;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
        </style>
    </head>
    <body>
        <%
            if(request.getAttribute("error") != null){
                String error = (String)request.getAttribute("error");
         %>
         <h3 style="color: red"> <%= error%></h3>
         <%
            }
        %>
        <div class="head" style="display: flex;">
            <div>
                <img src="images/FptLogo.png" width="150px" height="80px"/>
            </div>
            <div>
                <h3 style="margin-left: 25pc; font-size: 35px; ">Academic Portal</h3>
            </div>
        </div>
        
        <div>
            <h3 style="border-bottom-color: #ede9e9; border-bottom-style: solid;" >Trang chủ</h3>
        </div>
        
        <div>
            <form action="parentslogin" method="post">
                
                <table border='1px' style="background: white; margin-left: 30pc; padding: 10px 20px 30px 20px; border-radius: 20px;">
                    <thead>
                        <tr style="background: orange;">
                            <td>
                                <h2 style="color: white;">Người dùng đăng nhập (Donor Login)</h2>
                            </td>
                        </tr>   
                    </thead>
                    <tbody>
                        <tr>
                            <td>Chọn cơ sở đào tạo:
                                <select>
                                    <option value="campus">--Chọn--</option>
                                    <option value="hoalac">FU-Hòa Lạc</option>
                                    <option value="hochiminh">FU-Hồ Chí Minh</option>
                                    <option value="danang">FU-Đà Nẵng</option>
                                    <option value="cantho">FU-Cần Thơ</option>
                                    <option value="quynhon">FU-Quy Nhơn</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="text" name="user" placeholder="Tên đăng nhập" required/></td>
                        </tr>
                        <tr>
                            <td><input type="password" name="pass" placeholder="Mật khẩu"/></td>
                        </tr>
                        <tr>
                            <td style="display: flex; justify-content: center;">
                                <input type="submit" value="Đăng nhập" style="background: #5555d0; color: white; border-radius: 5px;"/>
                                <input type="checkbox"/>Nhớ mật khẩu
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
