package com.pgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pgr.entity.Customer;
import com.pgr.util.DBConnection;

public class CustomerDAO {

	public Customer getCustomerById(int customerId) throws ClassNotFoundException, SQLException {
		System.out.println("getCustomerById: Entered");

		String selectQuery = "select * from customer where customer_id = ?";
		Connection con = DBConnection.getConnection();
		
		PreparedStatement ps = con.prepareStatement(selectQuery);
		ps.setInt(1, customerId);
		
		ResultSet set = ps.executeQuery();

		Customer customer = new Customer();
		while (set.next()) {
			customer.setCustomerId(set.getInt(1));
			customer.setName(set.getString(2));
			customer.setPhoneNumber(set.getString(3));
		}
		con.close();
		System.out.println("getCustomerById: Exist");

		return customer;
	}

	public List<Customer> getCustomers() throws ClassNotFoundException, SQLException {
		System.out.println("getCustomers: Entering");
		Connection con = DBConnection.getConnection();
		String selectQuery = "select * from customer";
		PreparedStatement ps = con.prepareStatement(selectQuery);
		ResultSet set = ps.executeQuery();
		List<Customer> customers = new ArrayList<Customer>();
		while (set.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(set.getInt(1));
			customer.setName(set.getString(2));
			customer.setPhoneNumber(set.getString(3));
			customers.add(customer);
		}
		System.out.println("getCustomers: Exiting");
		return customers;
	}

	public int saveCustomer(Customer customer) throws ClassNotFoundException, SQLException {

		System.out.println("saveCustomer: Entering");
		Connection con = DBConnection.getConnection();

		String insertQuery = "insert into customer values (?,?,?)";

		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setInt(1, customer.getCustomerId());
		ps.setString(2, customer.getName());
		ps.setString(3, customer.getPhoneNumber());
		int i = ps.executeUpdate();
		con.close();
		System.out.println("saveCustomer: Exiting");
		return i;
	}

	public int deleteCustomer(int customerId) throws ClassNotFoundException, SQLException {

		System.out.println("deleteCustomer: Entering");
		Connection con = DBConnection.getConnection();

		String deleteQuery = "delete from customer where customer_id=?";

		PreparedStatement ps = con.prepareStatement(deleteQuery);
		ps.setInt(1, customerId);
		int i = ps.executeUpdate();
		con.close();
		System.out.println("deleteCustomer: Exiting");
		return i;
	}

	public int updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {

		System.out.println("updateCustomer: Entering");
		Connection con = DBConnection.getConnection();

		String updateQuery = "update customer set name=?, phone_number=? where customer_id=?";

		PreparedStatement ps = con.prepareStatement(updateQuery);
		ps.setString(1, customer.getName());
		ps.setString(2, customer.getPhoneNumber());
		ps.setInt(3, customer.getCustomerId());
		int i = ps.executeUpdate();
		con.close();
		System.out.println("updateCustomer: Exiting");
		return i;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		CustomerDAO demo1 = new CustomerDAO();
		
		
		/*
		 * String custId = args[0]; Integer intId = Integer.parseInt(custId);
		 * System.out.println(demo1.getCustomerById(intId));
		 */
		
		/*
		 * List<Customer> list = demo1.getCustomers(); Iterator<Customer> itr =
		 * list.iterator(); while (itr.hasNext()) { Customer customer = (Customer)
		 * itr.next(); System.out.println(customer); }
		 */

		
		
		Customer customer = new Customer();
		customer.setCustomerId(2);
		customer.setName("Dhatrika");
		customer.setPhoneNumber("800000000");
		 
		//demo1.updateCustomer(customer);
		demo1.deleteCustomer(2);
		//demo1.saveCustomer(customer);
		//System.out.println(demo1.getCustomers());
//System.out.println(demo1.getCustomers());
	}
}
