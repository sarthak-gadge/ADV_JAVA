package Statement_interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete_Data {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "admin";
		String password = "admin";

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Employee ID: ");
		int id = sc.nextInt();

		try {

//			Step 1:- Load and Register the Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully!!!");

//			Step 2:- Established the Connection.
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established!!!");

//			Step 3:- Create Statement Object.
			Statement stmt = con.createStatement();

//			Step 4:- Create SQL Delete Statement.
			String query = "delete from employee where id=" + id;

//			Step 5:- Execute the Delete Command.
			int rowsDelete = stmt.executeUpdate(query);
			System.out.println("Delete the data Successfully!!!");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
