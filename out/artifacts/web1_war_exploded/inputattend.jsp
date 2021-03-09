<%--
  Created by IntelliJ IDEA.
  User: 落澄
  Date: 2020/6/7
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输入考勤信息</title>
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
<h1 class="title">月考勤录入</h1>
<br>
<div class="box-content" id="insert">
    <form action="controller/inputattendence.do" method="post">
        <div class="br">
            <label>请输入年份：&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="year" placeholder="请输入年份">&nbsp;&nbsp;&nbsp;年&nbsp;
        </div>
        <div class="br">
            <label>请输入月份：&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="month" placeholder="请输入月份">&nbsp;&nbsp;&nbsp;月&nbsp;
        </div>
        <div class="br">
            <label>应到天数：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="days" placeholder="请输入应到天数">&nbsp;&nbsp;&nbsp;天&nbsp;
        </div>
 <!--       请输入年份<input type="text" class="form-control" name="year" placeholder="请输入年份">年&nbsp;
        请输入月份<input type="text" class="form-control" name="month" placeholder="请输入月份">月&nbsp;
        应到天数<input type="text" class="form-control" name="days" placeholder="请输入应到天数">天&nbsp; -->
        <input type="submit" class="btn btn-default" value="提交">
    </form>
</div>
<!--<div class="box-content">
    <form action="controller/inputattendence.do" method="post">
        <table>
            <tr>
                <td>请输入年份</td><td><input type="text" class="form-control" name="year" placeholder="请输入年份"></td><td>年</td>
                <td>请输入月份</td><td><input type="text" class="form-control" name="month" placeholder="请输入月份"></td><td>月</td>
                <td>应到天数</td><td><input type="text" class="form-control" name="days" placeholder="请输入应到天数"></td><td>天</td>
            </tr>
        </table>
        <input type="submit" class="btn btn-default" value="提交">
    </form>
</div>
-->
</body>
</html>
