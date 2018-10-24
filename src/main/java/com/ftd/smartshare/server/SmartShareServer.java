package com.ftd.smartshare.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.ftd.smartshare.client.commands.RequestHandler;

public class SmartShareServer {
    /* When a client connects to the server, the server should create a
	new Thread to handle the request. The thread should run until the
	response is given to the client. */

	public static void main(String[] args) {
        try (
        		// Create a new server socket on port 3000.
        		ServerSocket server = new ServerSocket(3000);
        	)
        {
        	while(true) {
	        	//listening for connection
	        	//pass off to runnable
	        	Socket clientSocket = server.accept();
	        	// Spin up a new thread.
	        	Thread clientThread = new Thread(new RequestHandler(clientSocket));
	        	// Start up the thread.
	        	clientThread.start();
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
