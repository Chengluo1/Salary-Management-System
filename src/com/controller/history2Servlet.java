package com.controller;

import com.dao.selectDao;
import com.model.staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/controller/history2Servlet.do")
public class history2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String dpname=request.getParameter("dpname");
        if ("".equals(dpname)){
            String defeat = "部门名不能为空！";
        //    out.write("<script language='javascript'>swal('"+defeat+"');<script>");
            out.write("<script language='javascript'>swal('"+defeat+"');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        //    out.write("<script language='javascript'>alert('"+defeat+"');history.back();</script>");
        }
        else {
            selectDao dao=new selectDao();
            ArrayList<staff> historyList2 = dao.history2(dpname);
            if(historyList2.isEmpty()){
                String defeat = "暂无该部门工资记录！";
                out.write("<script language='javascript'>swal('"+defeat+"');" +
                        "$('.confirm').click(function(){" +
                        "history.back();});"+
                        "</script>");
            //    out.write("<script language='javascript'>alert('"+defeat+"');history.back();</script>");
            }
            else {
                request.getSession().setAttribute("historyList2", historyList2);
                System.out.println("history2设置成功！");
                response.sendRedirect("../show2.jsp");
            }
        }
        out.write("</body>");
        out.write("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
