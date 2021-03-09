<%--
  Created by IntelliJ IDEA.
  User: 落澄
  Date: 2020/6/7
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.* , com.model.*, java.text.*"%>
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

<div class="box-content">
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
        <thead>
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>部门</th>
            <th>时间</th>
            <th>本月应出勤（天）</th>
            <th>实际出勤（天）</th>
            <th>基本工资</th>
            <th>岗位津贴</th>
            <th>午餐补贴</th>
            <th>加班工资</th>
            <th>全勤工资</th>
            <th>扣社保</th>
            <th>扣公积金</th>
            <th>扣税</th>
            <th>迟到、请假等扣</th>
            <th>实发</th>
        </tr>
        </thead>
        <tbody>
        <%
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2);
            ArrayList<staff> historylist3 = (ArrayList<staff>) session.getAttribute("historyList3");
            for (staff h : historylist3) {
        %>
        <tr>
            <td><%=h.getCode()%></td>
            <td><%=h.getName()%></td>
            <td><%=h.getDepartment()%></td>
            <td><%=h.getDate()%></td>
            <td><%=h.getNormal()%></td>
            <td><%=h.getActual()%></td>
            <td><%=nf.format(h.getBasic())%></td>
            <td><%=nf.format(h.getBonus())%></td>
            <td><%=nf.format(h.getLunchsubsidy())%></td>
            <td><%=nf.format(h.getOvertimepays())%></td>
            <td><%=nf.format(h.getFulltimewage())%></td>
            <td><%=nf.format(h.getInsurance())%></td>
            <td><%=nf.format(h.getCommon())%></td>
            <td><%=nf.format(h.getTax())%></td>
            <td><%=nf.format(h.getChargebacks())%></td>
            <td><%=nf.format(h.getBasic()+h.getBonus()+h.getLunchsubsidy()+h.getOvertimepays()+h.getFulltimewage()-h.getCommon()-h.getTax()-h.getInsurance()-h.getChargebacks()) %></td>
        </tr>
        <%} %>
        </tbody>
    </table>
</div>

</body>
</html>
