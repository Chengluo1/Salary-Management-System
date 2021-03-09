<%--
  Created by IntelliJ IDEA.
  User: 落澄
  Date: 2020/6/7
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.* , com.model.*" %>
<html>
<head>
    <title>Title</title>
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
<br>
<h1 class="title">部门管理</h1>
<br>
<div class="container" id="search">
    <form action="controller/searchdp.do" method="post">
        <input type="text" name="dpcode1" placeholder="请输入部门编号">
        <input type="submit" class="btn btn-default" value="查询">
    </form>
</div>
<br>
<table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
    <thead>
    <tr>
        <th>部门编号</th>
        <th>部门名称</th>
<%--        <th>部门人数</th>--%>
        <th>部门基础工资</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%
        dp m = (dp) session.getAttribute("dpsearchresult");
    %>
    <tr>
        <td><%=m.getDpcode()%>
        </td>
        <%
            String p = "controller/deleteDpServlet.do?dpcode=" + m.getDpcode();
            String p1 = "updateDp.jsp?dpcode=" + m.getDpcode() + "&dpname=" + m.getDpname() + "&dpwage=" + m.getWage() ;
        %>
        <td><%=m.getDpname()%>
        </td>
<%--        <td><%=m.getNum()%>--%>
        </td>
        <td><%=m.getWage()%>
        </td>
        <td class="center">
            <a class="btn btn-info" href=<%=p1 %>>
                <i class="glyphicon glyphicon-edit icon-white"></i>
                修改
            </a>
            <a class="btn btn-danger" href=<%=p %>>
                <i class="glyphicon glyphicon-trash icon-white"></i>
                删除
            </a>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
