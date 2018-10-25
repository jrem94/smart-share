package com.ftd.smartshare.dto;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.xml.bind.annotation.*;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ViewRequestDto {

	@XmlValue
	String fileName;
	@XmlValue
	String password;
	@XmlValue
	byte[] file;
	@XmlValue
	Timestamp time_created;
	@XmlValue
	Timestamp expiry_time;
	@XmlValue
	int max_downloads;
	@XmlValue
	int total_downloads;
	
	public ViewRequestDto(){}
	
	public ViewRequestDto(String fileName, String password){
		this.fileName = fileName;
		this.password = password;
	}
	
	public ViewRequestDto(String fileName, String password, byte[] file, Timestamp time_created, Timestamp expiry_time,
			int max_downloads, int total_downloads) {
		super();
		this.fileName = fileName;
		this.password = password;
		this.file = file;
		this.time_created = time_created;
		this.expiry_time = expiry_time;
		this.max_downloads = max_downloads;
		this.total_downloads = total_downloads;
	}

	public ViewRequestDto(String file_name, byte[] file, Timestamp time_created,
			Timestamp expiry_time, int max_downloads, int total_downloads){
		
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

	public Timestamp getTime_created() {
		return time_created;
	}

	public void setTime_created(Timestamp time_created) {
		this.time_created = time_created;
	}

	public Timestamp getExpiry_time() {
		return expiry_time;
	}

	public void setExpiry_time(Timestamp expiry_time) {
		this.expiry_time = expiry_time;
	}

	public int getMax_downloads() {
		return max_downloads;
	}

	public void setMax_downloads(int max_downloads) {
		this.max_downloads = max_downloads;
	}

	public int getTotal_downloads() {
		return total_downloads;
	}

	public void setTotal_downloads(int total_downloads) {
		this.total_downloads = total_downloads;
	}

	@Override
	public String toString() {
		return "ViewRequestDto [fileName=" + fileName + ", password=" + password + ", file=" + Arrays.toString(file)
				+ ", time_created=" + time_created + ", expiry_time=" + expiry_time + ", max_downloads=" + max_downloads
				+ ", total_downloads=" + total_downloads + "]";
	}
	
	
}