package com.ftd.smartshare.client.api;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.ftd.smartshare.dto.DownloadRequestDto;
import com.ftd.smartshare.dto.UploadRequestDto;
import com.ftd.smartshare.dto.ViewRequestDto;

public final class Api {

	private static final String HOST = "localhost";
	private static final int PORT = 3000;

	private Api() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Send download request
	 *
	 * @param downloadRequestDto JAXB annotated class representing the download
	 *                           request
	 * @return true if request was successful and false if unsuccessful
	 */
	public static boolean download(DownloadRequestDto downloadRequestDto) {
		ObjectOutputStream oos = null;
		try {
			// bind to server socket in SmartShareServer
			Socket socket = new Socket(HOST, PORT);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(downloadRequestDto);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// return true if successfully downloaded from the database
		// return false otherwise
		return false;
	}

	/**
	 * Send upload request
	 *
	 * @param uploadRequestDto JAXB annotated class representing the upload request
	 * @return true if request was successful and false if unsuccessful
	 */
	public static boolean upload(UploadRequestDto uploadRequestDto) {
		ObjectOutputStream oos = null;
		try {
			// bind to server socket in SmartShareServer
			Socket socket = new Socket(HOST, PORT);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(uploadRequestDto);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// return true if successfully downloaded from the database
		// return false otherwise
		return false;
	}

	/**
	 * Send view request
	 *
	 * @param viewRequestDto JAXB annotated class representing the view request
	 * @return true if request was successful and false if unsuccessful
	 */
	public static boolean loadView(ViewRequestDto viewRequestDto) {
		ObjectOutputStream oos = null;
		try {
			// bind to server socket in SmartShareServer
			Socket socket = new Socket(HOST, PORT);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(viewRequestDto);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// return true if successfully downloaded from the database
		// return false otherwise
		return false;
	}
}
