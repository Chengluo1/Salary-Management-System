<%--
  Created by IntelliJ IDEA.
  User: 落澄
  Date: 2020/6/7
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.* , com.model.*"%>
<html>
<head>
    <title>更新部门信息</title>
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
<h1 class="title">人员修改</h1>
<br>
<div class="container" id="update">
    <%String code=request.getParameter("code");
        String staffname=request.getParameter("staffname");
        String dp=request.getParameter("dp");
        String age=request.getParameter("age");
        String sex=request.getParameter("sex");
        String position=request.getParameter("position1");%>
    <form action="controller/updatestaffServlet.do" method="post">
        <div class="br">
            <label>工号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="code" value=<%=code %>>
        </div>
        <div class="br">
            <label>姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><%=staffname %>
        </div>
        <div class="br">
            <label>年龄：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><%=age %>
        </div>
        <div class="br">
            <label>性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><%=sex %>
        </div>
        <div class="br">
            <label>所属部门：&nbsp;</label><input type="text" class="form-control" name="dp" value=<%=dp %>>
        </div>
        <div class="br">
            <label>职位：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="position1" value=<%=position %>>
        </div>
    <%--    工号：<input type="text" class="form-control" name="code" value=<%=code %>>
        姓名：<%=staffname %>
        年龄：<%=age %>
        性别：<%=sex %>
        所属部门：<input type="text" class="form-control" name="dp" value=<%=dp %>>
        职位：<input type="text" class="form-control" name="position1" value=<%=position %>>
        --%>
        <input type="submit" class="btn btn-default" value="提交">
    </form>
</div>
<br>
<%--<div class="box-content">
    <%String code=request.getParameter("code");
        String staffname=request.getParameter("staffname");
        String dp=request.getParameter("dp");
        String age=request.getParameter("age");
        String sex=request.getParameter("sex");
        String position=request.getParameter("position1");%>
    <form action="controller/updatestaffServlet.do" method="post">
        <table>
            <tr>
                <td>工号：</td><td><input type="text" class="form-control" name="code" value=<%=code %>></td>
                <td>姓名：</td><td><%=staffname %></td>
                <td>年龄：</td><td><%=age %></td>
                <td>性别：</td><td><%=sex %></td>
                <td>所属部门：</td><td><input type="text" class="form-control" name="dp" value=<%=dp %>></td>
                <td>职位：</td><td><input type="text" class="form-control" name="position1" value=<%=position %>></td>
            </tr>
        </table>
        <input type="submit" class="btn btn-default" value="提交">
    </form>
</div>
--%>
</body>
</html>
