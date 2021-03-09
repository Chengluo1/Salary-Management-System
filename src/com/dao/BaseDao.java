package com.dao;
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;

public class BaseDao {
    DataSource dataSource;
    public BaseDao () {
        try {
            Context context = new InitialContext();
            dataSource =
                    (DataSource)context.lookup("java:comp/env/jdbc/sampleDS");
        }catch(NamingException ne){
            System.out.println("Exception:"+ne);
        }



    }
    public Connection getConnection()throws Exception{
        System.out.println("连上了。");
        return dataSource.getConnection();
    }
}