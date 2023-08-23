package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	//Info
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 5556;
	
	//Command
	public static final String COMMAND_ADD = "ADD";
	public static final String COMMAND_ADD_OK = "ADD:OK";
	public static final String COMMAND_ADD_FAIL = "ADD:FAIL";
	public static final String COMMAND_MSG = "MSG";
	public static final String COMMAND_SYSTEM = "SYSTEM";
	public static final String SYSTEM_COMMAND_QUIT = "/QUIT";
	public static final String SYSTEM_COMMAND_WHISPER = "/WHISPER"; //귓속말
	public static final String SYSTEM_COMMAND_MEMS = "/MEMS";
	public static final String SYSTEM_COMMAND_WHISPER_OK = "WHISPER_OK"; 
	public static final String SYSTEM_COMMAND_WHISPER_FAIL = "WHISPER_FAIL";
	
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print("> ");
			name = scanner.nextLine();
			
			if (!name.isEmpty()) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		//1. Create Socket
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			//2. Connect Server
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, PORT), 10);
			
			//2-1. I/O
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
			
			//3. ADD Protocol
			pw.println(COMMAND_ADD + ":" + name + "@" + "1234");

			//4. ADD ACK
			String ack = br.readLine();
			if(COMMAND_ADD_OK.equals(ack)) {
				new ChatClientThread(name, br, pw).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			scanner.close();
		}
	}

}
