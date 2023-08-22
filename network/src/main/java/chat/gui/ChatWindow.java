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

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	//socket 받아와 작업해야함!!
	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
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
		//위와 아래가 같음.. 추정하는것!추론하는것!
		buttonSend.addActionListener((ActionEvent e)->{
			
		});

		// Textfield
		textField.setColumns(80);
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
		frame.pack();
		
		// IOStream 받아오기
		// ChatClientThread 생성 및 실행
	}
	
	private void finish() {
		//quit 프로토콜 구현
		
		//exit java(jvm)
		System.exit(0); // jvm 종료.. 0(정상종료)/1(비정상종료)
	}
	
	private void sendMessage() {
		String message = textField.getText();
		
		System.out.println("Messaeg Send Protocol :" + message);
		
		textField.setText("");
		textField.requestFocus(); //마우스 포커스 가저오기
		
		//ChatClientThread 에서 서버로 부터 받은 메세지가 있다고 가정하고..
		updateTextArea("마이콜 : " + message);
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private class ChatClientThread extends Thread{

		@Override
		public void run() {
			updateTextArea("마이콜: 안녕");//받은 데이터
			
		}
		
	}
}
