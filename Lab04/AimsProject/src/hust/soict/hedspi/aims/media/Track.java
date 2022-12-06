package hust.soict.hedspi.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Track() {
		super();
	}
	public Track(String title) {
		super();
		this.setTitle(title);
	}
	public Track(int length) {
		super();
		this.setLength(length);
	}
	public Track(String title, int length) {
		super();
		this.setTitle(title);
		this.setLength(length);
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	public boolean equals(Object obj) {
		Track t = (Track) obj;
		if (this.getLength() == t.getLength() && this.getTitle().equals(t.getTitle())) {
			return true;
		}
		return false;
	}
}
