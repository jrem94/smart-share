package com.ftd.smartshare.dto;

import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

public class UploadRequestDto implements Serializable {

	private String fileName;
	private String password;
	private byte[] file;
	private Timestamp timeCreated;
	private Timestamp expiryTime;
	private int maxDownloads;
	private int totalDownloads;
	private String path;

	public UploadRequestDto() {
	}

	public UploadRequestDto(String path, String password) {
		this.path = path;
		this.password = password;
	}

	public UploadRequestDto(String fileName, String password, byte[] file, Timestamp time_created,
			Timestamp expiry_time, int max_downloads, int total_downloads) {
		super();
		this.fileName = fileName;
		this.password = password;
		this.file = file;
		this.timeCreated = time_created;
		this.expiryTime = expiry_time;
		this.maxDownloads = max_downloads;
		this.totalDownloads = total_downloads;
	}

	public UploadRequestDto(String file_name, File file, Timestamp time_created, Timestamp expiry_time,
			int max_downloads, int total_downloads) {

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Timestamp getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Timestamp getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Timestamp expiryTime) {
		this.expiryTime = expiryTime;
	}

	public int getMaxDownloads() {
		return maxDownloads;
	}

	public void setMaxDownloads(int maxDownloads) {
		this.maxDownloads = maxDownloads;
	}

	public int getTotalDownloads() {
		return totalDownloads;
	}

	public void setTotalDownloads(int totalDownloads) {
		this.totalDownloads = totalDownloads;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "UploadRequestDto [fileName=" + fileName + ", password=" + password + ", file=" + Arrays.toString(file)
				+ ", timeCreated=" + timeCreated + ", expiryTime=" + expiryTime + ", maxDownloads=" + maxDownloads
				+ ", totalDownloads=" + totalDownloads + ", path=" + path + "]";
	}

}
