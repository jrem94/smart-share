package com.ftd.smartshare.server;

import java.io.IOException;
import java.net.ServerSocket;

import com.ftd.smartshare.client.commands.SmartShare;

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
        	// Spin up a new thread using SmartShare and save the thread as t1.
        	Thread t1 = new Thread(new SmartShare());
        	// Start up the thread.
        	t1.start();
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
