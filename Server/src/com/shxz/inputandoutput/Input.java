package com.shxz.inputandoutput;

import java.io.InputStream;
import java.net.Socket;

public class Input
{
    private Socket socket;

    public Input(Socket socket)
    {
        this.socket = socket;
    }
	public String getMessage() {
    	
    		
			try {
				InputStream is = socket.getInputStream();
				byte[] buffer = new byte[1024];
                int length = is.read(buffer);
                String str = new String(buffer, 0, length);
             
                return str;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}	
    }

}