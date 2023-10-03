import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class TestConnection2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load 
		Class.forName("com.mysql.cj.jdbc.Driver");// mysql driver registration
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/demo", "root", "root");// connection
		
		Statement st = con.createStatement();
		con.setAutoCommit(false);
		//Scanner sc = new Scanner(System.in);
	//	String name = sc.next();
		//System.out.println("Please enter employee number: ");
		//int empno = sc.nextInt();
		String selectQuery = "select * from emp";
		//String selectOneRecordQuery = "select * from emp where empno="+empno;
		String selectMultipleRecordQuery = "select * from emp where empno in (105, 109);";
		String insertQuery = "insert into emp values(101,'Siri',9000);";
		String deleteQuery = "delete from emp where empno=102";//1
		String updateQuery = "update emp set salary=10000 WHERE empno=102;";
		String selectAvgSalaryEmployee = "select avg(SALARY) as salary from emp";
		String selectMinSalaryEmployee = "select name, min(SALARY) as salary from emp";
		String selectMaxSalaryEmployee = "select max(SALARY) as salary from emp";		
		ResultSet set = st.executeQuery(selectMinSalaryEmployee);
		while (set.next()) {
			/*
			 * System.out.println(set.getInt("empno"));
			 * System.out.println(set.getString(2));
			 */
			System.out.println(set.getString("name"));
			System.out.println(set.getFloat("salary"));
		}
		
		/*
		 * int i = st.executeUpdate(deleteQuery);
		 */		 // con.commit();
		 // System.out.println(i);
		 
		con.close();
	}
}
