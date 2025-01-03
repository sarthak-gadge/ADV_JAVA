package Statement_interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

public class Retrieve_Data {
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
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully!!!");

//			Step 3:- Create Statement Object.
			Statement stmt = con.createStatement();

//			Step 4:- Create SQL Select Statement.
			String query = "select * from Employee where id=" + id;

//			Step 5:- Execute the select statement.
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Query Selected Successfully!!!");
			
			while(rs.next()) {
				System.out.println("Employee ID: "+rs.getInt(1));
				System.out.println("Employee name: "+rs.getString(2));
				System.out.println("Employee Salary: "+rs.getInt(3));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
