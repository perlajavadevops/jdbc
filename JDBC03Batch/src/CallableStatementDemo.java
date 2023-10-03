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
				"jdbc:mysql://localhost:3306/batch03", "root", "root");// connection
		con.setAutoCommit(false);
		String selectProcedure = "{CALL SelectAllEmployees};";
		String insertProcedure = "{CALL InsertEmployee(?,?,?)};";
		String deleteProcedure = "{CALL deleteEmployee(?)};";

		CallableStatement callSt = con.prepareCall(insertProcedure);
		
		callSt.setInt(1, 112);
		callSt.setString(2, "Perla");
		callSt.setInt(3, 40030);
			
		boolean i = callSt.execute();//inserted false
		System.out.println(i);
		if (i == false) {
			System.out.println("Inserted");
		    con.commit();
		} else {
			System.out.println("Not Inserted");
		}
			
		/*ResultSet results = callSt.executeQuery();
		while (results.next()) {
			System.out.println(results.getInt(1) + " : " + results.getString(2)
					+ " : " + results.getFloat(3));
		}*/

	}
}
