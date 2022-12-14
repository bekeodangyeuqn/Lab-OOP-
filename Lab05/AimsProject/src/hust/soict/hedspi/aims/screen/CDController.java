package hust.soict.hedspi.aims.screen;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.AimsMain;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CDController extends OptionBase {
	Stage stage;

	CDController(Stage stage) {
		super(stage);
	}

	@FXML
	private TextField category;

	@FXML
	private TextField cost;

	@FXML
	private TextField title;

	@FXML
	private VBox trackVbox;

	@FXML
	void addCDToStoreBtn(ActionEvent event) {
		List<Track> tracks = new ArrayList<Track>();
		CompactDisc cd;
		// get HBox of track and content
		// if type in class is number but in textfield is string. No accept
		try {
			for (Node node : trackVbox.getChildren()) {
				if (node instanceof HBox) {
					HBox hbox = (HBox) node;
					String titleOfTrack = null;
					int lenOfTrack = 0;
					// get node is children of HBox
					for (Node nd : hbox.getChildren()) {
						if (nd.getTypeSelector().equals("TextField")) {
							// get content
							if (titleOfTrack == null)
								titleOfTrack = ((TextField) nd).getText();
							else
								lenOfTrack = Integer.parseInt(((TextField) nd).getText());
						}
					}
					tracks.add(new Track(titleOfTrack, lenOfTrack));

				}
			}

			// get title,cat,cost of CD and create cd
			cd = new CompactDisc(1, title.getText(), category.getText(), "a",2, Float.parseFloat(cost.getText()), "a",
					tracks);
			AimsMain.store.addMedia(cd);
			Dialog<String> dialog = new Dialog<String>();
    		//Setting the title
    	      dialog.setTitle("Add CD");
    	      ButtonType type = new ButtonType("Finsh", ButtonData.OK_DONE);
    	      //Setting the content of the dialog
    	      dialog.setContentText("Add " + cd.getTitle() + " sucessfully");
    	      //Adding buttons to the dialog pane
    	      dialog.getDialogPane().getButtonTypes().add(type);
    	      dialog.showAndWait();
		} catch (Exception e) {

		}

	}

}
