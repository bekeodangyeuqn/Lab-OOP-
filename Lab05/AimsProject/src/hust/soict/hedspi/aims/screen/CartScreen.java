package hust.soict.hedspi.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartScreen extends JFrame{
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	
	public Scene getCartScreen(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("Cart.fxml"));
		System.out.println(getClass()
				.getResource("Cart.fxml"));
		CartScreenController controller = new CartScreenController(stage);
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}

//	public CartScreen(Cart cart) {
//		super();
//		
//		this.cart = cart;
//		
//		JFXPanel fxPanel = new JFXPanel();
//		this.add(fxPanel);
//		
//		this.setTitle("Cart");
//		this.setVisible(true);
//		Platform.runLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					FXMLLoader loader = new FXMLLoader(getClass()
//							.getResource("Cart.fxml"));
//					System.out.println(getClass()
//							.getResource("Cart.fxml"));
//					CartScreenController controller = new CartScreenController(cart);
//					loader.setController(controller);
//					Parent root = loader.load();
//					fxPanel.setScene(new Scene(root));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
//	public static void main(String[] args) {
//		cart = new Cart();
//		Media dvd1 = new DigitalVideoDisc(1, "The lion king", "Roger Aliers", "Animation", 87, (float) 19.95);
//		Media book1 = new Book(1, "The Gamers", "Masayoshi Yohei", (float) 9.95);
//		cart.addMedia(dvd1);
//		cart.addMedia(book1);
//		new CartScreen(cart);
//		//launch(args);
//	}
}
