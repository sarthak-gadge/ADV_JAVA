package BatchOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_Data {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "admin";
		String password = "admin";
		
		Connection conn = null;
		Statement  stmt = null;
		
		try {
			
//			Step 1:- Load and Register the Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully!!!");
			
//			Step 2:- Established the Connection.
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established Successfully!!!");
			
//			Step 3:- Disable auto-Commit for batch processing.
			conn.setAutoCommit(false);
			
//			Setp 4:- Create a Statement Object.
			stmt = conn.createStatement();
			
//			Step 5:- Add multiple queries to the batch.
			 stmt.addBatch("UPDATE employee SET name = 'shree', salary = 32000 WHERE id = 10");
	         stmt.addBatch("UPDATE employee SET name = 'hanuman', salary = 9000 WHERE id = 11");
	         stmt.addBatch("UPDATE employee SET name = 'sharda', salary = 11000 WHERE id = 12");

			
//			Step 6:- Execute the batch.
			int[] results = stmt.executeBatch();
			System.out.println("Data Updated Successfully!!!");
			
//			Step 7:- Commit the Transaction.
			conn.commit();
			
//			Step 8:- Handle The Results.
			System.out.println("Batch Executed Successfully!!!");
			System.out.println("Rows added: "+results.length);
			
//			Step 9:- 
			for(int result:results) {
				System.out.println(results);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		
		
	}

}
