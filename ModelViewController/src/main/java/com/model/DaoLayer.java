package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoLayer {
	
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "admin";
		String password = "admin";
		
		PreparedStatement pstmt;
		Connection con;
		
		public DaoLayer() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url,username,password);
				
			} catch ( Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public boolean regDetails(String username,String password) {
			String query = "insert into register values(?,?)";
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.executeUpdate();
				return true;
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		
		public boolean loginDetails(String username,String password) {
			String query = "select * from register";
			
			try {
				pstmt=con.prepareStatement(query);
				
				ResultSet rs=pstmt.executeQuery();
				
				boolean flag=false;
				
				while (rs.next()) {
					
					if (username.equals(rs.getString(1))&&password.equals(rs.getString(2))) {
						flag=true;
					}
				}
				
				if (flag==true) {
					return true;
				}else {
					return false;
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
	}
}
	
	

