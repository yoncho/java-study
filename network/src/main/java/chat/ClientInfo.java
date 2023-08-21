package chat;

import java.io.PrintWriter;

public class ClientInfo {
	private String nickName;
	private Long primaryKey;
	private PrintWriter printWriter;
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	public PrintWriter getPrintWriter() {
		return printWriter;
	}

	public void setPrintWriter(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}

	public ClientInfo(String nickName,Long primaryKey, PrintWriter printWriter) {
		this.nickName = nickName;
		this.primaryKey = primaryKey;
		this.printWriter = printWriter;
	}
}
