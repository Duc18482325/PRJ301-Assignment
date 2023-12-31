<%-- 
    Document   : server
    Created on : Oct 7, 2023, 11:24:04 PM
    Author     : DUC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

            <h4><a href="logout">Log out</a></h4>
            <h4>Campus:   ${sessionScope.op}</h4>
        </div>
        <div>
            <div>
                <c:if test="${sessionScope.acc.role == 2 or sessionScope.acc.role == 1 }">
                    <a href="schedule?iid=-1">Schedule</a>
                </c:if>
                <c:if test="${sessionScope.acc.role == 3 }">
                    <a href="schedule?iid=${sessionScope.info.id}">Schedule</a>
                </c:if>
            </div>
            <div>
                <a href="list">List of student</a>

            </div>
            <div>
                <a href="attendance?seid=${ses.seid}">View attendance</a>
            </div>
        </div>
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
