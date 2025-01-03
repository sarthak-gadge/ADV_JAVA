package Prepared_Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete_Data {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "admin";
		String password = "admin";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID: ");
		int id = sc.nextInt();
		
		try {
			
//			Step 1:- Load and Register the Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully!!!");
			
//			Step 2:- Established the Connection.
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established Successfully!!!");
			
//			Step 3:- Create Prepared Statement.
			String query = "delete from employee where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
//			Step 4:- Set parameter Prepared Statement.
			pstmt.setInt(1, id);
			
//			Step 5:- Execute Prepared Statement.
			int rowDeleted = pstmt.executeUpdate();
			System.out.println("Data Deleted Successfully!!!");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
