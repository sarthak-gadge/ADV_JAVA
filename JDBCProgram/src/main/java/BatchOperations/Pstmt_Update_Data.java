package BatchOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pstmt_Update_Data {
	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/jdbc";
		String username = "admin";
		String password = "admin";
		String sql = "INSERT INTO employee (id,name,salary) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
//			Step 1:- Load and register the Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully!!!")
			
//			Step 2:- Established the Connection.
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established Successfully!!!");
			
//			Step 3:- Disable Auto Commit for Batch processing.
			conn.setAutoCommit(false);
			
//			Step 4:- Create a prepared Statment object.
			pstmt = conn.prepareStatement(sql);
			
//			Step 5:- Add multiple set of parameter to the batch.
			pstmt.setInt(1, 1);
			pstmt.setString(2, "helen");
			pstmt.setInt(3, 45000);
			pstmt.addBatch();
			
			pstmt.setInt(1, 2);
			pstmt.setString(2, "carry");
			pstmt.setInt(3, 30000);
			pstmt.addBatch();
			
			pstmt.setInt(1, 3);
			pstmt.setString(2, "travis");
			pstmt.setInt(3, 20000);
			pstmt.addBatch();
			
//			Step 6:- Execute the Batch.
			int[] result = pstmt.executeBatch();
			
//			Step 7:- Commit the Transaction.
			conn.commit();
			
//			Step 8:- Handle the Result.
			System.out.println("Batch Updated Successfully!!!");
			System.out.println("Rows Updated: "+result.length);
			
			for(int results:result) {
				System.out.println(results);
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
				if(pstmt != null) pstmt.close();
				if(conn != null)  conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		

	}

}
