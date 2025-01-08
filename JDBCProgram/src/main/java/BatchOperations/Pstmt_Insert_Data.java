package BatchOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pstmt_Insert_Data {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "admin";
		String password = "admin";
		String sql = "INSERT INTO employee(id,name,salary) VALUES(?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

//			Step 1:- Load and Register the Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully!!!");

//			Step 2:- Established the Connection.
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully!!!");

//			Step 3:- Disable the auto Commit for batch processing.
			conn.setAutoCommit(false);

//			Step 4:- create a prepared statement object.
			pstmt = conn.prepareStatement(sql);

//			Step 5:- Add Multiple Set of Parameter to batch.
			pstmt.setInt(1, 8);
			pstmt.setString(2, "mayank");
			pstmt.setInt(3, 65000);
			pstmt.addBatch();

			pstmt.setInt(1, 9);
			pstmt.setString(2, "krunal");
			pstmt.setInt(3, 78000);
			pstmt.addBatch();

			pstmt.setInt(1, 10);
			pstmt.setString(2, "prajwal");
			pstmt.setInt(3, 82000);
			pstmt.addBatch();

//			Step 6:- Execute the batch.
			int[] result = pstmt.executeBatch();

//			Step 7:- Commit the Transaction.
			conn.commit();

//			Step 8:- Handle the Result.
			System.out.println("Batch Added Successfully!!!");
			System.out.println("Rows Added: " + result.length);

			for (int results : result) {
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
				if(pstmt !=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
