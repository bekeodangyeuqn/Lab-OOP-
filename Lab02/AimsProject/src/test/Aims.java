package test;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart(0);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Aliers", 87, 19.95);
		anOrder.addDigitalVideoDisc(dvd1);
		dvd1.printData();
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geore Lucas", 87, 24.95);
		anOrder.addDigitalVideoDisc(dvd2);
		dvd2.printData();
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Geore Lucas", 87, 18.99);
		anOrder.addDigitalVideoDisc(dvd3);
		dvd3.printData();
		
		anOrder.removeDigitalVideoDisc(dvd2);
		
//		System.out.println("Total cost is: ");
//		System.out.println(anOrder.totalCost());
		
		anOrder.displayCart();
	}
}
