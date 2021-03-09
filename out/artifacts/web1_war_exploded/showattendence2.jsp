<%--
  Created by IntelliJ IDEA.
  User: 落澄
  Date: 2020/6/6
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.* , com.model.*" %>
<html>
<head>
    <title>考勤信息</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<div id="nav">
    <nav class="container">
        <ul class="nav nav-pills nav-stacked main-menu">
            <li class="nav-header">公司人员工资管理系统</li>
            <li><a class="ajax-link" href="main.jsp"><i class="glyphicon glyphicon-home"></i><span>部门管理</span></a>
            </li>
            <li><a class="ajax-link" href="controller/staffServlet.do"><i class="glyphicon glyphicon-eye-open"></i><span>人员管理</span></a>
            </li>
            <li><a class="ajax-link1"  href="attendence1.jsp">历史考勤查询</a>
                <ul>
                    <li><a href="attendence1.jsp">按时间查询</a></li>
                    <li><a href="attendence2.jsp">按部门查询</a></li>
                    <li><a href="attendence3.jsp">按员工查询</a></li>
                </ul>
            </li>
            <li><a href="inputattend.jsp" class="ajax-link">月考勤录入</a></li>
            <li><a class="ajax-link" href="inputdate.jsp"><i class="glyphicon glyphicon-picture"></i><span>月工资录入</span></a>
            </li>
            <li><a class="ajax-link1" href="history.jsp"><i
                    class="glyphicon glyphicon-align-justify"></i><span>历史工资查询</span></a>
                <ul>
                    <li><a href="history.jsp">按时间查询</a></li>
                    <li><a href="history2.jsp">按部门查询</a></li>
                    <li><a href="history3.jsp">按员工查询</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
<table>
    <thead>
    <tr>
        <th>工号</th>
        <th>部门</th>
        <th>月份</th>
        <th>应到</th>
        <th>实到</th>
        <th>加班时长(小时)</th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<staff3> stalist2 = (ArrayList<staff3>) session.getAttribute("historyattend2");
        for (staff3 s : stalist2) {
    %>
    <tr>
        <td><%=s.getCode()%>
        </td>
        <td>
            <%=s.getDepartment()%>
        </td>
        <td><%=s.getDate()%>
        </td>
        <td><%=s.getNormal()%>
        </td>
        <td><%=s.getActual()%>
        </td>
        <td><%=s.getOverattendence()%>
        </td>
    </tr>
    <%} %>
    </tbody>
</table>

</body>
</html>
