    <%-- 
    Document   : index
    Created on : Oct 18, 2023, 5:48:48 PM
    Author     : DUC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>FAP</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="head"> 
            <div>
                <h2>FPT University Academic Portal</h2>
            </div>
            <div class="link">
                <table>
                    <tbody>
                        <tr>
                            <h4>FAP mobile (myFAP) is ready at</h4>
                        </tr>
                        <tr>
                            <td>
                                <a href="https://apps.apple.com/app/id1527723314">
                                <img src="images/apple-app-store-logo.jpg" width="130px" height="40px"/>
                                </a>
                            </td>
                            <td>
                                <a href="https://play.google.com/store/apps/details?id=com.fuct">
                                <img src="images/google play.png" width="130px" height="40px"/>
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        
        <div class="body1" style="display: flex; justify-content: center">
            <div style="margin-right: 20px">
                <form action="login" method="post">
                <table border="1px" style="width: 30pc">
                <tbody>
                    <tr>
                        <td style="background: orange; display: inline-flex; border-radius: 3px;"><h3 style="display: contents; color: white">Phụ huynh</h3></td>
                    </tr>
                    <tr>
                        <td>
                            <h3 style="margin-left: 12pc;">
                                    <a href="loginParents.jsp" style="background: cornflowerblue; color: white; text-decoration: none; font-weight: 100; padding: 5px; border-radius: 10px;">Đăng nhập</a>

                            </h3>
                        </td>
                    </tr>
                </tbody>
            </table>
            </form>
            </div>
            
            <div style="margin-left: 20px">
                <form action="studentlogin">
                <table border="1px" style="width: 30pc">
                <tbody>
                    <tr>
                        <td style="background: orange; display: inline-flex; border-radius: 3px;"><h3 style="display: contents; color: white">Sinh viên, Giảng viên, Cán bộ ĐH-FPT</h3></td>
                    </tr>
                    <tr>
                        <td>
                            <h3 style="margin-left: 8pc;">
                                <select class="op" name="op">
                                    <option value="campus">Select Campus</option>
                                    <option value="hoalac">FU-Hòa Lạc</option>
                                    <option value="HCM">FU-Hồ Chí Minh</option>
                                    <option value="danang">FU-Đà Nẵng</option>
                                    <option value="cantho">FU-Cần Thơ</option>
                                    <option value="quynhon">FU-Quy Nhơn</option>
                                </select>
                                
                                <button type="submit" >Đăng nhập</button>
                            </h3>
                            <h4>${requestScope.er}</h4>
                        </td>
                    </tr>
                </tbody>
            </table>
            </form>
            </div>
        </div>
                           <div style="margin-top: 50px;">
            <div>
                <p>Mọi góp ý, thắc mắc xin liên hệ: Phòng dịch vụ sinh viên: Email: dichvusinhvien@fe.edu.vn. Điện thoại: (024)7308.13.13</p>   
            </div>
            <div style="display: flex;
                 justify-content: center;
                 margin-top: 30px;">
                Prowered by 
                <a href="http://fpt.edu.vn/" style="margin: 0 0px 0 5px;
                   text-decoration: none;">FPT University |</a>
                <a href="http://cms.fpt.edu.vn/" style="margin: 0 0px 0 5px;
                   text-decoration: none;">CMS |</a>
                <a href="http://library.fpt.edu.vn/" style="margin: 0 0px 0 5px;
                   text-decoration: none;">Library |</a>
            </div>
        </div>
    </body>
</html>

