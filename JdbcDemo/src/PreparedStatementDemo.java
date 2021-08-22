import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load 
		Class.forName("com.mysql.cj.jdbc.Driver");// mysql driver registration
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/demo", "root", "root");// connection
		
		con.setAutoCommit(false);
		System.out.println("auto commit flag : "+con.getAutoCommit());
		
		//Scanner sc = new Scanner(System.in);
		//	String name = sc.next();
			//System.out.println("Please enter employee number: ");
			//int empno = sc.nextInt();
		//	int empno1 = sc.nextInt();
			String selectQuery = "select * from emp";
			//i want to get employee who's salary is max()
			//i want to get employee who's salary is min()
			//i want to get employee who's salary is avg()
			
			String selectOneRecordQuery = "select * from emp where empno=?";
			String selectMaxSalaryEmployee = "select  SUM(SALARY) as salary from emp";
			
			String selectTotalCount = "select count(*) as total_emp_count from emp";
			String selectMultipleRecordQuery = "select * from emp where empno in (?, ?);";
			String insertQuery = "insert into emp values(?,?,?);";
			String deleteQuery = "delete from emp where empno=?";
			String updateQuery = "update emp set salary=? WHERE empno=?;";
			
			
		PreparedStatement ps = con.prepareStatement(selectTotalCount);
		/*ps.setInt(1, 105);
		ps.setString(2, "Perla");
		ps.setFloat(3, 80000);
*/
		ResultSet set= ps.executeQuery();
		while(set.next()) {
			System.out.println(set.getInt("total_emp_count"));
			//System.out.println(set.getString(2));
			//System.out.println(set.getFloat("salary"));
		}
		//ps.executeUpdate();
		con.commit();
		con.close();
	}
}
