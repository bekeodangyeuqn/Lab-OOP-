package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

// import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_DVD = 1000;
	private int dvdStored = 0;
	private ArrayList<Media> itemsInStore =  new ArrayList<Media>();
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public int getDvdStored() {
		return dvdStored;
	}

	public void setDvdStored(int dvdStored) {
		this.dvdStored = dvdStored;
	}
	
	public void addMedia(Media m) {
		int quantity = itemsInStore.size();
		if (quantity >= MAX_NUMBERS_DVD) {
			System.out.println("The cart is almost full.");
		} else {
			itemsInStore.add(m);
			System.out.println("The item has been added.");
		}
	}
	public void removeMedia(Media m) {
		int size = itemsInStore.size();
		for (int i = 0; i < size; i++) {
			if (!itemsInStore.get(i).getTitle().equals(m.getTitle())) {
				itemsInStore.remove(m);
			}
		}
		System.out.println("The disc has been removed.");
	}
}
