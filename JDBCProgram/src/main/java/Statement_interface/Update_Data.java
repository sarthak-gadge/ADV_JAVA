package Statement_interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update_Data {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee id: ");
		int id = sc.nextInt();

		System.out.println("enter Employee Name: ");
		sc.nextLine();
		String name = sc.nextLine();

		System.out.println("enter Employee Salary: ");
		int salary = sc.nextInt();

		try {
//			Step 1:- Load and Register the driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Successfully!!!");

//			Step 2:- Establish the Connection.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "admin", "admin");
			System.out.println("Connection Established!!!");

//			Step 3:- Create Statement Object.
			Statement stmt = con.createStatement();

//			Step 4:- Create SQL Upadte Statement.
			String query = "update employee set name='" + name + "', salary=" + salary + " where id=" + id;

//			Step 5:- Execute the update Command.
			int rowsUpadted = stmt.executeUpdate(query);
			System.out.println("Upadte the data Successfully!!!");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
