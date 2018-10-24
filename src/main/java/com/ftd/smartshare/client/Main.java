package com.ftd.smartshare.client;

import java.io.IOException;
import java.net.Socket;

import com.ftd.smartshare.client.commands.SmartShare;

import picocli.CommandLine;

class Main {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	try {
    		//bind to server socket in SmartShareServer
			new Socket("localhost", 3000);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//        CommandLine.run(new SmartShare()); // Pass cli arguments here
//        CommandLine.run(new SmartShare(), "-h");
//        CommandLine.run(new SmartShare(), "--version");
//        CommandLine.run(new SmartShare(), "upload");
//        CommandLine.run(new SmartShare(), "upload", "pom.xml");
//        CommandLine.run(new SmartShare(), "upload", ".gitignore");
        CommandLine.run(new SmartShare(), "upload", "pom.xml", "password");
//        CommandLine.run(new SmartShare(), "download", "pom.xml", "password");
    }

}

