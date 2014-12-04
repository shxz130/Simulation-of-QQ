package com.shxz.clent;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client_view extends JFrame implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	Client client;
	private JTextField jtf;
	private JButton jb_start, jb_send,jb_close;
	private JTextArea jta;
	private JPanel jp1, jp2;
	public Client_view()
	{
		client=new Client();
		jtf=new JTextField("  ");
		jb_send=new JButton("����");
		jb_send.addActionListener(this);
		jb_close=new JButton("�Ͽ�����");
		jb_close.addActionListener(this);
		jb_start=new JButton("���ӷ�����");
		jb_start.addActionListener(this);
	
		jta=new JTextArea();
		jp2=new JPanel();
		jp1=new JPanel();

		jp1.setLayout(new BorderLayout());
		jp1.add(jtf,BorderLayout.CENTER);
		jp1.add(jb_send,BorderLayout.EAST);
		jp2.add(jb_start);
		jp2.add(jb_close);
		
		this.setLayout(new BorderLayout());

		this.add(jp2,BorderLayout.NORTH);
		this.add(jta, BorderLayout.CENTER);
		this.add(jp1,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�ͻ���");
	}

	
	public void addMessageToJTA(){
		jta.append(this.client.getInput().getMessage());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==jb_send)
		{
			System.out.println(this.jtf.getText().trim());
			client.getOutput().sendMessage(this.jtf.getText().trim());
		}
		
		if(e.getSource()==jb_start)
		{
			if(client.getIsconnected())
			{
				JOptionPane.showMessageDialog(this, "��������ͨ������Ҫ�ظ�����");
				return;
			}
			client.start();
			if(client.getIsconnected())
			{
				JOptionPane.showMessageDialog(this, "���ӳɹ�");
			}else{
				JOptionPane.showMessageDialog(this, "������δ����������ʧ��");
			}
		}
		if(e.getSource()==jb_close)
		{
			client.close();
			JOptionPane.showMessageDialog(this, "�ѹر�");
		}
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public static void main(String[] args) {
		Client_view a=new Client_view();	
		
		int i=0;
		while(true){
			
			if(a.getClient().getMySocket()!=null&&a.getClient().getMySocket().isConnected())
			{
				if(i==0){
					try {
						Thread.sleep(1000);
						i++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("ko");
				a.addMessageToJTA();
			}
			System.out.println("ok");
		
		}
	}
}
