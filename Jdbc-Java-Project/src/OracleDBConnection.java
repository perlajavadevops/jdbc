import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		 * 1. Load DB driver: 4 types -> jdbc-odbc driver
		 * 2. create Connection object
		 * 3. create statement object
		 * 4. execute the sql queries.
		 * 5. close db connection
		 */
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "password");
		//System.out.println(connection);
		connection.setAutoCommit(false);
		Statement statement =  connection.createStatement();
		
		String sqlSelectQuery = "select * from users ";
				
	   String sqlSelectQueryWitWhere = "select * from users where id = 1";
		
		String sqlSelectQueryWitPositionParameter = "select * from users where id = ?";
		String insertQuery = "insert into users values(5, 'Dhruvika')";
		
		String updateQuery = "update users set name='Gaamika' where id = 2";
		String deleteQuery = "delete users where id=2";

		PreparedStatement preparedStatement =  connection.prepareStatement(insertQuery);
		//preparedStatement.setInt(1, 1);

		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		
		if (i == 0)
			connection.commit();
		else
			connection.rollback();
		 
		//String sqlSelectQuery = "select * from users ";
		
		//  String sqlSelectQuery = "select * from users where id = 1";
		  
		/*
		 * ResultSet result = preparedStatement.executeQuery(); while (result.next())
		 * {// 1 System.out.println(result.getInt("id"));
		 * System.out.println(result.getString(2)); }
		 */
		 
	}
}
