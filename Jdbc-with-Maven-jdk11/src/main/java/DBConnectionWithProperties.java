import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionWithProperties {

	public static Connection getMySQLConnection() throws IOException, ClassNotFoundException, SQLException {

		InputStream is = new FileInputStream("src/main/resources/application.properties");
		Properties properties = new Properties();
		properties.load(is);

		String driverClass = properties.getProperty("db.mysql.driverClass");
		String password = properties.getProperty("db.password");
		String userName = properties.getProperty("db.username");
		String jdbcUrl = properties.getProperty("db.mysql.jdbcurl");

		Class.forName(driverClass);
		// step 2
		Connection con = DriverManager.getConnection(jdbcUrl, userName, password);// connection

		return con;

	}

	public static void main(String[] args) {

		try {
			Connection con = getMySQLConnection();

			PreparedStatement preStmt = con.prepareStatement("select * from emp_details_1 where id =?");
			preStmt.setInt(1, 104);

			ResultSet rs = preStmt.executeQuery();
			while (rs.next()) {// 1
				System.out.println(rs.getInt(1));

				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getDouble("salary"));
				System.out.println(rs.getString(5));

			}

			// step 5
			con.close();

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
