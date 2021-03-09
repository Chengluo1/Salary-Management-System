package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.att2Dao;
import com.dao.inputDao;
import com.model.staff3;
import com.model.staff4;

/**
 * Servlet implementation class inputwageServlet
 */
@WebServlet("/controller/inputwageServlet.do")
public class inputwageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String[] bonus=new String[100];
        String[] overtime=new String[100];
        String[] chargebacks=new String[100];
        String[] fulltimewage=new String[100];
        String[] lunchsubsidy=new String[100];
        ArrayList<staff4> attList =(ArrayList<staff4>) request.getSession().getAttribute("attendList");
       int m = (int) request.getSession().getAttribute("i");
       System.out.println("拿到m啦！");
        for( int i=0;i<m;i++) {
            staff4 sta=new staff4();
            if("".equals(request.getParameter("bonus"+i))) {
                bonus[i]="0.0";
            }
            else
                bonus[i]=request.getParameter("bonus"+i);
            if("".equals(request.getParameter("overtime"+i))) {
                overtime[i]="0.0";
            }else
                overtime[i]=request.getParameter("overtime"+i);
            if("".equals(request.getParameter("chargebacks"+i))) {
                chargebacks[i]="0.0";
            }else
                chargebacks[i]=request.getParameter("chargebacks"+i);
            if("".equals(request.getParameter("fulltimewage"+i))) {
                fulltimewage[i]="0.0";
            }else
                fulltimewage[i]=request.getParameter("fulltimewage"+i);
            if("".equals(request.getParameter("lunchsubsidy"+i))) {
                lunchsubsidy[i]="0.0";
            }else
                lunchsubsidy[i]=request.getParameter("lunchsubsidy"+i);

            sta.setChargebacks(Double.parseDouble(chargebacks[i]));
            System.out.println("get chargeback");
            sta.setBonus(Double.parseDouble(bonus[i]));
            System.out.println("get bonus");
            sta.setOvertimepays(Double.parseDouble(overtime[i]));
            System.out.println("get overtime");
            sta.setCode(attList.get(i).getCode());
            System.out.println("get code");
            sta.setDate(attList.get(i).getDate());
            System.out.println("get Date");
            sta.setFulltimewage(Double.parseDouble(fulltimewage[i]));
            System.out.println("get fulltimewage");
            sta.setLunchsubsidy(Double.parseDouble(lunchsubsidy[i]));
            System.out.println("get lunchsidy");
            inputDao dao=new inputDao();
            dao.inputwage(sta);
            System.out.println("i:"+i);
        }
        System.out.println("俺出来啦！");
        response.sendRedirect("../main.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
