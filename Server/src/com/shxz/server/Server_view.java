package com.shxz.server;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
public class Server_view extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Server server;
	private JTextField jtf; 
	JLabel jl_1,jl_2,jl_istarted;
	JButton jb_open,jb_send;
	JPanel jp_top,jp_center,jp_bottom;
	JTextArea jta;
	/*
	 * 构造函数
	 */
	public Server_view()
	{
		server=new Server();
		
		//jl_1=new JLabel("我是主窗口");
		jl_2=new JLabel("端口状态：");
		jl_istarted= new JLabel();
		jp_top=new JPanel();
		jp_center=new JPanel();
		jta=new JTextArea();
		
		jb_open=new JButton("打开");
		jb_open.addActionListener(this);

		
		//讲button加到顶部的panel里面
		
		jp_top.add(jb_open);

		jp_top.add(jl_2);
		jp_top.add(jl_istarted);
		
		jp_center.add(jta);
		
		jp_bottom=new JPanel();
		jp_bottom.setLayout(new BorderLayout());
		
		jtf=new JTextField();
		jb_send=new JButton("发送");
		jb_send.addActionListener(this);
		jp_bottom.add(jtf,BorderLayout.CENTER);
		jp_bottom.add(jb_send,BorderLayout.EAST);
		
		
		
		//讲panel加到主窗口里
		this.add(jp_top,BorderLayout.NORTH);
		this.add(jta,BorderLayout.CENTER);
		this.add(jp_bottom,BorderLayout.SOUTH);
		
		
		this.setVisible(true);
		this.setTitle("服务器端");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(this.getMaximumSize());
		this.setSize(400, 300);
	
	}
	public void addMessageToJTA(){
		jta.append(this.server.getInput().getMessage());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb_send)
		{
			server.getOutput().sendMessage(this.jtf.getText().trim());
		}
		if(e.getSource()==jb_open)
		{
			if(Server.isstarted==true)
			{
				JOptionPane.showMessageDialog(this, "端口被占用，无法重复打开");
				return;
				
			}
			server.start();
			jl_istarted.setText("打开");
			JOptionPane.showMessageDialog(this, "端口已打开");
			server.initSocket();
			
		}
	
	}
	public Server getServer() {
		return server;
	}
	public void setServer(Server server) {
		this.server = server;
	}
	public JTextArea getJta() {
		return jta;
	}
	public void setJta(JTextArea jta) {
		this.jta = jta;
	}
	public static void main(String[] args) {
		Server_view a=new  Server_view();
		int i=0;
		while(true){
			if(a.getServer().getMySocket()!=null&&a.getServer().getMySocket().isConnected())
			{
				if(i==0){
					System.out.println("ko");
					
					try {
						Thread.sleep(1000);
						i++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				a.addMessageToJTA();
				
			}
			System.out.println("ok");
		}
	}


}
