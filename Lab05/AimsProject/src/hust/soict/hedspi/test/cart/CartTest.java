package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The lion king", "Animation", "Roger Aliers", 87, (float) 19.95);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "Geore Lucas", 87, (float) 24.95);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", "Geore Lucas", 87, (float) 18.99);
		cart.addMedia(dvd3);
		
		//cart.displayCart();
		cart.searchById(1);
	}
}
