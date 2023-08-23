package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatWindow {
	private BufferedReader br = null;
	private PrintWriter pw = null;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	//socket 받아와 작업해야함!!
	public ChatWindow(String name, BufferedReader br, PrintWriter pw) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.br = br;
		this.pw = pw;
	}

	//window show!
	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//sendMessage();
				sendMessage();
			}
		});
//		//위와 아래가 같음.. 추정하는것!추론하는것!
//		buttonSend.addActionListener((ActionEvent e)->{
//			
//		});

		// Textfield
		textField.setColumns(40);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
			
		});
		
		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);
		
		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
//		frame.pack();
		frame.setSize(500,500);
		
		// IOStream 받아오기
		// ChatClientThread 생성 및 실행
		new ChatClientThread().start();
	}
	
	private void finish() {
		//quit 프로토콜 구현
		pw.println(ChatClientApp.SYSTEM_COMMAND_QUIT);
		try {
			if(br != null) {
				br.close();
			}
			if(pw != null) {
				pw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//exit java(jvm)
		System.exit(0); // jvm 종료.. 0(정상종료)/1(비정상종료)
	}
	
	private void sendMessage() {
		String message = textField.getText();
		if (message.isEmpty()) {
			return;
		}
		
		System.out.println("system log :" + message);
		
		if(ChatClientApp.SYSTEM_COMMAND_QUIT.equals(message)) {
			finish();
		}else if(message.charAt(0) == '/' && message.contains(ChatClientApp.SYSTEM_COMMAND_WHISPER)){
			String[] tokens = message.split(" ");
			if (tokens.length < 3) {
				updateTextArea("*귓속말 기능은 /WHISPER TARGET MESSAGE 형태여야합니다.");//받은 데이터
				return;
			}
			pw.println(ChatClientApp.SYSTEM_COMMAND_WHISPER + ":" + tokens[1] + "/" +tokens[2]);
		}else if(ChatClientApp.SYSTEM_COMMAND_MEMS.equals(message)){
			pw.println(ChatClientApp.SYSTEM_COMMAND_MEMS);
		}else {//Message
			pw.println(ChatClientApp.COMMAND_MSG + ":" + message);
		}
		textField.setText("");
		textField.requestFocus(); //마우스 포커스 가저오기
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private class ChatClientThread extends Thread{

		@Override
		public void run() {
			try {
				while(true) {
					String line = br.readLine();
					
					if(line == null) {
						break;
					}
					
					String[] tokens = line.split(":");
					if((ChatClientApp.COMMAND_MSG).equals(tokens[0])) {
						updateTextArea(tokens[1]);
					}else if((ChatClientApp.COMMAND_SYSTEM).equals(tokens[0])){
						updateTextArea(tokens[1]);
					}else if((ChatClientApp.SYSTEM_COMMAND_QUIT).equals(tokens[0])){
						break;
					}else if((ChatClientApp.SYSTEM_COMMAND_WHISPER_OK).equals(tokens[0])){
						updateTextArea("(귓속말) " + tokens[1]);
					}else {
						System.out.println("정의되지 않은 명령어 입니다.");
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				this.interrupt();
			}
		}
	}
}
