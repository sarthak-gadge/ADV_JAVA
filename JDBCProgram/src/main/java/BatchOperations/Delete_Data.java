package BatchOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_Data {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "admin";
		String password = "admin";

		Connection conn = null;
		Statement stmt = null;
		
		try {
			
//			Step 1:- Load And Register the Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully!!!");
			
//			Step 2:- Established the Connection.
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connection EStablished Successfully!!!");
			
			
//			Step 3:- Disable the autoCommit for batch processing.
			conn.setAutoCommit(false);
			
//			Step 4:- Create a Statement Object.
			stmt = conn.createStatement();
			
//			Step 5:- Add multiple Queries to the SQL batch.
			stmt.addBatch("DELETE FROM employee WHERE id=10");
			stmt.addBatch("DELETE FROM employee WHERE id=11");
			stmt.addBatch("DELETE FROM employee WHERE id=12");
			
//			Step 6:- Execute the Batch.
			int[] result = stmt.executeBatch();
			
//			Step 7:- Commit the Transaction.
			conn.commit();
			
//			Step 8:- Handle the Result.
			System.out.println("Batch Executed SuccessFullt!!!");
			System.out.println("Rows Deleted: "+result.length);
			
			for(int results:result) {
				System.out.println(result);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}


		
		

}
}
