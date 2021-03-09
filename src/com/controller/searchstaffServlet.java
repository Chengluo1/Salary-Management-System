package com.controller;

import com.dao.StaffDao;
import com.dao.dpDao;
import com.model.dp;
import com.model.staff1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/controller/searchstaff.do")
public class searchstaffServlet extends HttpServlet {
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
        String staffcode = request.getParameter("staffcode1");
        if ("".equals(staffcode)){
            String defeat = "未输入员工编码！";
        //    out.write("<script language='javascript'>swal('"+defeat+"');</script>");
            out.write("<script language='javascript'>swal('"+defeat+"');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        //            "$('.confirm').click(function(){" +
        //            "history.back();});"+
        //            "</script>");
        //    out.write("<script language='javascript'>alert('"+defeat+"');history.back();</script>");
        }
        else{

        StaffDao staff = new StaffDao();
        ArrayList<staff1> stafflist = (ArrayList<staff1>) request.getSession().getAttribute("staffList");
        staff1 staffsearchresult  = staff.searchStaff(staffcode,stafflist);
        if (staffsearchresult !=null){
            request.getSession().setAttribute("staffsearchresult", staffsearchresult);
            response.sendRedirect("../searchstaff.jsp");
        }
        else {
            String defeat = "不存在该员工编码！";
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
        doPost(request,response);
    }
}
