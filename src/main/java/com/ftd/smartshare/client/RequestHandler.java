package com.ftd.smartshare.client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestHandler implements Runnable{

	private Socket clientSocket;
	private static Object object;
	
	public RequestHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void run() {
		System.out.println("New Thread Created");
		//get appropriate DTO and send to DAO converter the DAO will send to database
	}

	public static Object getDto() {
		return object;
	}

	public static void setDto(Object dto) {
		object = dto;
	}
	
	
}
