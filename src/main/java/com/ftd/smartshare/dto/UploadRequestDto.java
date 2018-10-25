package com.ftd.smartshare.dto;
import java.io.File;
import java.sql.Timestamp;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UploadRequestDto {
	
	@XmlValue
	String fileName;
	@XmlValue
	String password;
	@XmlValue
	File file;
	@XmlValue
	Timestamp time_created;
	@XmlValue
	Timestamp expiry_time;
	@XmlValue
	int max_downloads;
	@XmlValue
	int total_downloads;
	
	public UploadRequestDto(){}
	
	public UploadRequestDto(File file, String password){
		this.file = file;
		this.password = password;
	}
	
	public UploadRequestDto(String fileName, String password, File file, Timestamp time_created, Timestamp expiry_time,
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

	public UploadRequestDto(String file_name, File file, Timestamp time_created,
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
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
		return "UploadRequestDto [fileName=" + fileName + ", password=" + password + ", file=" + file
				+ ", time_created=" + time_created + ", expiry_time=" + expiry_time + ", max_downloads=" + max_downloads
				+ ", total_downloads=" + total_downloads + "]";
	}
}
