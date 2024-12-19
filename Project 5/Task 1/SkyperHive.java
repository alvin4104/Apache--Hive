package com.skyper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SkyperHive {
    public static void main(String[] args) {
        try {
            // Cấu hình kết nối với Hive
            String jdbcUrl = "jdbc:hive2://localhost:10000/default";
            Connection conn = DriverManager.getConnection(jdbcUrl, "hive", "");

            // Tạo statement để thực thi truy vấn
            Statement stmt = conn.createStatement();

            // Tạo bảng mới trong Hive
            String createTableSQL = "CREATE TABLE IF NOT EXISTS skyper_data (id INT, name STRING, score DOUBLE)";
            stmt.execute(createTableSQL);
            System.out.println("Table created successfully");

            // Chèn dữ liệu vào bảng
            String insertSQL = "INSERT INTO TABLE skyper_data VALUES (1, 'John Doe', 95.5)";
            stmt.execute(insertSQL);
            System.out.println("Data inserted successfully");

            // Truy vấn và hiển thị dữ liệu từ bảng
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
