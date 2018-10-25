package com.ftd.smartshare.dto;
import java.io.File;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UploadRequestDto {
	
	@XmlValue
	File file;
	@XmlValue
	String password;
	
	public UploadRequestDto(){}
	
	public UploadRequestDto(File file, String password){
		this.file = file;
		this.password = password;
	}
	
    // TODO
	//Like a wrapper that sends what we want to send back and forth
	//set up like java bean
	//goes to RequestHandler to create/turn this into a file and  will upload to database
}
