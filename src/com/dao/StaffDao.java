package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.*;

public class StaffDao extends BaseDao{
    public ArrayList<staff1> staffinf() {//查询员工信息
        ArrayList<staff1> staffList = new ArrayList<staff1>();
        String sql = "select * from stafftable order by code asc";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while(rst.next())
            {
                staff1 sta=new staff1();
                sta.setAge(rst.getInt("age"));
                sta.setCode(rst.getString("code"));
                sta.setName(rst.getString("name"));
                sta.setDepartment(rst.getString("department"));
                sta.setPosition(rst.getString("position"));
                sta.setSex(rst.getString("sex"));
                staffList.add(sta);
            }
            return staffList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public staff1 searchStaff(String staffcode,ArrayList<staff1> dplist){

        for (staff1 d : dplist) {
            System.out.println(d.getCode()+"..."+staffcode);
            if ((d.getCode()).equals(staffcode)) {
                System.out.println("find it/////////");
                return d;
            }
        }
        return null;
    }
    public boolean deletestaff(String code) {//根据员工编号 删除员工信息
        String sql = "delete from stafftable where code= ? ";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, code);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
    public boolean updatestaff(String code,String dp,String position) {//根据员工编号 更新员工信息
        String sql = "update stafftable set department=?,position=? where code=? ";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dp);
            pstmt.setString(2, position);
            pstmt.setString(3, code);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    public boolean finddpname(String dpname){
        String sql="select dpname from dptable where dpname=?";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dpname);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                System.out.println(dpname);
                return true;
            }
            System.out.println("!find dpname!");
            return false;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
}
