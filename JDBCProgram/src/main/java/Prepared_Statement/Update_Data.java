package Prepared_Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_Data {
	
	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/jdbc";
		String username ="admin";
		String password ="admin";
		
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
			
//			Step 2:- Established the Connection.
			Connection con = DriverManager.getConnection(url,username,password);
			
//			Step 3:- Create Prepared Statement.
			String query = "UPDATE employee SET  name=?, salary=? where  id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
//			Step 4:- Set parameter for prepared Statement.
			pstmt.setString(1, name);
			pstmt.setInt(2, salary);
			pstmt.setInt(3, id);
			
//			Step 5:- Execute the Prepared Statement.
			int rowUpdated = pstmt.executeUpdate();
			
//			Step 6:- Print the Result.
			if(rowUpdated>0) {
				System.out.println("Data Updated Successfully!!!");
			}else {
				System.out.println("Data not Updated??");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	

}
