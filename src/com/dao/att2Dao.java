package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.staff3;
import com.model.staff4;

public class att2Dao extends BaseDao{
    public ArrayList<staff3> attinf(String date,int days) {
        ArrayList<staff3> staffList = new ArrayList<staff3>();
        String sql = "select code " +
                "from stafftable" +" where department IS NOT NULL";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while(rst.next())
            {
                System.out.println("code111111:"+rst.getString("code"));
                staff3 sta=new staff3();
                sta.setCode(rst.getString("code"));
                sta.setDate(date);
                sta.setNormal(days);
                staffList.add(sta);
            }
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<staff4> attinf2(String date) {
        ArrayList<staff4> staffList = new ArrayList<staff4>();
        String sql = "select code " +
                "from stafftable order by code";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while(rst.next())
            {
                staff4 sta=new staff4();
                sta.setCode(rst.getString("code"));
                sta.setDate(date);
                staffList.add(sta);
            }
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
}
