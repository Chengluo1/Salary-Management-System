<%--
  Created by IntelliJ IDEA.
  User: 落澄
  Date: 2020/6/7
  Time: 9:37
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
<div class="box-content" id="into">
    <form method="post" action="controller/inputattendence2.do">
        <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
            <thead>
            <tr>
                <th>工号</th>
                <th>时间</th>
                <th>应到</th>
                <th>实到</th>
                <th>加班时长(小时)</th>
            </tr>
            </thead>
            <tbody>
            <%!
                String actual="";
                String overtimeattendence="";
            %>

            <%
                int i2=0;
                ArrayList<staff3> att2list = (ArrayList<staff3>) session.getAttribute("att2List");

                for (staff3 s : att2list) {
            %>
            <tr>
                <td><%=s.getCode()%></td>
                <%-- <%
                    String p = "deleteServlet.do?cust_id=" + d.getCust_id();
                        String p1 = "updateCustomer.jsp?cust_id=" + d.getCust_id();
                %> --%>
                <td><%=s.getDate()%></td>
                <td><%=s.getNormal()%></td>
                <%actual="actual"+i2;
                    overtimeattendence="overtimeattendence"+i2;
                    i2++;
                %>

                <td><input type="text" class="form-control" name=<%=actual %> placeholder="请输入实到天数"></td>
                <td><input type="text" class="form-control" name=<%=overtimeattendence%> placeholder="请输入加班时长"></td>
            </tr>
            <%
                }
            session.setAttribute("i2",i2);%>
            </tbody>
        </table>
        <input type="submit" class="btn btn-default" value="提交">
    </form>
</div>
</div>
</div>

</body>
</html>
