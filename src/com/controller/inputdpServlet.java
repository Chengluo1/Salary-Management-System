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
@WebServlet("/controller/inputdpServlet.do")
public class inputdpServlet extends HttpServlet {
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
        String dpcode=request.getParameter("dpcode");
        String dpname=request.getParameter("dpname");
//        int num=Integer.parseInt(request.getParameter("num"));
        String wage1=request.getParameter("wage");
        if(dpcode.equals("")||dpname.equals("")||wage1.equals("")) {
            out.write("<script language='javascript'>swal('部门编号、部门名称、基本工资均不能为空');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        //    out.write("<script language='javascript'>alert('部门编号、部门名称、基本工资均不能为空');history.back();</script>");
        }
        out.write("</body>");
        out.write("</html>");
        double wage=Double.parseDouble(request.getParameter("wage"));
        inputDao dao=new inputDao();
        dao.inputdp(dpcode, dpname, wage);
        response.sendRedirect("dpinfo.do");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
