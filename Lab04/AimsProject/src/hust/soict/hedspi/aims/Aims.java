package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		List<Media> mediae = new ArrayList<Media>();
		DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The pig king", "Animation", "Roger Alias", 97, (float) 20.95);
		Book book = new Book(6, "Game", "Fiction", (float) 19.04);
		CompactDisc cd = new CompactDisc(5, "The snake king", "Animation", "Roger Alias", 97, (float) 20.95);
		mediae.add(dvd);
		mediae.add(book);
		mediae.add(cd);
		
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "The lion king", "Animation", "Roger Aliers", 87, (float) 19.95);
		anOrder.addMedia(dvd1);
		dvd1.toString();
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(3, "Star Wars", "Science Fiction", "Geore Lucas", 87, (float) 24.95);
		anOrder.addMedia(dvd2);
		dvd2.toString();
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(4, "Aladin", "Animation", "Geore Lucas", 87, (float) 18.99);
		anOrder.addMedia(dvd3);
		dvd3.toString();
		
		anOrder.removeMedia(dvd2);
		
//		System.out.println("Total cost is: ");
//		System.out.println(anOrder.totalCost());
		
		anOrder.displayCart();
	}
}
