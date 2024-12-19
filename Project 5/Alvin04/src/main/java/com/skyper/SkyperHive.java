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
            String insertSQL = "INSERT INTO TABLE skyper_data (id, name, score) VALUES "
                  + "(1, 'John Doe', 95.5), "
                  + "(2, 'Jane Smith', 88.0), "
                  + "(3, 'Alice Johnson', 92.3), "
                  + "(4, 'Bob Brown', 85.7), "
                  + "(5, 'Charlie White', 90.1), "
                  + "(6, 'Diana Green', 93.2), "
                  + "(7, 'Edward Black', 89.4), "
                  + "(8, 'Fiona Blue', 94.0), "
                  + "(9, 'George Pink', 91.5), "
                  + "(10, 'Hannah Purple', 96.0), "
                  + "(11, 'Ivy Orange', 87.3), "
                  + "(12, 'Jack Gray', 93.8), "
                  + "(13, 'Kathy Yellow', 92.1), "
                  + "(14, 'Louis Red', 91.0), "
                  + "(15, 'Maria Green', 86.4), "
                  + "(16, 'Nina Blue', 95.2), "
                  + "(17, 'Oscar Brown', 94.5), "
                  + "(18, 'Paul White', 90.0), "
                  + "(19, 'Quincy Black', 87.6), "
                  + "(20, 'Rachel Violet', 98.0), "
                  + "(21, 'Sam Blue', 89.2), "
                  + "(22, 'Tina Orange', 91.9), "
                  + "(23, 'Uma Green', 95.8), "
                  + "(24, 'Victor Red', 93.1), "
                  + "(25, 'Willow Brown', 90.3), "
                  + "(26, 'Xander Yellow', 92.7), "
                  + "(27, 'Yara Pink', 88.9), "
                  + "(28, 'Zane Black', 91.4), "
                  + "(29, 'Amelia Gray', 94.3), "
                  + "(30, 'Benjamin Blue', 96.4), "
                  + "(31, 'Catherine Purple', 85.5), "
                  + "(32, 'Daniel Green', 89.3), "
                  + "(33, 'Ella Red', 92.6), "
                  + "(34, 'Frank White', 90.5), "
                  + "(35, 'Gina Black', 97.0), "
                  + "(36, 'Henry Violet', 94.1), "
                  + "(37, 'Iris Blue', 95.6), "
                  + "(38, 'Jackie Yellow', 86.8), "
                  + "(39, 'Kevin Green', 89.7), "
                  + "(40, 'Lily Pink', 92.4), "
                  + "(41, 'Mike Brown', 90.2), "
                  + "(42, 'Nina Violet', 93.9), "
                  + "(43, 'Oscar Orange', 91.3), "
                  + "(44, 'Penny Red', 96.3), "
                  + "(45, 'Quinn White', 95.7), "
                  + "(46, 'Rose Black', 92.2), "
                  + "(47, 'Steve Blue', 97.4), "
                  + "(48, 'Tracy Green', 94.6), "
                  + "(49, 'Ursula Yellow', 90.4), "
                  + "(50, 'Vera Red', 93.0), "
                  + "(51, 'Walter White', 88.2), "
                  + "(52, 'Xenia Black', 91.8), "
                  + "(53, 'Yvonne Blue', 92.0), "
                  + "(54, 'Zoe Orange', 96.5), "
                  + "(55, 'Andrew Green', 94.7), "
                  + "(56, 'Bella Pink', 89.5), "
                  + "(57, 'Carmen Red', 90.6), "
                  + "(58, 'David Violet', 87.9), "
                  + "(59, 'Eva Black', 91.2), "
                  + "(60, 'Fred Blue', 92.5), "
                  + "(61, 'Grace Green', 96.8), "
                  + "(62, 'Harry Yellow', 93.7), "
                  + "(63, 'Isla White', 94.9), "
                  + "(64, 'Jacob Black', 89.0), "
                  + "(65, 'Kara Blue', 97.5), "
                  + "(66, 'Leo Orange', 90.7), "
                  + "(67, 'Mia Green', 91.7), "
                  + "(68, 'Nick Red', 94.4), "
                  + "(69, 'Olivia White', 96.1), "
                  + "(70, 'Peter Black', 92.9), "
                  + "(71, 'Quincy Green', 95.0), "
                  + "(72, 'Rita Violet', 87.2), "
                  + "(73, 'Simon Blue', 88.7), "
                  + "(74, 'Tina Orange', 93.5), "
                  + "(75, 'Ulysses White', 95.1), "
                  + "(76, 'Victor Black', 92.8), "
                  + "(77, 'Willow Red', 94.2), "
                  + "(78, 'Xander Green', 88.4), "
                  + "(79, 'Yara Pink', 90.9), "
                  + "(80, 'Zane Blue', 95.4), "
                  + "(81, 'Alan Green', 91.6), "
                  + "(82, 'Betty Violet', 93.3), "
                  + "(83, 'Charles Yellow', 94.8), "
                  + "(84, 'Diana White', 96.9), "
                  + "(85, 'Eve Red', 92.1), "
                  + "(86, 'Fred Black', 93.4), "
                  + "(87, 'Gina Blue', 94.0), "
                  + "(88, 'Holly Orange', 89.8), "
                  + "(89, 'Isaac White', 92.0), "
                  + "(90, 'Janet Black', 95.3), "
                  + "(91, 'Kevin Blue', 91.5), "
                  + "(92, 'Lena Green', 97.2), "
                  + "(93, 'Maya Yellow', 92.7), "
                  + "(94, 'Nadia White', 94.1), "
                  + "(95, 'Olivia Black', 93.8), "
                  + "(96, 'Paul Red', 95.0), "
                  + "(97, 'Quinn Green', 96.2), "
                  + "(98, 'Ralph Violet', 94.5), "
                  + "(99, 'Sophia Blue', 89.6), "
                  + "(100, 'Thomas Red', 91.4);";

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
