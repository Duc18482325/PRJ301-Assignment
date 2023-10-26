<%-- 
    Document   : schedule
    Created on : Oct 20, 2023, 1:51:12 AM
    Author     : DUC
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule</title>
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

            <h4><a href="server.jsp"style="text-decoration: none;">home</a></h4>
            <h4>Campus:   ${sessionScope.op}</h4>
        </div>
        <form action="schedule" method="get" style="    background: orange;
              color: white;
              padding: 10px;
              display: inline-block;
              border-radius: 5px;
              margin-top: 10px">
            From: <input type="date" name="from" value="${requestScope.from}"/> <br>
            To: <input type="date" name="to" value="${requestScope.to}"/> <br>
            <input type="hidden" value="${param.iid}" name="iid"/>
            <input type="submit" value="View"/>
        </form>
    <center>
        <h1 style="color: blue">Schedule</h1>
        <table border="1px" width="70%" style="display: inline-block;
               background: orangered;
               color: white;
               font-weight: 600;">
            <tr>
                <td></td>
                <c:forEach items="${requestScope.dates}" var="d">
                    <td>
                        <fmt:formatDate value="${d}" pattern="dd-MM-yyyy" var="formattedDate"/>
                        <p>${formattedDate}</p>
                    </td>
                </c:forEach>
            </tr>
            <c:forEach items="${requestScope.slots}" var="s">
                <tr>
                    <td>${s.description}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <c:forEach items="${requestScope.sessions}" var="ses">
                                <c:if test="${ses.time.tid eq s.tid and ses.date eq d}">
                                    <a href="attendance?seid=${ses.seid}"style="color: white;
                                       text-decoration: none;"> 
                                        Class: ${ses.group.name} <br> Subject: ${ses.subject.name} at ${ses.room.roomid}
                                    </a>

                                            <c:if test="${ses.isAtt}"><h4 style="color:greenyellow">(Attended)</h4></c:if>
                                            <c:if test="${!ses.isAtt}"><h4 style="color:black">(Not yet)</h4></c:if>
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
