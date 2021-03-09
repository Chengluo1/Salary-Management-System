package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;

/**
 * Servlet implementation class updatestaffServlet
 */
@WebServlet("/controller/updatestaffServlet.do")
public class updatestaffServlet extends HttpServlet {
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
        String dp=request.getParameter("dp");
        String position=request.getParameter("position1");
        StaffDao dao=new StaffDao();

        StaffDao find=new StaffDao();
        if(!find.finddpname(dp)){
            out.write("<script language='javascript'>swal('该部门不存在，无法进行修改！');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
            //    out.write("<script language='javascript'>alert('该部门不存在，无法插入员工信息！');history.back();</script>");
        }
        else{
        boolean success=dao.updatestaff(code,dp,position);
        if(success) {
            response.sendRedirect("staffServlet.do");
        }else {
            out.write("<script language='javascript'>swal('操作失败，请重试');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        //    out.write("<script language='javascript'>alert('操作失败，请重试');history.back();</script>");
            response.sendRedirect("../people.jsp");
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
