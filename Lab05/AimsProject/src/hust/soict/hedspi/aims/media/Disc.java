package hust.soict.hedspi.aims.media;

public class Disc extends Media{
	private int length;
	private String director;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public Disc(int id, String title, String category,  String director, int length, float cost) {
		super(id, title, category, cost);
		this.setLength(length);
		this.setDirector(director);
	}
	public Disc(int id, String title, String director, int length) {
		super(id, title);
		this.setLength(length);
		this.setDirector(director);
	}
	@Override
	public String toString() {
		return "";
	}
	public Disc(String string) {
		super(string);
	}
}
