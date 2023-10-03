import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnectionDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// step 1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// step 2
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "password");
		System.out.println("con " + con);
		// step 3
		Statement stmt = con.createStatement();
		// step 4
		// Total records
		// ResultSet rs = stmt.executeQuery("select * from emp_details_1");
		// single record
		// ResultSet rs = stmt.executeQuery("select * from emp_details_1 where id =101
		// and id = 102");
		// Multiple records with in query
		// ResultSet rs = stmt.executeQuery("select * from emp_details_1 WHERE id
		// in(101, 102)");
		// Multiple records with like clause
		ResultSet rs = stmt.executeQuery("select * from emp_details_1 WHERE FIRST_NAME LIKE '%D%'");
		// ResultSet rs = stmt.executeQuery("SELECT Max(SALARY) FROM emp_details_1");

		while (rs.next()) {// 1
			System.out.println(rs.getInt(1));

			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getDouble("salary"));
			System.out.println(rs.getString(5));

		}

		// step 5
		con.close();
	}

}
