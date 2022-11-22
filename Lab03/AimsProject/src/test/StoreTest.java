package test;

public class StoreTest {
	public static void main(String[] args) {
		Store s = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Aliers", 87, 19.95);
		s.addDVD(dvd1);
	}
}
