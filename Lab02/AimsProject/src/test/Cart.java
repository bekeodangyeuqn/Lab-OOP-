package test;

public class Cart {
	private int qtyOrdered;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		int quantity = this.getQtyOrdered();
		if (quantity >= 20) {
			System.out.println("The cart is almost full.");
		} else {
			this.itemsOrdered[quantity] = disc;
			System.out.println("The disc has been added.");
			quantity = quantity + 1;
			this.setQtyOrdered(quantity);
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		DigitalVideoDisc itemsTempOrdered[] = new DigitalVideoDisc[this.getQtyOrdered()-1];
		for (int i = 0, j = 0; i < this.getQtyOrdered(); i++) {
			if (!this.itemsOrdered[i].getTitle().equals(disc.getTitle())) {
				itemsTempOrdered[j] = this.itemsOrdered[i];
				j++;
			}
		}
		for (int k = 0; k < this.getQtyOrdered() - 1; k++) {
			this.itemsOrdered[k] = itemsTempOrdered[k];
		}
		System.out.println("The disc has been removed.");
		this.setQtyOrdered(this.getQtyOrdered() - 1);
	}
	public double totalCost() {
		double total = 0;
		for (int i = 0; i < this.getQtyOrdered(); i++) {
			total += this.itemsOrdered[i].getCost();
		}
		return total;
	}
	public void displayCart() {
		System.out.println("=====DISPLAY CART=====");
		for (int i = 0; i < this.getQtyOrdered(); i++) {
			System.out.println(this.itemsOrdered[i].getTitle() + ": ");
			System.out.println(this.itemsOrdered[i].getCost() + "\n");
		}
		System.out.println("===============");
		System.out.println("Total cost is: ");
		System.out.println(this.totalCost());
	}
	public Cart(int qtyOrdered) {
		super();
		this.qtyOrdered = qtyOrdered;
	}
}
