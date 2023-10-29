<%-- 
    Document   : attendance
    Created on : Oct 24, 2023, 6:05:14 PM
    Author     : DUC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance</title>
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

            <h4><a href="schedule?iid=-1">Schedule</a></h4>
            <h4>Campus:   ${sessionScope.op}</h4>
        </div>
    <center>
        <div style="    background: greenyellow;
             display: inline-block;
             font-weight: 600;
             font-size: 20px;
             padding: 10px;
             border-radius: 20px;
             margin: 20px;   ">
            Class: ${requestScope.ses.group.name} <br> 
            Subject: ${requestScope.ses.subject.name} at ${requestScope.ses.room.roomid}  <br>
            Time Slot: ${requestScope.ses.time.description}
        </div>


        <form action="attendance" method="POST">
            <table border="1px" width="80%">
                <tr>
                    <th>NO</th>
                    <th>Student</th>
                    <th>Status</th>
                    <th>Description</th>
                    <th>Time</th>
                </tr>
                <c:forEach items="${requestScope.attlist}" var="a">
                    <tr>
                        <td>${a.student.id}</td>
                        <td>
                            ${a.student.name}
                            <input type="hidden" name="stuid" value="${a.student.id}"/>
                        </td>
                        <td>
                            <input type="radio" 
                                   <c:if test="${!a.status}">
                                       checked="checked"
                                   </c:if>
                                   name="status${a.student.id}" value="absent"/> absent
                            <input type="radio" 
                                   <c:if test="${a.status}">
                                       checked="checked"
                                   </c:if>

                                   name="status${a.student.id}" value="present"/> present
                        </td>
                        <td style="display: grid;">
                            <input type="text" value="${a.description}" name="description${a.student.id}"/>
                        </td> 
                        <td>${a.datetime}</td>
                    </tr>
                </c:forEach>

            </table>
            <input type="hidden" value="${requestScope.ses.seid}" name="seid"/>
            <br>
            <input type="submit" value="SAVE"/>

        </form>
    </center>
    <h2>${sessionScope.er}</h2>



    <%@include file="footer.html" %>
</body>
</html>
