package com.controller;

import com.dao.selectDao;
import com.model.staff;
import com.model.staff3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/controller/attendServlet3.do")
public class attendence3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String staffcode=request.getParameter("staffcode");
        if ("".equals(staffcode)){
            String defeat = "员工编号不能为空！";
        //    out.write("<script language='javascript'>swal('"+defeat+"');<script>" );
            out.write("<script language='javascript'>swal('"+defeat+"');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        //    out.write("<script language='javascript'>alert('"+defeat+"');history.back();</script>");
        }
        else {
            selectDao dao=new selectDao();
            ArrayList<staff3> historyattend3= dao.historyattend3(staffcode);
            if(historyattend3.isEmpty()){
                String defeat = "暂无该员工考勤记录！";
                out.write("<script language='javascript'>swal('"+defeat+"');" +
                        "$('.confirm').click(function(){" +
                        "history.back();});"+
                        "</script>");
            //    out.write("<script language='javascript'>alert('"+defeat+"');history.back();</script>");
            }
            else {
                request.getSession().setAttribute("historyattend3", historyattend3);
                response.sendRedirect("../showattendence3.jsp");
            }
        }
        out.write("</body>");
        out.write("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
