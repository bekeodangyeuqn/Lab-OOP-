package hust.soict.hedspi.aims.media;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import hust.soict.hedspi.aims.exception.PlayerException;
import javafx.scene.control.ButtonBar.ButtonData;

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
	public void play() throws PlayerException{
		Dialog<String> dialog = new Dialog<String>();
	      //Setting the title
	      dialog.setTitle("Play Dialog");
	      ButtonType type = new ButtonType("Finsh", ButtonData.OK_DONE);
	      //Setting the content of the dialog
	      dialog.setContentText(this.getTitle() + " is playing: " + this.getLength());
	      //Adding buttons to the dialog pane
	      dialog.getDialogPane().getButtonTypes().add(type);
	      dialog.showAndWait();
	}
	public boolean equals(Object obj) {
		Track t = (Track) obj;
		if (this.getLength() == t.getLength() && this.getTitle().equals(t.getTitle())) {
			return true;
		}
		return false;
	}
}
