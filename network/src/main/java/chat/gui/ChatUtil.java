package chat.gui;

public class ChatUtil {
	
	/* 1. Protocol
	 * *본 작업에서 통신 프로토콜은 아래와 같다.
	 * 모든 메시지는 '명령어:메시지' 구조로 한다. 
	 * 단, 귓속말(/WHISPER)의 경우 '명령어 타깃 전송할메시지' 구조이다.
	 * 명령어 : 
	 * 	1) ADD = 사용자 추가
	 * 	usage) ADD:user_name
	 *   return ADD:OK 
	 *   return ADD:FAIL  
	 *  
	 *  2) MSG = 메시지 전송
	 *  usage) MSG:hello world!
	 *  
	 *  '/'가 붙은 명령어의 경우 SYSTEM_COMMAND로 분류. ChatUtil에 정의된 COMMAND 확인!
	 *  3) /WHISPER = 귓속말
	 *  usage) /WHISPER user_name message
	 *    	/WHISPER yoncho hello 하게되면 yoncho라는 client에게 hello메시지를 귓속말로 전송.
	 *  
	 *  4) /QUIT = 퇴장
	 *  
	 *  5) /MEMS = 현재 채팅방의 사용자 목록 표시
	 * */
	//Command
	public static final String COMMAND_ADD = "ADD";
	public static final String COMMAND_ADD_OK = "ADD:OK";
	public static final String COMMAND_ADD_FAIL = "ADD:FAIL";
	public static final String COMMAND_MSG = "MSG";
	public static final String COMMAND_SYSTEM = "SYSTEM";
	public static final String SYSTEM_COMMAND_QUIT = "/QUIT";
	public static final String SYSTEM_COMMAND_MEMS = "/MEMS";
	public static final String SYSTEM_COMMAND_WHISPER = "/WHISPER"; //귓속말
	public static final String SYSTEM_COMMAND_WHISPER_OK = "WHISPER_OK"; 
	public static final String SYSTEM_COMMAND_WHISPER_FAIL = "WHISPER_FAIL";
	
	//System Log
	public static void systemLog(String system, String message) {
		System.out.println("[" + system +"] " + message);
	}
}
