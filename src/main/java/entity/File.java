package entity;

import java.sql.Timestamp;
import java.util.Arrays;

public class File {

	private long id;
	private String file_name;
	private byte[] file;
	private Timestamp time_created;
	private Timestamp expiry_time;
	private int max_downloads;
	private int total_downloads;
	private String password;
	
	public File() {}
	
	

	public File(String file_name, byte[] file, String password) {
		super();
		this.file_name = file_name;
		this.file = file;
		this.password = password;
	}



	public File(String file_name, byte[] file, Timestamp time_created, Timestamp expiry_time,
			int max_downloads, int total_downloads, String password) {
		super();
		this.file_name = file_name;
		this.file = file;
		this.time_created = time_created;
		this.expiry_time = expiry_time;
		this.max_downloads = max_downloads;
		this.total_downloads = total_downloads;
		this.password = password;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "File [id=" + id + ", file_name=" + file_name + ", file=" + Arrays.toString(file) + ", time_created="
				+ time_created + ", expiry_time=" + expiry_time + ", max_downloads=" + max_downloads
				+ ", total_downloads=" + total_downloads + ", password=" + password + "]";
	}

	
}