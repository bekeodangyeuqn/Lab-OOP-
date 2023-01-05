package hust.soict.hedspi.aims.media;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import hust.soict.hedspi.aims.exception.PlayerException;
import javafx.scene.control.ButtonBar.ButtonData;

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
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			Dialog<String> dialog = new Dialog<String>();
		      //Setting the title
		      dialog.setTitle("Play Dialog");
		      ButtonType type = new ButtonType("Finsh", ButtonData.OK_DONE);
		      //Setting the content of the dialog
		      dialog.setContentText(this.getTitle() + " is playing!");
		      //Adding buttons to the dialog pane
		      dialog.getDialogPane().getButtonTypes().add(type);
		      dialog.showAndWait();
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}
}
