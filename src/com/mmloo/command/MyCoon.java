package com.mmloo.command;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyCoon {

	public static void main(String[] args) {
		Connection conn =null;
		String url="jdbc:mysql://localhost:3306/test?user=root&password=&useUnicode=true&characterEncoding=UTF8";
		try {
			com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			System.out.println("�ɹ�����MySQL��������");
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			String sql = "select * from user";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("ѧ��\t����");
			while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2));
            }
		} catch (SQLException e) {
			 System.out.println("MySQL��������");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		
	}
}
