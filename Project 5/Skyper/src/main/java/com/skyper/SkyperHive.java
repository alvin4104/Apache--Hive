package com.skyper;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.session.SessionState;
import org.apache.hadoop.hive.ql.Driver;
import org.apache.hadoop.hive.ql.CommandProcessorResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SkyperHive {
    
    public static void main(String[] args) {
        try {
            // Kết nối với Hive
            String jdbcUrl = "jdbc:hive2://localhost:10000/default";
            Connection conn = DriverManager.getConnection(jdbcUrl, "hive", "");
            Statement stmt = conn.createStatement();

            // Tạo bảng
            String createTableSQL = "CREATE TABLE IF NOT EXISTS skyper_data (id INT, name STRING, score DOUBLE)";
            stmt.execute(createTableSQL);
            System.out.println("Table created successfully");

            // Chèn dữ liệu vào bảng
            String insertSQL = "INSERT INTO TABLE skyper_data VALUES (1, 'John Doe', 95.5)";
            stmt.execute(insertSQL);
            System.out.println("Data inserted successfully");

            // Truy vấn dữ liệu
            String selectSQL = "SELECT * FROM skyper_data";
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double score = rs.getDouble("score");
                System.out.println(id + ": " + name + " - " + score);
            }

            // Đóng kết nối
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
