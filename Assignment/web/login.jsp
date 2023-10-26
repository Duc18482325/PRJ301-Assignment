<%-- 
    Document   : login
    Created on : Oct 7, 2023, 4:06:52 PM
    Author     : DUC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Login</title>
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
        <h2 style="color: orange">${requestScope.er}</h2>

        <form action="studentlogin" method="post">
            <table border='1px' style="background: white; margin-left: 37pc; padding: 20px 30px 70px 30px; border-radius: 25px;">
                <thead>

                    <tr>
                        <td style="display: flex; justify-content: center; border: none; font-weight: bold">Sign in Campus</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>    
                        <td>
                            <input type="email" require name="student_user" placeholder="Enter your gmail fpt" style="padding-right: 10px;"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="password" name="student_pass" placeholder="Enter your password" style="padding-right: 10px;"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" name="rem" value=""> Remember me
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Login" style="margin-left: 60px;"/>
                        </td>
                    </tr>                                         
                </tbody>         
            </table>
        </form>
    </body>
</html>
