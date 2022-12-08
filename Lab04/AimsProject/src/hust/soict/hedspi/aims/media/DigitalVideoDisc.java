package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	// private static int nbDigitalVideoDiscs = 0;
	
	@Override
	public String toString() {
		return "DVD - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getCost() + "$" ;
	}
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director, length, cost);
	}
	public DigitalVideoDisc(int id, String title, String director, int length) {
		super(id, title, director, length);
	}
	public DigitalVideoDisc(String string) {
		super(string);
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
