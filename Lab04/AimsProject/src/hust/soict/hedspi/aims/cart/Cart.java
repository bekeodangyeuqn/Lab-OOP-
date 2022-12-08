package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

// import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
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
	public void addMedia(Media m) {
		if (!this.getItemsOrdered().contains(m)) {
			itemsOrdered.add(m);
			System.out.println("Item have added sucessfully!");
			return ;
		}
		System.out.println("Added failed. Item have already in the list.");
	}
	public void removeMedia(Media m) {
		if (this.getItemsOrdered().contains(m)) {
			itemsOrdered.remove(m);
			System.out.println("Item have deleteed sucessfully!");
			return ;
		}
		System.out.println("Deleted failed. Item not in the list.");
	}
	/**
	 * @param qtyOrdered
	 */
	public Cart() {
		super();
	}
}
