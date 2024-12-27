package IntroductionJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveData {
	
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "c##hr";
		String Password = "hr";
		 
		try {
			
//			step 1:- Load and Register the Driver.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully!!");
			
//			step 2:- Establish the connections.
			Connection con = DriverManager.getConnection(url,username,Password);
			System.out.println("Established the connection successfully!!!");
			
//			step 3:- Create Statement Platform.
			Statement stmt = con.createStatement();
			
//			Step 4:- Execute SQL Query.
//			Step 5:- get the Result.
			ResultSet rs=stmt.executeQuery("select * from person");
			
//			Step 6:- Load the ResultSet.
			while(rs.next()) {
				System.out.println("Person ID : "+rs.getInt(1));
				System.out.println("Person Name : "+rs.getString(2));
				System.out.println("Person Age : "+rs.getDouble(3));
				System.out.println("=========================================");
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
