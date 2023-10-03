package com.pgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pgr.entity.City;
import com.pgr.util.DBConnection;

public class CityDAO {
	public int insertCity(City city) throws ClassNotFoundException, SQLException {
		System.out.println("Inserting the city data:Entry");
		Connection connection = DBConnection.getConnection();
		String insertQuery = "insert into city values(?,?,?,?)";

		PreparedStatement ps = connection.prepareStatement(insertQuery);
		ps.setInt(1, city.getCity_id());
		ps.setString(2, city.getCity_name());
		ps.setString(3, city.getState());
		ps.setString(4, city.getCountry());
		int a = ps.executeUpdate();
		connection.close();
		System.out.println("Inserting the city data: Exit");
		return a;
	}

	public int updateCity(City city) throws ClassNotFoundException, SQLException {
		System.out.println("updating the city data:Entry");
		Connection connection = DBConnection.getConnection();
		String updateQuery = "update city set city_name=?,state=?,country=? where city_id=?";
		PreparedStatement ps = connection.prepareStatement(updateQuery);
		ps.setString(1, city.getCity_name());
		ps.setString(2, city.getState());
		ps.setString(3, city.getCountry());
		ps.setInt(4, city.getCity_id());
		int b = ps.executeUpdate();
		connection.close();
		System.out.println("updating the city data: Exit");
		return b;

	}

	public int deleteCity(int city) throws ClassNotFoundException, SQLException {
		System.out.println("Delete the city name: Entry");
		Connection connection = DBConnection.getConnection();
		String deleteQuery = "delete from city where city_id=? ";
		PreparedStatement ps = connection.prepareStatement(deleteQuery);
		ps.setInt(1, city);
		int b = ps.executeUpdate();
		connection.close();
		System.out.println("Delete the city name:Exit");
		return b;
	}

	public City getCityDetails(int city_id) throws ClassNotFoundException, SQLException {
		System.out.println("getting city details by city_id: Entry");
		Connection connection = DBConnection.getConnection();
		String detailQuery = "select * from city where id=?";
		PreparedStatement ps = connection.prepareStatement(detailQuery);
		ps.setInt(1, city_id);

		City city = new City();
		ResultSet set = ps.executeQuery();
		while (set.next()) {
			city.setCity_id(set.getInt(1));
			city.setCity_name(set.getString(2));
			city.setState(set.getString(3));
			city.setCountry(set.getString(4));
		}
		connection.close();
		System.out.println("getting city details by city_id: Exit");
		return city;
	}

	public List<City> citydetails() throws ClassNotFoundException, SQLException {
		System.out.println("Getting All city details: Entry");
		Connection connection = DBConnection.getConnection();
		String allCityDetails = "select * from city";
		PreparedStatement ps = connection.prepareStatement(allCityDetails);
		ResultSet result = ps.executeQuery();
		List<City> cities = new ArrayList<City>();

		while (result.next()) {
			City city = new City();

			city.setCity_id(result.getInt(1));
			city.setCity_name(result.getString(2));
			city.setState(result.getString(3));
			city.setCountry(result.getString(4));
			cities.add(city);
		}
		connection.close();
		System.out.println("Getting All city details: Exit");
		return cities;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		CityDAO cityDAO = new CityDAO();

		City city = new City();

		// Inserting the city data......
		/*
		 * city.setCity_id(7); city.setCity_name("	New South Wales");
		 * city.setState("Sydney"); city.setCountry("Australia");
		 * cityDAO.insertCity(city);
		 * 
		 * City city2 = new City(); city2.setCity_id(8);
		 * city2.setCity_name("South Australia"); city2.setState("Adelaide");
		 * city2.setCountry("Australia"); cityDAO.insertCity(city2);
		 */

		// updating the city.........
		/*
		 * city.setCity_name("Kolkata"); city.setState("West Bengal");
		 * city.setCountry("India"); city.setCity_id(2); cityDAO.updateCity(city);
		 */

		// getting one city details......

		System.out.println(cityDAO.getCityDetails(1));

		// Deleting the city..........
		// cityDAO.deleteCity(8);

		// getting all city details.....

		/*
		 * List<City> list = cityDAO.citydetails(); Iterator<City> itr =
		 * list.iterator();
		 * 
		 * while (itr.hasNext()) { City getcityDetails = (City) itr.next();
		 * System.out.println(getcityDetails); }
		 */
	}

}
