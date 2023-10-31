<%-- 
    Document   : list
    Created on : Oct 18, 2023, 1:12:35 AM
    Author     : DUC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:forEach items="${requestScope.data}" var="g">
        <h1>${g.name}</h1>
        <table border="1px">
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Code</th>
                <th>Gender</th>
                <th>Dob</th>
            </tr>
            <c:forEach items="${g.students}" var="st">
                <tr>
                    <td>${st.id}</td>
                    <td>${st.name}</td>
                    <td>${st.code}</td>
                    <td>${(st.gender == true)?'Male':'Female'}</td>
                    <td>${st.dob}</td>

                </tr>

            </c:forEach>

        </table>
    </c:forEach>
</body>
</html>
