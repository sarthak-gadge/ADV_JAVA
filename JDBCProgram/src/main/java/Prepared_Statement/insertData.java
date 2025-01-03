package Prepared_Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insertData {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "admin";
		String password = "admin";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID: ");
		int id = sc.nextInt();
		
		System.out.println("Enter Employee Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println("Enter Employee Salary: ");
		int salary = sc.nextInt();
		
		try {
			
//			Step 1:- Load and Register the Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Diver Loaded Successfully!!!");
			
//			Step 2:- Established The Connection.
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established Successfully!!!");
			
//			Step 3:- Create Prepared Statement.
			String query = "insert into employee values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
//			Step 4:- Set Parameter for Prepared Statement.
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3,salary);
			
//			Step 5:- Execute the Prepared Statement.
			pstmt.executeUpdate();
			System.out.println("data inserted Successfully!!!");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
