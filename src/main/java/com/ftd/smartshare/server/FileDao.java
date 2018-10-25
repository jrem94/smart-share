package com.ftd.smartshare.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.File;

public class FileDao {

	private static final String URL = "jdbc:postgresql://localhost:5432/postgres/public";
	private static final String USER = "postgres";
	private static final String PASSWORD = "bondstone";
	
	public FileDao() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the postgresql");
		}
	}
	
	public List<File> fromTable() {
		List<File> files = new ArrayList<File>();
		try(
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		)
		{
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * from smartshare.files");
			while(resultSet.next()) {
				files.add(
					new File(
						resultSet.getString("file_name"),
						resultSet.getBytes("file"),
						resultSet.getTimestamp("time_created"),
						resultSet.getTimestamp("expiry_time"),
						resultSet.getInt("max_downloads"),
						resultSet.getInt("total_downloads"),
						resultSet.getString("password")		
					)
				);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return files;
		
	}
		/*==============================================================================================================================*/
	
	public File toTable(File file) {
		
		try(
				Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		) {
			//create and populate a prepared statement
			String sql = "INSERT INTO smartshare.files (file_name, file, time_created, expiry_time, max_downloads, total_downloads, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, file.getFile_name());
			preparedStatement.setBytes(2, file.getFile());
			preparedStatement.setTimestamp(3, file.getTime_created());
			preparedStatement.setTimestamp(4, file.getExpiry_time());
			preparedStatement.setInt(5, file.getMax_downloads());
			preparedStatement.setInt(6, file.getTotal_downloads());
			preparedStatement.setString(7, file.getPassword());
			
			//execute the prepared statement to save the user to the database.
			preparedStatement.executeUpdate();
			
			//get new user id from the database (We do this because the database generated the id).
			PreparedStatement getId = connection.prepareStatement("SELECT id FROM public.user WHERE username = ?;");
			getId.setString(1,  file.getUsername());
			getId.executeQuery();
			ResultSet resultSet = getId.executeQuery();
			while(resultSet.next()) {
				file.setId(resultSet.getInt("id"));
			}
			//If the file was saved successfully and we were able to add its id, return the new user.
			return file;
		}catch(SQLException e){
				e.printStackTrace();
		}
		return null;
	}	
	
/*	public File getUserById(long id) {
		try(
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		){
			PreparedStatement stmt = connection.prepareStatement("SELECT * from public.user WHERE id = ?;");
			stmt.setLong(1, id);
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				return new File(resultSet.getLong("id"),
				resultSet.getString("username"),
				resultSet.getString("password"),
				resultSet.getString("firstname"),
				resultSet.getString("lastname")
				);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
}
