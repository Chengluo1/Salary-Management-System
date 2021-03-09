package com.controller;

import com.dao.dpDao;
import com.model.dp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/controller/searchdp.do")
public class seachdpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        String dpcode = request.getParameter("dpcode1");
        if ("".equals(dpcode)){
            String defeat = "未输入部门编码！";
        //    out.write("<script language='javascript'>swal('"+defeat+"');</script>");// +
            out.write("<script language='javascript'>swal('"+defeat+"');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
            //        "$('.confirm').click(function(){" +
            //        "history.go(-1);});"+
            //        "</script>");
        //    out.write("<script language='javascript'>alert('"+defeat+"');history.back();</script>");
        }
        else{

        dpDao dp = new dpDao();
        ArrayList<dp> dplist = (ArrayList<dp>) request.getSession().getAttribute("dpList");
        dp dpsearchresult  = dp.searchDp(dpcode,dplist);
        if (dpsearchresult !=null){
            request.getSession().setAttribute("dpsearchresult", dpsearchresult);
            response.sendRedirect("../searchdp.jsp");
        }
        else {
            String defeat = "不存在该部门编码！";
            out.write("<script language='javascript'>swal('"+defeat+"');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        //    out.write("<script language='javascript'>alert('"+defeat+"');history.back();</script>");
        }
        out.write("</body>");
        out.write("</html>");
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
