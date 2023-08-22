package chat.gui;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientThread extends Thread{
	private String name;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	
	public ChatClientThread(String name, BufferedReader br, PrintWriter pw) {
		this.name = name;
		this.br = br;
		this.pw = pw;
	}
	
	@Override
	public void run() {
		new ChatWindow(name, br, pw).show();
	}
	
	
}
