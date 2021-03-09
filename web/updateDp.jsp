<%--
  Created by IntelliJ IDEA.
  User: 落澄
  Date: 2020/6/7
  Time: 10:21
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
<h1 class="title">部门修改</h1>
<br>
<div class="container" id="update">
    <%String code=request.getParameter("dpcode");
        String name=request.getParameter("dpname");
        String num=request.getParameter("dpnum");
        String wage=request.getParameter("dpwage");%>
   <form action="controller/updateDpServlet.do" method="post" >
     <!--    部门编号：<input type="text" class="form-control" name="dpcode" value=<%=code %>>
        部门名称：<input type="text" class="form-control" name="dpname" value=<%=name %>>
        基础工资：<input type="text" class="form-control" name="dpwage" value=<%=wage %>>
        <input type="submit" class="btn btn-default" value="提交"> -->
       <div class="br">
           <label>部门编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="dpcode" value=<%=code %>>
       </div>
       <div class="br">
           <label>部门名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="dpname" value=<%=name %>>
       </div>
       <div class="br">
           <label>基础工资：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="dpwage" value=<%=wage %>>
       </div>
       <input type="submit" class="btn btn-default" value="提交">
    </form>

</div>
<%--<div class="box-content">
    <%String code=request.getParameter("dpcode");
        String name=request.getParameter("dpname");
        String num=request.getParameter("dpnum");
        String wage=request.getParameter("dpwage");%>
    <form action="controller/updateDpServlet.do" method="post">
        <table>
            <tr>
                <td>部门编号：</td><td><input type="text" class="form-control" name="dpcode" value=<%=code %>></td>
                <td>部门名称：</td><td><input type="text" class="form-control" name="dpname" value=<%=name %>></td>
                <td>部门人数：</td><td><%=num %></td>
                <td>基础工资：</td><td><input type="text" class="form-control" name="dpwage" value=<%=wage %>></td>
            </tr>
        </table>
        <input type="submit" class="btn btn-default" value="提交">
    </form>
</div> --%>

</body>
</html>
