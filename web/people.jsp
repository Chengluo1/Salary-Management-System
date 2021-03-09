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
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="bootstrap.min.js"></script>
</head>
<body>
<div id="nav">
    <nav class="container">
        <ul class="nav nav-pills nav-stacked main-menu">
            <li class="nav-header">公司人员工资管理系统</li>
            <li><a class="ajax-link" href="main.jsp"><span>部门管理</span></a>
            </li>
            <li><a class="ajax-link" href="controller/staffServlet.do"><span>人员管理</span></a>
            </li>
            <li><a class="ajax-link1"  href="attendence1.jsp">历史考勤查询</a>
                <ul>
                    <li><a href="attendence1.jsp">按时间查询</a></li>
                    <li><a href="attendence2.jsp">按部门查询</a></li>
                    <li><a href="attendence3.jsp">按员工查询</a></li>
                </ul>
            </li>
            <li><a href="inputattend.jsp" class="ajax-link">月考勤录入</a></li>
            <li><a class="ajax-link" href="inputdate.jsp"><span>月工资录入</span></a>
            </li>
            <li><a class="ajax-link1" href="history.jsp"><span>历史工资查询</span></a>
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
<h1 class="title">人员管理</h1>
<br>
<div class="container" id="search">
    <form action="controller/searchstaff.do" method="post">
        <input type="text" name="staffcode1" placeholder="请输入员工编号">
        <input type="submit" class="btn btn-default" value="查询">
    </form>
</div>
<br>
<div class="box-content" >
    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        添加员工
    </button>
<!--    <a href="insertstaff.jsp" data-toggle="tooltip" class="btn btn-warning" id="people">添加员工</a> -->
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
            ArrayList<staff1> stafflist = (ArrayList<staff1>) session.getAttribute("staffList");
            for (staff1 s : stafflist) {
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
             <!--       <i class="glyphicon glyphicon-edit icon-white"></i> -->
                    修改
                </a>
                <a class="btn btn-danger" href=<%=p %>>
                <!--    <i class="glyphicon glyphicon-trash icon-white"></i> -->
                    删除
                </a>
            </td>
        </tr>
        <%} %>
        </tbody>
    </table>

</div>
<br>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加员工
                </h4>
            </div>
            <form action="controller/inputstaffServlet.do" method="post">
                <div class="modal-body">
                    <div class="br">
                        <label>工号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="code" placeholder="请输入工号">
                    </div>
                    <div class="br">
                        <label>姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="name" placeholder="请输入姓名">
                    </div>
                    <div class="br">
                        <label>性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <spans class="controls">
                            <select  data-rel="chosen" name="sex">
                                <option class="sex">男</option>
                                <option class="sex">女</option>
                            </select>
                        </spans>
                    </div>
                    <div class="br">
                        <label>年龄&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="age" placeholder="请输入年龄">
                    </div>
                    <div class="br">
                        <label>职位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="position" placeholder="请输入职位">
                    </div>
                    <div class="br">
                        <label>部门&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="dp" placeholder="请输入部门">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-default" value="提交">
                </div>
            </form>

     <!--       <form action="controller/inputdpServlet.do" method="post">
                <div class="modal-body">
                    <div class="br">
                        <label>部门编号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="dpcode" placeholder="请输入部门编号">
                    </div>
                    <div class="br">
                        <label>部门名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="dpname" placeholder="请输入部门名称">
                    </div>
                    <div class="br">
                        <label>部门基础工资</label><input type="text" class="form-control" name="wage" placeholder="请输入部门基础工资">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-default" value="提交">
                </div>
            </form> -->
            <!--        <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="button" class="btn btn-primary">
                            提交更改
                        </button>
                    </div> -->
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
