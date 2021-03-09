package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.*;

public class inputDao extends BaseDao{
    public ArrayList<staff2> staffinf() {//获取员工基本信息
        ArrayList<staff2> staffList = new ArrayList<staff2>();
        String sql = "select name,code,dpleastwage,department " +
                "from stafftable,dptable where stafftable.department=dptable.dpname "
                + "order by code";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while(rst.next())
            {
                staff2 sta=new staff2();
                sta.setCode(rst.getString("code"));
                sta.setName(rst.getString("name"));
                sta.setDepartment(rst.getString("department"));
                sta.setBasic(rst.getDouble("dpleastwage"));
                staffList.add(sta);
            }
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public void inputattendence(staff3 sta){
        String sql="INSERT INTO attendtable" + "(staffcode,date,actual,overattendence,normal)VALUES(?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sta.getCode());
            System.out.println("code");
            pstmt.setString(2, sta.getDate());
            System.out.println("date");
            pstmt.setInt(3, sta.getActual());
            System.out.println("actual");
            pstmt.setInt(4, sta.getOverattendence());
            System.out.println("overtime");
            pstmt.setInt(5,sta.getNormal());
            System.out.println("normal");
            System.out.println("成功插入！");
            pstmt.executeUpdate();
            System.out.println("真的成功啦！");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    public void inputwage(staff4 sta) {//设置扣款和所得
        String sql = "INSERT INTO allowancetable" + "(staffcode,date1,bonus,overtimepays,chargebacks,fulltimewage,lunchsubsidy)VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sta.getCode());
            pstmt.setString(2, sta.getDate());
            pstmt.setDouble(3, sta.getBonus());
            pstmt.setDouble(4, sta.getOvertimepays());
            pstmt.setDouble(5, sta.getChargebacks());
            pstmt.setDouble(6, sta.getFulltimewage());
            pstmt.setDouble(7,sta.getLunchsubsidy());
            System.out.println("成功插入！");
            pstmt.executeUpdate();
            System.out.println("真的成功啦！");
        } catch (SQLException se) {
            se.printStackTrace();
        }
        double basic = getdpwage(sta.getCode());
        sql="INSERT INTO debittable (staffcode,date,common,insurance,taxation)VALUES(?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println(sta.getCode());
            System.out.println(sta.getDate());
            System.out.println(sta.getBonus());
            System.out.println(sta.getOvertimepays());
            System.out.println("__________");
            pstmt.setString(1, sta.getCode());
            pstmt.setString(2, sta.getDate());
            Double premoney=sta.getBonus()+sta.getOvertimepays()+basic+sta.getFulltimewage()-sta.getChargebacks()+sta.getLunchsubsidy();
            Double common=premoney*0.125;
            System.out.println(common);
            Double insurance=premoney*0.12;
            System.out.println(insurance);
            Double tex;

            Double stand = premoney- 5000;
            System.out.println(stand);
            if (stand < 0) {
                tex = 0.0;
            } else if (stand < 36000) {
                tex = stand * 0.03;
            } else if (stand < 144000) {
                tex = stand * 0.1 - 2520;
            } else if (stand < 300000) {
                tex = stand * 0.2 - 16920;
            } else if (stand < 420000) {
                tex = stand * 0.25 - 31920;
            } else if (stand < 660000) {
                tex =stand * 0.3 - 52920;
            } else if (stand < 960000) {
                tex =stand * 0.35 - 85920;
            } else {
                tex =stand * 0.45 - 181920;
            }
            pstmt.setDouble(3, common);
            System.out.println("3");
            pstmt.setDouble(4, insurance);
            System.out.println("4");
            pstmt.setDouble(5, tex);
            System.out.println("5");
            pstmt.executeUpdate();
            System.out.println("update");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    public Double getdpwage(String staffcode) {//获取员工基本工资
        String sql = "SELECT dpleastwage FROM dptable,stafftable where stafftable.department=dptable.dpname and stafftable.code= ? ";
        double basic=0;
        try (Connection conn2 = dataSource.getConnection();
             PreparedStatement pstmt2 = conn2.prepareStatement(sql);
        ) {
            pstmt2.setString(1, staffcode);
            ResultSet rst = pstmt2.executeQuery();
            if(rst.next())
            {
                basic=Double.parseDouble(rst.getString("dpleastwage"));
            }
            return basic;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public void inputdp(String dpcode,String dpname,double wage) {//新增部门信息
        String sql = "INSERT INTO dptable" + "(dpcode,dpname,dpleastwage)VALUES(?,?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dpcode);
            pstmt.setString(2, dpname);
//            pstmt.setInt(3, num);
            pstmt.setDouble(3, wage);
            pstmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    public void inputstaff(String code,String name,int age,String position,String dp,String sex) {
        System.out.println("start insrt!");
        String sql = "INSERT INTO stafftable" + "(code,name,age,department,sex,position)VALUES(?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, code);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, dp);
            pstmt.setString(5, sex);
            pstmt.setString(6, position);
            pstmt.executeUpdate();
            System.out.println("flag");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
