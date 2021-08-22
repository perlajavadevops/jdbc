package com.pgr.jdbc;



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
		String selectProcedure = "{CALL SelectAllEmployees};";
		String insertProcedure = "{CALL InsertEmployee(?,?,?)};";
		String deleteProcedure = "{CALL deleteEmployee(?)};";
		String updateProcedure = "{CALL UpdateEmployee(?,?,?)};";

		CallableStatement callSt = con.prepareCall(selectProcedure);
		
		/*callSt.setInt(1, 102);
		callSt.setString(2, "PerlaReddy");
		callSt.setFloat(3, 22222);
			
		boolean i = callSt.execute();//inserted false
		System.out.println(i);
		if (i == false) {
			System.out.println("Inserted");
			con.commit();
		} else {
			System.out.println("Not Inserted");
		}
			*/
		ResultSet results = callSt.executeQuery();
		while (results.next()) {
			System.out.println(results.getInt(1) + " : " + results.getString(2)
					+ " : " + results.getFloat(3));
		}

	}
}
