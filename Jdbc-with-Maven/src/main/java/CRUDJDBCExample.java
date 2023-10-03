import java.sql.Connection;
import java.sql.PreparedStatement;

public class CRUDJDBCExample {

	//

	public static void main(String[] args) {

		try {
			Connection con = DBConnectionUtil.getMySQLConnection();

			String insertQuery = 
					"insert into emp_details_1 (id, first_name, last_name, salary, email) values (?, ?, ?, ?,?)";
			
			String deleteQuery = "delete from emp_details_1 where id = ?";
			
			String updateQuery = "UPDATE emp_details_1 SET email = ?, salary=?, first_name=?, last_name=? WHERE id= ?";
			PreparedStatement preStmt = con.prepareStatement(updateQuery);
			
			//update set parameters
			preStmt.setString(1, "dhatrika@gmail.com");
			preStmt.setFloat(2, 9000);
			preStmt.setString(3, "Dhatrika");
			preStmt.setString(4, "Sai");
			preStmt.setInt(5, 104);
			
			/*
			 * preStmt.setString(2, "Dhatrika"); preStmt.setString(3, "Sai");
			 * preStmt.setFloat(4, 9000); preStmt.setString(5, "dhatrika@gmail.com");
			 */

			int i = preStmt.executeUpdate();

			if (i == 1) {
				System.out.println("Data is inserted..");
			} else {
				System.out.println("Data is not inserted..");

			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

}
