<%--
  Created by IntelliJ IDEA.
  User: 落澄
  Date: 2020/6/7
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="java.util.* , com.model.*"%>
<html>
<head>
    <title>月工资录入</title>
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
    <form action="controller/inputwageServlet.do" method="post">
        <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
            <thead>
            <tr>
                <th>工号</th>
                <th>姓名</th>
                <th>部门</th>
                <th>基础工资</th>
                <th>岗位津贴</th>
                <th>加班工资</th>
                <th>午餐补贴</th>
                <th>全勤工资</th>
                <th>迟到、请假等扣款</th>
            </tr>
            </thead>
            <tbody>
            <%!String bonus="";
                String overtime="";
                String chargebacks="";
                String lunchsubsidy="";
                String fulltimewage="";
                %>
            <%  int i=0;
                ArrayList<staff2> stafflist = (ArrayList<staff2>) session.getAttribute("inputList");

                for (staff2 s : stafflist) {
            %>
            <tr>
                <td><%=s.getCode()%></td>
                <td><%=s.getName()%></td>
                <%-- <%
                    String p = "deleteServlet.do?cust_id=" + d.getCust_id();
                        String p1 = "updateCustomer.jsp?cust_id=" + d.getCust_id();
                %> --%>
                <td><%=s.getDepartment()%></td>

                <td><%=s.getBasic()%></td>
                <%bonus="bonus"+i;
                    overtime="overtime"+i;
                    chargebacks="chargebacks"+i;
                    lunchsubsidy="lunchsubsidy"+i;
                    fulltimewage="fulltimewage"+i;
                    i++;%>
                <td><input type="text" class="form-control" name=<%=bonus %> placeholder="请输入岗位津贴"></td>
                <td><input type="text" class="form-control" name=<%=overtime %> placeholder="请输入加班工资"></td>
                <td><input type="text" class="form-control" name=<%=lunchsubsidy %> placeholder="请输入午餐补贴"></td>
                <td><input type="text" class="form-control" name=<%=fulltimewage %> placeholder="请输入全勤工资"></td>
                <td><input type="text" class="form-control" name=<%=chargebacks %> placeholder="请输入迟到、请假等扣款"></td>
            </tr>
            <%} %>
            <%session.setAttribute("i",i);%>
            </tbody>
        </table>
        <input type="submit" class="btn btn-default" value="提交">
    </form>
</div>

</body>
</html>
