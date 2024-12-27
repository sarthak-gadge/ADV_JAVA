package IntroductionJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {
	
	public static void main(String[] args) {
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "c##hr";
		String password = "hr";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id: ");
		int id = sc.nextInt();
		System.out.println("Enter person name: ");
		String name = sc.next();
		System.out.println("Enter person age: ");
		double age = sc.nextDouble();
		
		try {
			
//			Step 1:- Load and Register the Driver.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded Successfully!!!");
			
//			Step 2:- Established the Connections.
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Established the connection successfully!!!");
			
//			Step 3:- Create Statement Platform.
			Statement stmt = con.createStatement();
			
//			Step 4:- Execute SQL Query.
			String query = "insert into person(personID, personName, personAge) values("+id+",'"+name+"','"+age+"')";
			stmt.executeUpdate(query);
			System.out.println("Data Added Successfully!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
