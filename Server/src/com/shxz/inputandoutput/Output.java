package com.shxz.inputandoutput;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Output
{
    private Socket socket;
    
    public Output(Socket socket){
    	this.socket=socket;
    }
    
    public void sendMessage(String message) {
    	 try {
			OutputStream os = socket.getOutputStream();
			 BufferedOutputStream bos=new BufferedOutputStream(os);
			 bos.write(message.getBytes());
			 bos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
