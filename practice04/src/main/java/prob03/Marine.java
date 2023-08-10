package prob03;

public class Marine extends Unit{
	/* 현재 위치 */

	void move(int x, int y) {
		/* 지정된 위치로 이동 */
		this.x = x;
		this.y = y;
	}

	void stop() {
		/* 현재 위치에 정지 */
	}
	
	void stimPack() { 
		/* 스팀팩을 사용한다.*/
	}	
}
