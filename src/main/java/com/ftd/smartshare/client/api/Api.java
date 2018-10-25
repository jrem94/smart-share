package com.ftd.smartshare.client.api;

import java.io.IOException;
import java.net.Socket;

import com.ftd.smartshare.client.RequestHandler;
import com.ftd.smartshare.dto.DownloadRequestDto;
import com.ftd.smartshare.dto.UploadRequestDto;
import com.ftd.smartshare.utils.NotImplementedException;

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
    	try {
    		//bind to server socket in SmartShareServer
			new Socket(HOST, PORT);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//return true if successfully uploaded to database
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
    	try {
    		//bind to server socket in SmartShareServer
    		//connect to server side
			new Socket(HOST, PORT);
			RequestHandler.setDto(uploadRequestDto);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//return true if successfully uploaded to database
    	//return false otherwise
    	return false;
    }
}
