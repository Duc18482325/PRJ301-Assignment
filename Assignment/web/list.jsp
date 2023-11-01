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

        <h1 style="color: greenyellow">Class: ${g.name}</h1>
        <table border="1px" width="40%">
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
    <div style="margin-top: 50px;">
        <div style="margin-left: 300px;">
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
