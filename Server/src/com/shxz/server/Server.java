package com.shxz.server;
import java.io.IOException;
import java.net.*;

import com.shxz.inputandoutput.Input;
import com.shxz.inputandoutput.Output;
public class Server {
	private ServerSocket ss;
	private Socket mySocket;
	private Output output;
	private Input input;
	public static boolean isstarted=false;
	public void start()
	{
		try {
			ss=new ServerSocket(9999);
			isstarted=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("端口已经被占用");
			e.printStackTrace();
		}
	}
	
	public void initSocket(){
		try {
			mySocket=ss.accept();
			input=new Input(mySocket);
			output=new Output(mySocket);	
			System.out.println("init Ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public static boolean isIsstarted() {
		return isstarted;
	}
	public static void setIsstarted(boolean isstarted) {
		Server.isstarted = isstarted;
	}
	public Socket getMySocket() {
		return mySocket;
	}
	public void setMySocket(Socket mySocket) {
		this.mySocket = mySocket;
	}
	public ServerSocket getSs() {
		return ss;
	}
	public void setSs(ServerSocket ss) {
		this.ss = ss;
	}
	
//	public static void main(String [] args){
//		Server server=new Server();
//		server.start();server.initSocket();
//		server.getOutput().sendMessage("你好，我是服务器");
//		System.out.println(server.getInput().getMessage());
//	}
}
