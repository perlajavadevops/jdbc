import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementDemo {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");// mysql driver registration
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/demo", "root", "root");// connection
		con.setAutoCommit(false);
		String selectProcedure = "{CALL SelectAllEmployees_employee_sp};";
		String insertProcedure = "{CALL InsertEmployee_employee_sp(?,?,?)};";
		String deleteProcedure = "{CALL deleteEmployee_employee_sp(?)};";
		String updateProcedure = "{CALL UpdateEmployee_employee_sp(?,?,?)};";

		CallableStatement callSt = con.prepareCall(deleteProcedure);
		
		callSt.setInt(1, 103);
		/*
		 * callSt.setString(2, "Sai Sireesha"); callSt.setFloat(3, 40000);
		 */
			
		boolean i = callSt.execute();//inserted false
		System.out.println(i);
		if (i == false) {
			System.out.println("Inserted");
			con.commit();
		} else {
			System.out.println("Not Inserted");
		}
		
			
		/*
		 * ResultSet results = callSt.executeQuery(); while (results.next()) {
		 * System.out.println(results.getInt(1) + " : " + results.getString(2) + " : " +
		 * results.getFloat(3)); }
		 */
	}
}
