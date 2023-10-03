import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtil {

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

}
