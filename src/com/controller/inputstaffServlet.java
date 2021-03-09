package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.model.staff3;
import com.model.staff4;

/**
 * Servlet implementation class inputdateServlet
 */
@WebServlet("/controller/inputstaffServlet.do")
public class inputstaffServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.write("<!DOCTYPE html>\n" +
                "<html>");
        out.write("<head>");
        out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.huangwx.cn/css/sweetalert.css\">\n" +
                "<style type=\"text/css\">\n" +
                " .sweet-alert{\n" +
                "    width: 400px;\n" +
                "    margin-left: -220px;\n" +
                "}\n" +
                ".sweet-alert h2{\n" +
                "    font-size: 25px;\n" +
                "}       \n" +
                "</style>"+
                "<script type=\"text/javascript\" src=\"https://www.huangwx.cn/js/sweetalert-dev.js\"></script>"+
                "<script src=\"https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js\"></script>");
        out.write("</head>");
        out.write("<body>");
        String code=request.getParameter("code");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String position=request.getParameter("position");
        String dp=request.getParameter("dp");
        String age1=request.getParameter("age");
        if(code.equals("")||"".equals(name)||"".equals(sex)||"".equals(position)||"".equals(dp)||"".equals(age1)) {
            out.write("<script language='javascript'>swal('必须填写所有信息！');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
            System.out.println("没填！");
        //    out.write("<script language='javascript'>alert('必须填写所有信息！');history.back();</script>");
        }
        else{
        StaffDao find=new StaffDao();
        if(!find.finddpname(dp)){
            out.write("<script language='javascript'>swal('该部门不存在，无法插入员工信息！');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        //    out.write("<script language='javascript'>alert('该部门不存在，无法插入员工信息！');history.back();</script>");
        }
        else{
            int age=Integer.parseInt(age1);
            inputDao dao=new inputDao();
            dao.inputstaff(code, name, age, position, dp, sex);
            response.sendRedirect("staffServlet.do");
        }
        }
        out.write("</body>");
        out.write("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
