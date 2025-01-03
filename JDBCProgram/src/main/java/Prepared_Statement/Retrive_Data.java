package Prepared_Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Retrive_Data {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "admin";
		String password = "admin";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Emoployee ID: ");
		int id = sc.nextInt();
		
		try {
			
//			Step 1:- Load and Register the Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Step 2:- Established the Connection.
			Connection con = DriverManager.getConnection(url,username,password);
			
//			Step 3:- Create Prepared Statement.
			String query = "select * from employee where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
//			Step 4:- set parameter for prepared Statement.
			pstmt.setInt(1, id);
			
//			Step 5:- Execute the Prepared Statement.
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Data Retrived Successfully!!!");
			
			while(rs.next()) {
				System.out.println("Employee ID: "+rs.getInt(1));
				System.out.println("Employee Name: "+rs.getString(2));
				System.out.println("Employee Salary: "+rs.getInt(3));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
