package chapter03;

public class Song {
	private String title;
	private String album;
	private String composer;
	private String artist;
	private int track;
	private int year;
	
	public Song() {
		//default constructor
	}
	
	public Song(String title, String artist) {
//		this.title = title;
//		this.artist = artist;
		
		this(title, null ,null, artist, 0,0); // 이게 song() constructor중 param이 5개인 생성자를 자동 호출
		//생성자 안에 코드 재사용성을 위해 위와 같이 사용!
	}
	
	public Song(String title, String album, String composer, String artist, int track, int year) {
		this.title = title;
		this.album = album;
		this.composer = composer;
		this.artist = artist;
		this.track = track;
		this.year = year;
		
		System.out.println("hello world!"); // 생성자 안에,,, 실행 코드가 있다고 가정..
		System.out.println("dkjfasljfls");
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void show() {
		System.out.println(this.artist + " " + this.title + "("
			+ this.album +"," + this.year + "," + this.composer
			+ " 작곡)");
	}
}
