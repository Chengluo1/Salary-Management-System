package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.staff3;

public class attDao extends BaseDao{
    public ArrayList<staff3> attinf() {//返回员工出勤情况
        ArrayList<staff3> staffList = new ArrayList<staff3>();
        String sql = "select *" +
                "from attendtable";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while(rst.next())
            {
                staff3 sta=new staff3();
                sta.setCode(rst.getString("staffcode"));
                sta.setNormal(rst.getInt("normal"));
                sta.setActual(rst.getInt("actual"));
                sta.setDate(rst.getString("date"));
                sta.setOverattendence(rst.getInt("overattendence"));
                staffList.add(sta);
            }
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
}
