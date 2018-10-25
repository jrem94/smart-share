package com.ftd.smartshare.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.ftd.smartshare.dto.DownloadRequestDto;
import com.ftd.smartshare.dto.UploadRequestDto;
import com.ftd.smartshare.dto.ViewRequestDto;
import com.ftd.smartshare.server.FileDao;

public class RequestHandler implements Runnable{

	@SuppressWarnings("unused")
	private Socket clientSocket;
	
	public RequestHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void run() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try{
			ois = new ObjectInputStream(clientSocket.getInputStream());
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			System.out.println("New Thread Created");
			String type = br.readLine();
			if(type == "DRD") {
				System.out.println("DRD obtained");
				try {
					DownloadRequestDto dwnDto = (DownloadRequestDto) ois.readObject();
					FileDao.downloadFile(dwnDto);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(type == "URD") {
				System.out.println("URD obtained");
				try {
					UploadRequestDto upDto = (UploadRequestDto) ois.readObject();
					FileDao.uploadFile(upDto);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(type == "VRD") {
				System.out.println("VRD obtained");
				try {
					ViewRequestDto viewDto = (ViewRequestDto) ois.readObject();
					FileDao.viewFile(viewDto);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("Object is not an appropriate DTO.");
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}