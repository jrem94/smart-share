package com.ftd.smartshare.client.commands;

import java.net.Socket;

public class RequestHandler implements Runnable{

	private Socket clientSocket;
	
	public RequestHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void run() {
		System.out.println("New Thread Created");
		//Logic to apply to the thread.
	}
}
