package prob03;

public class DropShip extends Unit{
	/* 현재 위치 */
	
	void move(int x, int y) {
		/* 지정된 위치로 이동 */
		this.x = x;
		this.y = y;
	}

	void stop() {
		/* 현재 위치에 정지 */
	}
	
	void load() {
		/* 선택된 대상을 태운다.*/ 
	}
	
	void unload() {
		/* 선택된 대상을 내린다.*/ 
	}
}