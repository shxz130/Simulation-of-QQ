package com.shxz.client;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServer
{
    public static void main(String[] args) throws Exception
    {
        @SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(9998);
        
        while(true)
        {
            Socket socket = serverSocket.accept();
            
            //Æô¶¯¶ÁÐ´Ïß³Ì
            new ServerInputThread(socket).start();
            new ServerOutputThread(socket).start();
        }
    }
}
