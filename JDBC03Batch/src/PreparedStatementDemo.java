import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");// mysql driver registration
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/batch03", "root", "root");// connection

		String insertQueryWithPositionParatmeters = "insert into emp values(?,?,?);";
		String updateQueryWithPositionParatmeters = "update emp set salary=? WHERE id=?;";
		String deleteQueryWithPositionParatmeters = "delete from emp where id=?";
		String seelectQueryWithPositionParatmeters = "select * from emp where id=?;";

		/*PreparedStatement ps = con
				.prepareStatement(seelectQueryWithPositionParatmeters);
		int empno = 103;
		ps.setInt(1, empno);*/
	//	ps.setString(2, "Perla");
		//ps.setFloat(1, 9990);
		
		//int i = ps.executeUpdate();
		
		/*ResultSet set = ps.executeQuery();

		while (set.next()) {
			String name = set.getString("name");
			int empno1 = set.getInt(1);
			float salary = set.getFloat("salary");
			System.out.println(name);
			System.out.println(empno1);
			System.out.println(salary);
		}*/

		/*int i = ps.executeUpdate();
		if (i == 1) {
			System.out.println("Inserted");
		} else {
			System.out.println("Not Inserted");
		}*/
		
		/*
		PreparedStatement ps=con.prepareStatement("insert into imgtable values(?,?)");  
		ps.setString(1,"Roshmi");  
		  
		FileInputStream fin=new FileInputStream("D:\\core java ppt\\String-Constant-Pool.png");  
		ps.setBinaryStream(2,fin,fin.available());  
		int i=ps.executeUpdate();  
		System.out.println(i+" records affected");  
		*/
		PreparedStatement ps = con.prepareStatement("select * from imgtable where name=?");
		ps.setString(1, "Roshmi");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {// now on 1st row

			Blob b = rs.getBlob(2);// 2 means 2nd column data
			byte barr[] = b.getBytes(1, (int) b.length());// 1 means first
															// image

			FileOutputStream fout = new FileOutputStream("d:\\roshmi2.jpg");
			fout.write(barr);

			fout.close();
		}
		          
		con.close();
	}
}
