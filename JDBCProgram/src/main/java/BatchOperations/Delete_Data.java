package BatchOperations;

import java.sql.Connection;
import java.sql.Statement;

public class Delete_Data {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "admim";
		String password = "admin";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
//			Step 1:- Load and Register the Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Successfully!!!");
			
//			Step 2:- Established the Connection.
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace()
		}
	}

}
