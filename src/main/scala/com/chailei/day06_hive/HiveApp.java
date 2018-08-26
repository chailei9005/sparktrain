package com.chailei.day06_hive;

import java.sql.*;

public class HiveApp {
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
        Connection con = DriverManager.getConnection("jdbc:hive2://biaoyuan01:10000/default", "root", "");
        Statement stmt = con.createStatement();
        String tableName = "page_views";



        // select * query
        String sql = "select * from " + tableName + " limit 5";
        System.out.println("Running: " + sql);
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            System.out.println(String.valueOf(res.getString(1)) + "\t" + res.getString(2) + "\t" +
            res.getString(3));
        }

        System.out.println("=====");
        stmt.close();
        con.close();

    }
}
