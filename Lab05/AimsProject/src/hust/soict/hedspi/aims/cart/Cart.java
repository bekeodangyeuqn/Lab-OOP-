package hust.soict.hedspi.aims.cart;

// import java.util.ArrayList;

// import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class Cart {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	public ObservableList<Media> getItemsOrdered(String title) {
		ObservableList<Media> mediaList = FXCollections.observableArrayList();
		if (title == "")
			return itemsOrdered;
		for (Media media : itemsOrdered) {
			if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
				mediaList.add(media);
			}
		}
		return mediaList;
	}

	public ObservableList<Media> getItemsOrdered(int id) {
		// find by ID
		ObservableList<Media> mediaList = FXCollections.observableArrayList();
		mediaList.add(findMediaById(id));
		return mediaList;
	}
	public double totalCost() {
		double total = 0;
		int size = itemsOrdered.size();
		for (int i = 0; i < size; i++) {
			total += itemsOrdered.get(i).getCost();
		}
		return total;
	}
	public void displayCart() {
		int size = itemsOrdered.size();
		System.out.println("=====DISPLAY CART=====");
		for (int i = 0; i < size; i++) {
			System.out.println(itemsOrdered.get(i).toString());
		}
		System.out.println("===============");
		System.out.println("Total cost is: ");
		System.out.println(this.totalCost());
	}
	public boolean isMatch(String title) {
		for (Media item : itemsOrdered) {
			if (item.getTitle().equals(title))
				return true;
		}
		return false;
	}
	public boolean searchByTitle(String title) {
		int count = 0;
		for (Media item : itemsOrdered) {
			if (item.getTitle().equals(title)) {
				System.out.println(item.toString());
				System.out.println("\n");
				count++;
				return true;
			}
		}
		if (count == 0) System.out.println("No DVD is found with " + title);
		return false;
	}
	public boolean searchById(int id) {
		for (Media item : itemsOrdered) {
			if (item.getId() == id) {
				System.out.println(item.toString());
				return true;
			}
		}
		System.out.println("No DVD is found with this " + id);
		return false;
	}
	// find media by id
		public Media findMediaById(int id) {
			for (Media media : itemsOrdered)
				if (media.getId() == id)
					return media;
			return null;
		}

		// find media by title
		public Media findMediaByTitle(String title) {
			for (Media media : itemsOrdered)
				if (media.getTitle().equals(title))
					return media;
			return null;
		}
	public void addMedia(Media m) {
		if (!this.getItemsOrdered().contains(m)) {
			itemsOrdered.add(m);
			System.out.println("Item have added sucessfully!");
			Dialog<String> dialog = new Dialog<String>();
			//Setting the title
		      dialog.setTitle("Add to cart");
		      ButtonType type = new ButtonType("Finsh", ButtonData.OK_DONE);
		      //Setting the content of the dialog
		      dialog.setContentText("Add " + m.getTitle() + " to cart sucessfully! ^^");
		      //Adding buttons to the dialog pane
		      dialog.getDialogPane().getButtonTypes().add(type);
		      dialog.showAndWait();
			return ;
		}
		System.out.println("Added failed. Item have already in the list.");
		Dialog<String> dialog = new Dialog<String>();
		//Setting the title
	      dialog.setTitle("Add to cart");
	      ButtonType type = new ButtonType("Finsh", ButtonData.OK_DONE);
	      //Setting the content of the dialog
	      dialog.setContentText("Added failed. Item have already in the list.");
	      //Adding buttons to the dialog pane
	      dialog.getDialogPane().getButtonTypes().add(type);
	      dialog.showAndWait();
	}
	public void removeMedia(Media m) {
		if (this.getItemsOrdered().contains(m)) {
			itemsOrdered.remove(m);
			System.out.println("Item have deleteed sucessfully!");
			Dialog<String> dialog = new Dialog<String>();
			//Setting the title
		      dialog.setTitle("Remove cart");
		      ButtonType type = new ButtonType("Finsh", ButtonData.OK_DONE);
		      //Setting the content of the dialog
		      dialog.setContentText("Remove " + m.getTitle() + " from cart sucessfully! <<");
		      //Adding buttons to the dialog pane
		      dialog.getDialogPane().getButtonTypes().add(type);
		      dialog.showAndWait();
			return ;
		}
		System.out.println("Deleted failed. Item not in the list.");
		Dialog<String> dialog = new Dialog<String>();
		//Setting the title
	      dialog.setTitle("Remove cart");
	      ButtonType type = new ButtonType("Finsh", ButtonData.OK_DONE);
	      //Setting the content of the dialog
	      dialog.setContentText("Deleted failed. Item not in the list.");
	      //Adding buttons to the dialog pane
	      dialog.getDialogPane().getButtonTypes().add(type);
	      dialog.showAndWait();
	}
	
	/**
	 * @param qtyOrdered
	 */
	public Cart() {
		super();
	}
}
