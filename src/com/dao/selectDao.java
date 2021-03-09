package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.staff;
import com.model.staff3;

public class selectDao extends BaseDao{
    public ArrayList<staff> history(String date) {//查询历史工资
        ArrayList<staff> staffList = new ArrayList<staff>();
        String sql = "select code,name,department,normal,actual,dpleastwage,bonus,overtimepays,insurance,common,taxation,fulltimewage,chargebacks,lunchsubsidy  " +
                "from stafftable,attendtable,dptable,allowancetable,debittable " +
                "where attendtable.staffcode=stafftable.code and attendtable.date=? and dptable.dpname=stafftable.department and allowancetable.staffcode=stafftable.code "
                + "and allowancetable.date1=? and debittable.staffcode=stafftable.code and " +
                "debittable.date=?  order by code";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, date);
            pstmt.setString(2, date);
            pstmt.setString(3, date);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                staff sta=new staff();
                sta.setCode(rst.getString("code"));
                sta.setName(rst.getString("name"));
                sta.setDate(date);
                sta.setDepartment(rst.getString("department"));
                sta.setNormal(rst.getInt("normal"));
                sta.setActual(rst.getInt("actual"));
                sta.setBasic(rst.getDouble("dpleastwage"));
                sta.setBonus(rst.getDouble("bonus"));
                sta.setLunchsubsidy(rst.getDouble("lunchsubsidy"));
                sta.setOvertimepays(rst.getDouble("overtimepays"));
                sta.setInsurance(rst.getDouble("insurance"));
                sta.setCommon(rst.getDouble("common"));
                sta.setTax(rst.getDouble("taxation"));
                sta.setChargebacks(rst.getDouble("chargebacks"));
                sta.setFulltimewage(rst.getDouble("fulltimewage"));
                staffList.add(sta);
            }
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<staff> history2(String dpname) {//查询历史工资
        System.out.println("dpname:"+dpname);
        ArrayList<staff> staffList = new ArrayList<staff>();
        String sql = "select code,name,department,normal,actual,dpleastwage,bonus,overtimepays,insurance,common,taxation,fulltimewage,chargebacks,lunchsubsidy,date1 " +
                "from stafftable,attendtable,dptable,allowancetable,debittable " +
                "where attendtable.staffcode=stafftable.code and dptable.dpname=stafftable.department and stafftable.department=? and allowancetable.staffcode=stafftable.code "
                + "and debittable.staffcode=stafftable.code and allowancetable.date1=debittable.date and attendtable.date=debittable.date  ";
//        +                "order by code";
        System.out.println("sql语言定义ok");
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, dpname);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                System.out.println("人："+rst.getString("name"));
                staff sta=new staff();
                sta.setDate(rst.getString("date1"));
                sta.setCode(rst.getString("code"));
                sta.setName(rst.getString("name"));
                sta.setDepartment(rst.getString("department"));
                sta.setNormal(rst.getInt("normal"));
                sta.setActual(rst.getInt("actual"));
                sta.setBasic(rst.getDouble("dpleastwage"));
                sta.setBonus(rst.getDouble("bonus"));
                sta.setLunchsubsidy(rst.getDouble("lunchsubsidy"));
                sta.setOvertimepays(rst.getDouble("overtimepays"));
                sta.setInsurance(rst.getDouble("insurance"));
                sta.setCommon(rst.getDouble("common"));
                sta.setTax(rst.getDouble("taxation"));
                sta.setChargebacks(rst.getDouble("chargebacks"));
                sta.setFulltimewage(rst.getDouble("fulltimewage"));
                staffList.add(sta);
                System.out.println("成功设置一个staff");
            }
            System.out.println("成功设置staff组");
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<staff> history3(String staffcode) {//查询历史工资
        ArrayList<staff> staffList = new ArrayList<staff>();
        String sql = "select code,name,department,normal,actual,dpleastwage,bonus,overtimepays,insurance,common,taxation,fulltimewage,chargebacks,lunchsubsidy,date1  " +
                "from stafftable,attendtable,dptable,allowancetable,debittable " +
                "where attendtable.staffcode=stafftable.code and stafftable.code=? and dptable.dpname=stafftable.department and allowancetable.staffcode=stafftable.code "
                + "and debittable.staffcode=stafftable.code  and allowancetable.date1=debittable.date and attendtable.date=debittable.date  ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, staffcode);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                System.out.println("人："+rst.getString("name"));
                staff sta=new staff();
                sta.setDate(rst.getString("date1"));
                sta.setCode(rst.getString("code"));
                sta.setName(rst.getString("name"));
                sta.setDepartment(rst.getString("department"));
                sta.setNormal(rst.getInt("normal"));
                sta.setActual(rst.getInt("actual"));
                sta.setBasic(rst.getDouble("dpleastwage"));
                sta.setBonus(rst.getDouble("bonus"));
                sta.setLunchsubsidy(rst.getDouble("lunchsubsidy"));
                sta.setOvertimepays(rst.getDouble("overtimepays"));
                sta.setInsurance(rst.getDouble("insurance"));
                sta.setCommon(rst.getDouble("common"));
                sta.setTax(rst.getDouble("taxation"));
                sta.setChargebacks(rst.getDouble("chargebacks"));
                sta.setFulltimewage(rst.getDouble("fulltimewage"));
                staffList.add(sta);
            }
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<staff3> historyattend(String date) {//查询历史出勤
        ArrayList<staff3> staffList = new ArrayList<staff3>();
        String sql = "select staffcode,normal,actual,date,overattendence,department  " +
                "from attendtable,stafftable " +
                "where attendtable.date=? and attendtable.staffcode=stafftable.code";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, date);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                staff3 sta=new staff3();
                sta.setDepartment(rst.getString("department"));
                sta.setCode(rst.getString("staffcode"));
                sta.setNormal(rst.getInt("normal"));
                sta.setActual(rst.getInt("actual"));
                sta.setOverattendence(rst.getInt("overattendence"));
                sta.setDate(rst.getString("date"));
                staffList.add(sta);
            }
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<staff3> historyattend2(String dpname) {//查询历史出勤
        ArrayList<staff3> staffList = new ArrayList<staff3>();
        String sql = "select staffcode,normal,actual,date,overattendence,department  " +
                "from attendtable,stafftable " +
                "where stafftable.department=? and attendtable.staffcode=stafftable.code";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, dpname);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                staff3 sta=new staff3();
                sta.setDepartment(rst.getString("department"));
                sta.setCode(rst.getString("staffcode"));
                sta.setNormal(rst.getInt("normal"));
                sta.setActual(rst.getInt("actual"));
                sta.setOverattendence(rst.getInt("overattendence"));
                sta.setDate(rst.getString("date"));
                staffList.add(sta);
            }
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<staff3> historyattend3(String staffcode) {//查询历史出勤
        ArrayList<staff3> staffList = new ArrayList<staff3>();
        String sql = "select staffcode,normal,actual,date,overattendence,department  " +
                "from attendtable,stafftable " +
                "where attendtable.staffcode=? and attendtable.staffcode=stafftable.code";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, staffcode);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                staff3 sta=new staff3();
                sta.setDepartment(rst.getString("department"));
                sta.setCode(rst.getString("staffcode"));
                sta.setNormal(rst.getInt("normal"));
                sta.setActual(rst.getInt("actual"));
                sta.setOverattendence(rst.getInt("overattendence"));
                sta.setDate(rst.getString("date"));
                staffList.add(sta);
            }
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }

}
