package com.pgr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class TestConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load 
		Class.forName("com.mysql.cj.jdbc.Driver");// mysql driver registration
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/demo", "root", "root");// connection
		
		con.setAutoCommit(false);
		System.out.println("auto commit flag : "+con.getAutoCommit());
		Statement st = con.createStatement();
		
		/*
		 * Scanner sc = new Scanner(System.in); // String name = sc.next();
		 * System.out.println("Please enter employee number: "); int empno =
		 * sc.nextInt();
		 */
		String selectQuery = "select * from emp";
		//String selectOneRecordQuery = "select * from emp where empno="+empno;
		String selectMultipleRecordQuery = "select * from emp where empno in (103, 104);";
		String insertQuery = "insert into emp values(103,'Siri',9000);";
		String deleteQuery = "delete from emp where empno=101";
		String updateQuery = "update emp set salary=9000 WHERE empno=102;";
		
		ResultSet set= st.executeQuery(selectQuery);
		while(set.next()) {
			System.out.println(set.getInt("empno"));
			System.out.println(set.getString(2));
			System.out.println(set.getFloat("salary"));
		}
		//st.executeUpdate(deleteQuery);
		con.commit();
		con.close();
	}
}
