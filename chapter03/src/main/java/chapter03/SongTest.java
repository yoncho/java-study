package chapter03;

public class SongTest {

	public static void main(String[] args) {
		Song song1 = new Song();
		
		song1.setTitle("좋은 날");
		song1.setArtist("아이유");
		song1.setAlbum("Real");
		song1.setComposer("윤민수");
		song1.setTrack(3);
		song1.setYear(2010);
		
		song1.show();
		
		Song song2 = new Song("강남 스타일", "싸이", "싸이","싸이", 0, 2012);
		song2.show();
		
		Song song3 = new Song("헬로우", "인더");
		song3.show();
	}
}
