import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJdbcExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//Step 1//
		Class.forName("com.mysql.cj.jdbc.Driver");// mysql driver registration
	//Step 2//
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/batch03", "root", "root");// connection
	//Step 3//	
		Statement st = con.createStatement();	
	//Step 4//
		String insertQuery = "insert into emp values(103,'Dhruvika',7000);";
		
		String deleteQuery = "delete from emp where id=101";

		String updateQuery = "update emp set salary=9000 WHERE id=102;";
		
		String selectQuery = "select * from emp";
		
		String selectSingleQuery = "select * from emp where id=102";
		
		String selectInQuery = "select * from emp where id in(102,103);";
		
		ResultSet result= st.executeQuery(selectInQuery);
		
		while(result.next()) {
			System.out.println("Emp Id: "+result.getInt(1)+"; Emp Name: "+result.getString(2)+"; Salary:"+result.getFloat(3));
		}
		
	//Step 5//
		//int i = st.executeUpdate(insertQuery);
		
		//System.out.println(i);
	//Step 6//
		con.close();
	}
}
