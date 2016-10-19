package com.mmloo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mmloo.entity.Admin;
import com.mmloo.util.DBUtil;

public class AdminDao {
  
	//查找的方法
	public Admin findByCode(String code) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select * from t_client "
				+ "where cName=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Admin a = new Admin();
				a.setcName(rs.getString("cName"));
				a.setcPassword(rs.getString("cPassword"));
				return a;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询用户失败", e);
		} finally {
			DBUtil.closeConnection(conn);
		}
		return null;
	}
	public static void main(String[] args) {
		AdminDao adminDao = new AdminDao();
		Admin admin = new Admin();
		admin = adminDao.findByCode("刘");
		System.out.println(admin.getcName()+admin.getcPassword());
	}
}




