package BatchOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_Data {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "admin";
		String password = "admin";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
//			Step 1:- Load and Register the Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully!!!");
			
//			Step 2:- Established the Connections.
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established Successfully!!!");
			
//			Step 3:- Disable autoCommit for batch Processing.
			conn.setAutoCommit(false);
			
			
//			Step 4:- Create a Statement Object.
			stmt = conn.createStatement();
			
//			Step 5:- Add multiple SQL queries to the batch.
			stmt.addBatch("INSERT INTO employee(id,name,salary) VALUES (10,'yadnesh',55000)");
			stmt.addBatch("INSERT INTO employee(id,name,salary) VALUES (11,'ranveer',78000)");
			stmt.addBatch("INSERT INTO employee(id,name,salary) VALUES (12,'vivek',56000)");
			
//			Step 6:- Execute the batch.
			int [] result = stmt.executeBatch();
			System.out.println("Data Inserted Successfully!!!");
			
//			Step 7:- Commit the Transaction.
			conn.commit();
			
//			Step 8:- Handle the Result.
			System.out.println("Batch Execute Successfully!!!");
			System.out.println("Rows Added: "+result.length);
			
			for(int results:result) {
				System.out.println(result);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			try {
//				rollback transaction in case of error.
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
		}
	}

}
