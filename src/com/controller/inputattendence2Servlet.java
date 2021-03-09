package com.controller;

import com.dao.inputDao;
import com.model.staff3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/controller/inputattendence2.do")
public class inputattendence2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int[] actual=new int[100];
        int[] overtimeattendence=new int[100];
        ArrayList<staff3> attList =(ArrayList<staff3>) request.getSession().getAttribute("att2List");
        int k = (int) request.getSession().getAttribute("i2");
        System.out.println("k="+k);
        System.out.println("拿到k啦！");
        for( int i=0;i<k;i++) {
            staff3 sta=new staff3();
            if("".equals(request.getParameter("actual"+i))) {
                actual[i]=0;
            }
            else
            {
                System.out.println("actual2:"+request.getParameter("actual"+i));
                actual[i]= Integer.parseInt(request.getParameter("actual"+i));
            }

            if("".equals(request.getParameter("overtimeattendence"+i))) {
                overtimeattendence[i]=0;
            }else
                overtimeattendence[i]= Integer.parseInt(request.getParameter("overtimeattendence"+i));

            sta.setActual(actual[i]);
            sta.setOverattendence(overtimeattendence[i]);
            sta.setCode(attList.get(i).getCode());
            sta.setDate(attList.get(i).getDate());
            sta.setNormal(attList.get(i).getNormal());
            System.out.println("11111111111111111111");
            inputDao dao=new inputDao();
            dao.inputattendence(sta);
            System.out.println("i:"+i);
        }
        System.out.println("俺出来啦！");
        response.sendRedirect("../main.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
