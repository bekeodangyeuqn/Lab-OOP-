package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.AimsMain;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;

public class DVDController extends OptionBase {
	Stage stage;

	DVDController(Stage stage) {
		super(stage);
	}

	@FXML
	private TextField category;

	@FXML
	private TextField cost;

	@FXML
	private TextField director;

	@FXML
	private TextField length;

	@FXML
	private TextField title;

	@FXML
	void addDVDToStorebtn(ActionEvent event) {
		float DVDCost;
		int len;
		// if cost or length is not number will not add
		try {
			DVDCost = Float.parseFloat(cost.getText());
			len = Integer.parseInt(length.getText());
			DigitalVideoDisc dvd = new DigitalVideoDisc(1, title.getText(), category.getText(), director.getText(),len, DVDCost);
			// set empty for input
			title.setText("");
			category.setText("");
			cost.setText("");
			director.setText("");
			length.setText("");
			AimsMain.store.addMedia(dvd);
			Dialog<String> dialog = new Dialog<String>();
    		//Setting the title
    	      dialog.setTitle("Add DVD");
    	      ButtonType type = new ButtonType("Finsh", ButtonData.OK_DONE);
    	      //Setting the content of the dialog
    	      dialog.setContentText("Add " + dvd.getTitle() + " sucessfully");
    	      //Adding buttons to the dialog pane
    	      dialog.getDialogPane().getButtonTypes().add(type);
    	      dialog.showAndWait();
		} catch (Exception e) {

		}

	}

}
