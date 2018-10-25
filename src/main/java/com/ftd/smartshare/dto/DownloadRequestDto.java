package com.ftd.smartshare.dto;

import javax.xml.bind.annotation.*;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DownloadRequestDto {

	@XmlValue
	String fileName;
	@XmlValue
	String password;
	
	public DownloadRequestDto(){}
	
	public DownloadRequestDto(String fileName, String password){
		this.fileName = fileName;
		this.password = password;
	}
	
}
