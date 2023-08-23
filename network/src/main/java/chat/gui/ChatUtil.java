package chat.gui;

public class ChatUtil {
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
		System.out.print("[" + system +"] " + message);
	}
}
