<%-- 
    Document   : list
    Created on : Oct 18, 2023, 1:12:35 AM
    Author     : DUC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List student</title>
    </head>
    <body>
        <%@include file="server.html" %>
        <div style="display: flex;
                            justify-content: space-evenly;
                            background: orange;
                            color: white;
                            font-size: larger;
                            border-radius: 30px;">
        
            <h4>Account: ${sessionScope.info.name}</h4>
      
        <h4><a href="server.jsp">Home</a></h4>
        <h4>Campus:   ${sessionScope.op}</h4>
        </div>
    <center>
        <h1 style="color: blue; text-decoration: none;" >List of class</h1>
    </center>
    </body>
</html>
