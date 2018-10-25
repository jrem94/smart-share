package com.ftd.smartshare.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ftd.smartshare.dto.DownloadRequestDto;
import com.ftd.smartshare.dto.UploadRequestDto;
import com.ftd.smartshare.dto.ViewRequestDto;

public class FileDao {

	private static final String URL = "jdbc:postgresql://localhost:5432/postgres/smartshare";
	private static final String USER = "postgres";
	private static final String PASSWORD = "bondstone";
	
	public FileDao() {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the postgresql");
		}
	}

	public static ViewRequestDto viewFile(ViewRequestDto object) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			ViewRequestDto xdto = object;
			String sql = "SELECT * FROM smartshare.files WHERE " + "file_name = ? and password = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, object.getFileName());
			preparedStatement.setString(2, object.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			ViewRequestDto dto = null;
			while (resultSet.next()) {
				dto = new ViewRequestDto(resultSet.getString("file_name"), resultSet.getBytes("file"),
						resultSet.getTimestamp("time_created"), resultSet.getTimestamp("expiry_time"),
						resultSet.getInt("max_downloads"), resultSet.getInt("total_downloads"));
			}
			return dto;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static UploadRequestDto uploadFile(UploadRequestDto object) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			UploadRequestDto xdto = object;
			String sql = "INSERT INTO smartshare.files "
					+ "(file_name, file, time_created, expiry_time, max_downloads, total_downloads, password) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, xdto.getFileName());
			preparedStatement.setBytes(2, xdto.getFile());
			preparedStatement.setTimestamp(3, xdto.getTimeCreated());
			preparedStatement.setTimestamp(4, xdto.getExpiryTime());
			preparedStatement.setInt(5, xdto.getMaxDownloads());
			preparedStatement.setInt(6, xdto.getTotalDownloads());
			preparedStatement.setString(7, xdto.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			UploadRequestDto dto = null;
			while (resultSet.next()) {
				dto = new UploadRequestDto(resultSet.getString("file_name"), resultSet.getString("password"),
						resultSet.getBytes("file"), resultSet.getTimestamp("time_created"),
						resultSet.getTimestamp("expiry_time"), resultSet.getInt("max_downloads"),
						resultSet.getInt("total_downloads"));
			}
			return dto;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static DownloadRequestDto downloadFile(DownloadRequestDto object) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			DownloadRequestDto xdto = object;
			String sql = "SELECT * FROM smartshare.files WHERE " + "file_name = ? and password = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, object.getFileName());
			preparedStatement.setString(2, object.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			DownloadRequestDto dto = null;
			while (resultSet.next()) {
				dto = new DownloadRequestDto(resultSet.getString("file_name"), resultSet.getBytes("file"),
						resultSet.getTimestamp("time_created"), resultSet.getTimestamp("expiry_time"),
						resultSet.getInt("max_downloads"), resultSet.getInt("total_downloads"));
			}
			return dto;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}