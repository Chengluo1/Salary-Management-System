<%--
  Created by IntelliJ IDEA.
  User: 落澄
  Date: 2020/6/7
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.* , com.model.*"%>
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
<h1 class="title">员工查询</h1>
<br>
<div id="search">
  <!--  <a href="insertstaff.jsp" data-toggle="tooltip" class="btn btn-warning">添加员工</a> -->
    <div>
        <form action="controller/searchstaff.do" method="post">
            <input type="text" name="staffcode1" placeholder="请输入员工编号">
            <input type="submit" class="btn btn-default" value="查询">
        </form>
    </div>
</div>
<br>
    <%--    <a href="findstaff.jsp" data-toggle="tooltip" class="btn btn-warning">精确查找</a>--%>
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
        <thead>
        <tr>
            <th>部门</th>
            <th>姓名</th>
            <th>工号</th>
            <th>性别</th>
            <th>年龄</th>
            <th>职位</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            staff1 s = (staff1) session.getAttribute("staffsearchresult");
        %>
        <tr>
            <td><%=s.getDepartment()%></td>
            <td><%=s.getName()%></td>
            <td><%=s.getCode()%></td>
            <td><%=s.getSex()%></td>
            <td><%=s.getAge()%></td>
            <td><%=s.getPosition()%></td>
            <%
                String p = "controller/deletestaffServlet.do?code=" + s.getCode();
                String p1 = "updatestaff.jsp?code=" + s.getCode()+"&staffname="+s.getName()+"&dp="+s.getDepartment()+"&sex="+s.getSex()+"&age="+s.getAge()+"&position1="+s.getPosition();
            %>
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

<!-- </div> -->

</body>
</html>
