<%-- 
    Document   : attendance
    Created on : Oct 24, 2023, 6:05:14 PM
    Author     : DUC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Class:  <br> 
        Subject:at  <br>
        Time Slot: 
        <table border="2px" width="40%">
            <tr>
                <th>Name</th>
                <th>Code</th>
                <th>Class</th>
                <th>Subject</th><!-- comment -->
                <th>Time Slot</th>
                <th>Attendence</th>
                
            </tr>
            <tr>
                <td>${sessionScope.info.name}</td>
                <td>${sessionScope.info.code}</td>
                <td>${param.clss} at ${param.room}</td>
                <td> ${param.sub} </td>
                <td>${param.slots}</td>
                
            </tr>
            
        </table>
        
        
        <form>
            
        </form>
    </body>
</html>
