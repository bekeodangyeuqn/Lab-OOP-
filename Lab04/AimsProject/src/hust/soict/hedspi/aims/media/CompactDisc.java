package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public CompactDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director, length, cost);
	}
	public CompactDisc(int id, String title, String director, int length) {
		super(id, title, director, length);
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) 
			System.out.println("Add failed. The track have already in the Disc.");
		else {
			tracks.add(track);
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) 
			tracks.remove(track);
		else 
			System.out.println("Remove failed. The track not in the Disc.");
	}
	
	public int getLength() {
		int size = tracks.size();
		int res = 0;
		for (int i = 0; i < size; i++) {
			res = res + tracks.get(i).getLength();
		}
		return res;
	}
	public void play() {
		for (Track track : tracks) {
			track.play();
			System.out.println("===============");
		}
	}
	@Override
	public String toString() {
		return "CD - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getCost() + "$" ;
	}
}
