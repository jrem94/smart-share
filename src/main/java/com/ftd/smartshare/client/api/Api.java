package com.ftd.smartshare.client.api;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.Socket;

import com.ftd.smartshare.dto.DownloadRequestDto;
import com.ftd.smartshare.dto.UploadRequestDto;
import com.ftd.smartshare.dto.ViewRequestDto;

public final class Api {

    private static final String HOST    = "localhost";
    private static final int    PORT    = 3000;

    private Api () {
        throw new UnsupportedOperationException();
    }

    /**
     * Send download request
     *
     * @param downloadRequestDto    JAXB annotated class representing the download request
     * @return true if request was successful and false if unsuccessful
     */
    public static boolean download(DownloadRequestDto downloadRequestDto) {
    	ObjectOutputStream oos = null;
    	ObjectInputStream ois = null;
    	try {
    		//bind to server socket in SmartShareServer
			Socket socket = new Socket(HOST, PORT);
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("DRD");
			bw.flush();
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
    	//return true if successfully downloaded from the database
    	//return false otherwise
    	return false;
    }

    /**
     * Send upload request
     *
     * @param uploadRequestDto      JAXB annotated class representing the upload request
     * @return true if request was successful and false if unsuccessful
     */
    public static boolean upload(UploadRequestDto uploadRequestDto) {
    	ObjectOutputStream oos = null;
    	ObjectInputStream ois = null;
    	try {
    		//bind to server socket in SmartShareServer
			Socket socket = new Socket(HOST, PORT);
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("URD");
			bw.flush();
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
    	//return true if successfully downloaded from the database
    	//return false otherwise
    	return false;
    }
    
    /**
     * Send view request
     *
     * @param viewRequestDto    JAXB annotated class representing the view request
     * @return true if request was successful and false if unsuccessful
     */
    public static boolean loadView(ViewRequestDto viewRequestDto) {
    	ObjectOutputStream oos = null;
    	ObjectInputStream ois = null;
    	try {
    		//bind to server socket in SmartShareServer
			Socket socket = new Socket(HOST, PORT);
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("VRD");
			bw.flush();
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
    	//return true if successfully downloaded from the database
    	//return false otherwise
    	return false;
    }
}
