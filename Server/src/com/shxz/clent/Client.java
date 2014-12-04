package com.shxz.clent;

import java.io.IOException;
import java.net.Socket;

import com.shxz.inputandoutput.Input;
import com.shxz.inputandoutput.Output;

public class Client {
	private Socket mySocket;
	private  boolean isconnected=false;
	private Input input;
	private Output output;

	public void start()
	{
		try{
		mySocket =new Socket("127.0.0.1",9999);
		input=new Input(mySocket);
		output=new Output(mySocket);
		isconnected=true;
		}catch(Exception e)
		{
			isconnected=false;
			System.out.println("连接失败！");
			e.printStackTrace();
		}
	}
	public void close()
	{
		try {
			if(this.isconnected)
			{
				mySocket.close();
				isconnected=false;
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			isconnected=false;
			e.printStackTrace();
		}
	}	
	public Socket getMySocket() {
		return mySocket;
	}
	public void setMySocket(Socket mySocket) {
		this.mySocket = mySocket;
	}
	public boolean getIsconnected() {
		return isconnected;
	}
	public void setIsconnected(boolean isconnected) {
		this.isconnected = isconnected;
	}
	public Input getInput() {
		return input;
	}
	public void setInput(Input input) {
		this.input = input;
	}
	public Output getOutput() {
		return output;
	}
	public void setOutput(Output output) {
		this.output = output;
	}
	
	public static void main(String [] args){
		Client client=new Client();
		client.start();
		System.out.println(client.getInput().getMessage());
		client.getOutput().sendMessage("你好，我是客户端");
		
	}
}
