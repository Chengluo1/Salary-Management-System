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
import com.model.*;

/**
 * Servlet implementation class inputdateServlet
 */
@WebServlet("/controller/historyServlet.do")
public class historyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
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
        String year=request.getParameter("year");
        String month=request.getParameter("month");
        if("".equals(year)||"".equals(month)){
            String defeat = "年份、月份不能为空！";
        //    out.write("<script language='javascript'>swal('"+defeat+"');<script>" );
            out.write("<script language='javascript'>swal('"+defeat+"');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        //    out.write("<script language='javascript'>alert('"+defeat+"');history.back();</script>");
        }
        else {
            String date = year + "." + month;
            selectDao dao = new selectDao();
            ArrayList<staff> historyList = dao.history(date);
            if(historyList.isEmpty()){
                String defeat = "暂无该月份工资记录！";
                out.write("<script language='javascript'>swal('"+defeat+"');" +
                        "$('.confirm').click(function(){" +
                        "history.back();});"+
                        "</script>");
            //    out.write("<script language='javascript'>alert('"+defeat+"');history.back();</script>");
            }
            else {
                request.getSession().setAttribute("historyList", historyList);
                response.sendRedirect("../show.jsp");
            }
        }
        out.write("</body>");
        out.write("</html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
