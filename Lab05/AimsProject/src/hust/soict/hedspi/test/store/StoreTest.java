package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store s = new Store();
		Media dvd1 = new DigitalVideoDisc(1, "The lion king", "Roger Aliers", "Animation", 87, (float) 19.95);
		s.addMedia(dvd1);
	}
}
