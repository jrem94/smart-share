package com.ftd.smartshare.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.ftd.smartshare.dto.DownloadRequestDto;
import com.ftd.smartshare.dto.UploadRequestDto;
import com.ftd.smartshare.dto.ViewRequestDto;
import com.ftd.smartshare.server.FileDao;

public class RequestHandler implements Runnable {

	@SuppressWarnings("unused")
	private Socket clientSocket;

	public RequestHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void run() {
		System.out.println("New Thread Created");
		try (
			ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream())) {
			Object o = ois.readObject();

			if (o instanceof DownloadRequestDto) {
				System.out.println("Download successfully passed to Request Handler");
				try {
					DownloadRequestDto dwnDto = (DownloadRequestDto) o;
					FileDao.downloadFile(dwnDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (o instanceof UploadRequestDto) {
				System.out.println("Upload DTO successfully passed to Request Handler");
				try {
					UploadRequestDto upDto = (UploadRequestDto) o;
					FileDao.uploadFile(upDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (o instanceof ViewRequestDto) {
				System.out.println("View DTO successfully passed to Request Handler");
				try {
					ViewRequestDto viewDto = (ViewRequestDto) o;
					FileDao.viewFile(viewDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Object is not an appropriate DTO.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}