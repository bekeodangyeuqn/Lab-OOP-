package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	public static void showMenu() {
		System.out.println("AIMS");
		System.out.println("-----------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. See a media details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	public static void main(String[] args) {
		
//		Cart anOrder = new Cart();
//		List<Media> mediae = new ArrayList<Media>();
//		DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The pig king", "Animation", "Roger Alias", 97, (float) 20.95);
//		Book book = new Book(6, "Game", "Fiction", (float) 19.04);
//		book.addAuthor("Yuuya");
//		book.addAuthor("Misaki");
//		CompactDisc cd = new CompactDisc(5, "The snake king", "Animation", "Roger Alias", 97, (float) 20.95);
//		mediae.add(dvd);
//		mediae.add(book);
//		mediae.add(cd);
//		
//		for (Media m: mediae) {
//			System.out.println(m.toString());
//		}
//		mediae.sort(Media.COMPARE_BY_TITLE_COST);
//		System.out.println("After sorting by title cost ========");
//		for (Media m: mediae) {
//			System.out.println(m.toString());
//		}
//		mediae.sort(Media.COMPARE_BY_COST_TITLE);
//		System.out.println("After sorting by cost title ========");
//		for (Media m: mediae) {
//			System.out.println(m.toString());
//		}
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "The lion king", "Animation", "Roger Aliers", 87, (float) 19.95);
//		anOrder.addMedia(dvd1);
//		dvd1.toString();
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc(3, "Star Wars", "Science Fiction", "Geore Lucas", 87, (float) 24.95);
//		anOrder.addMedia(dvd2);
//		dvd2.toString();
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc(4, "Aladin", "Animation", "Geore Lucas", 87, (float) 18.99);
//		anOrder.addMedia(dvd3);
//		dvd3.toString();
//		
//		anOrder.removeMedia(dvd2);
//		
////		System.out.println("Total cost is: ");
////		System.out.println(anOrder.totalCost());
//		
//		anOrder.displayCart();
		Scanner s = new Scanner(System.in);
		Store store = new Store();
		Cart cart = new Cart();
		while(true) {
			showMenu();
			int showMenuChoice = s.nextInt();
			if (showMenuChoice == 1) {
				for (Media item : store.getItemsInStore()) {
					System.out.println(item.toString());
				}
				while(true) {
					for (Media item : store.getItemsInStore()) {
						System.out.println(item.toString());
					}
					storeMenu();
					int storeMenuChoice = s.nextInt();
					if (storeMenuChoice == 1) {
						s.nextLine();
						System.out.println("What's title of media: ");
						String title = s.nextLine();
						int flag = 0;
						for (Media item : store.getItemsInStore()) {
							if (item.getTitle().compareTo(title) == 0) {
								System.out.println(item.toString());
								while(true) {
									mediaDetailsMenu();
									int mediaDetailsMenuChoice = s.nextInt();
									if (mediaDetailsMenuChoice == 1) {
										cart.addMedia(item);
									} else if (mediaDetailsMenuChoice == 2) {
										if (item instanceof DigitalVideoDisc) {
											DigitalVideoDisc dvd = (DigitalVideoDisc) item;
										    try {
												dvd.play();
											} catch (PlayerException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										} else if (item instanceof CompactDisc) {
											CompactDisc cd = (CompactDisc) item;
											try {
												cd.play();
											} catch (PlayerException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										} else {
											System.out.println("Can't play with this type of media.");
										}
									} else if (mediaDetailsMenuChoice == 0) {
										break;
									}
								}
								flag = 1;
								break;
							}
						}
						if (flag == 0) System.out.println("Not media with this title in store.");
					} else if (storeMenuChoice == 2) {
						s.nextLine();
						System.out.println("What's title of media you want to add to cart");
						String title = s.nextLine();
						int flag = 0;
						for (Media item : store.getItemsInStore()) {
							if (item.getTitle().compareTo(title) == 0) {
								cart.addMedia(item);
								flag = 1;
								break;
							}
						}
						if (flag == 0) System.out.println("Not media with this title in store.");
					} else if (storeMenuChoice == 3) {
						s.nextLine();
						System.out.println("What's title of media you want to play");
						String title = s.nextLine();
						int flag = 0;
						for (Media item : store.getItemsInStore()) {
							if (item.getTitle().compareTo(title) == 0) {
								if (item instanceof DigitalVideoDisc) {
									DigitalVideoDisc dvd = (DigitalVideoDisc) item;
								    try {
										dvd.play();
									} catch (PlayerException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else if (item instanceof CompactDisc) {
									CompactDisc cd = (CompactDisc) item;
									try {
										cd.play();
									} catch (PlayerException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else {
									System.out.println("Can't play with book.");
								}
							}
							flag = 1;
							break;
						}
						if (flag == 0) System.out.println("Not media with this title in store.");
					} else if (storeMenuChoice == 4) {
						cart.displayCart();
						while(true) {
							cartMenu();
							int cartMenuChoice = s.nextInt();
							if (cartMenuChoice == 1) {
								while(true) {
									System.out.println("Options: ");
									System.out.println("-----------------------------");
									System.out.println("1. Filter by id");
									System.out.println("2. Filter by title");
									System.out.println("0. Back");
									System.out.println("-----------------------------");
									int filterChoice = s.nextInt();
									if (filterChoice == 1) {
										System.out.println("ID you want to filter: ");
										int id = s.nextInt();
										cart.searchById(id);
									} else if (filterChoice == 2) {
										s.nextLine();
										System.out.println("Title you want to filter: ");
										String title = s.nextLine();
										cart.searchByTitle(title);
									} else if (filterChoice == 0) {
										break;
									}
								}
							} else if (cartMenuChoice == 2) {
								while(true) {
									System.out.println("Options: ");
									System.out.println("-----------------------------");
									System.out.println("1. Sort by title");
									System.out.println("2. Sort by cost");
									System.out.println("0. Back");
									System.out.println("-----------------------------");
									int sortChoice = s.nextInt();
									if (sortChoice == 1) {
										cart.getItemsOrdered().sort(Media.COMPARE_BY_TITLE_COST);
										cart.getItemsOrdered().toString();
									} else if (sortChoice == 2) {
										cart.getItemsOrdered().sort(Media.COMPARE_BY_COST_TITLE);
										cart.getItemsOrdered().toString();
									} else if (sortChoice == 0) {
										break;
									}
								}
							} else if (cartMenuChoice == 3) {
								s.nextLine();
								System.out.println("Title you want to remove from cart: ");
								String title = s.nextLine();
								for (Media item : cart.getItemsOrdered()) {
									if (item.getTitle().equals(title)){
										cart.removeMedia(item);
										break;
									}
								}
							} else if (cartMenuChoice == 4) {
								s.nextLine();
								System.out.println("What's title of media: ");
								String title = s.nextLine();
								int flag = 0;
								for (Media item : cart.getItemsOrdered()) {
									if (item.getTitle().compareTo(title) == 0) {
										System.out.println(item instanceof DigitalVideoDisc);
										System.out.println(item instanceof CompactDisc);
										if (item instanceof DigitalVideoDisc) {
											DigitalVideoDisc dvd = (DigitalVideoDisc) item;
										    try {
												dvd.play();
											} catch (PlayerException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										} else if (item instanceof CompactDisc) {
											CompactDisc cd = (CompactDisc) item;
											try {
												cd.play();
											} catch (PlayerException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										} else {
											System.out.println("Can't play with book.");
										}
									}
									flag = 1;
									break;
								}
								if (flag == 0) System.out.println("Not media with this title in store.");
							} else if (cartMenuChoice == 5) {
								ArrayList<Media> tmp = new ArrayList<>();
								cart.getItemsOrdered().removeAll(tmp);
								System.out.println("Order is created.");
							} else if (cartMenuChoice == 0) {
								break;
							}
						}
					} else if (storeMenuChoice == 0) {
						break;
					}
				}
			} else if (showMenuChoice == 2) {
				while(true) {
					System.out.println("Options: ");
					System.out.println("-----------------------------");
					System.out.println("1. Add media to store");
					System.out.println("2. Remove media to store");
					System.out.println("0. Back");
					System.out.println("-----------------------------");
					int updateStoreChoice = s.nextInt();
					if (updateStoreChoice == 1) {
						while(true) {
							System.out.println("Choose type of media to add store: ");
							System.out.println("-----------------------------");
							System.out.println("1. Book");
							System.out.println("2. DVD");
							System.out.println("3. CD");
						    System.out.println("0. Back");
							System.out.println("-----------------------------");
							int typeChoice = s.nextInt();
							if (typeChoice == 1) {
								s.nextLine();
								System.out.println("What's title of media: ");
								String title = s.nextLine();
								System.out.println("What's cost of media: ");
								float cost = s.nextFloat();
								s.nextLine();
								System.out.println("What's category of media: ");
								String category = s.nextLine();
								Book m = new Book(store.getItemsInStore().size(), title, category, cost);
								System.out.println("Number of author(s): ");
								int numberAuthors = s.nextInt();
								s.nextLine();
								for (int i = 0; i < numberAuthors; i++) {
									String author = s.nextLine();
									m.addAuthor(author);
								}
								store.addMedia(m);
							} else if (typeChoice == 2) {
								s.nextLine();
								System.out.println("What's title of dvd: ");
								String title = s.nextLine();
								System.out.println("What's length of dvd: ");
								int length = s.nextInt();
								s.nextLine();
								System.out.println("Who's director of dvd: ");
								String director = s.nextLine();
								System.out.println("What's cost of dvd: ");
								float cost = s.nextFloat();
								s.nextLine();
								System.out.println("What's category of dvd: ");
								String category = s.nextLine();
								DigitalVideoDisc m = new DigitalVideoDisc(store.getItemsInStore().size(), title, category,  director, length, cost);
								store.addMedia(m);
							} else if (typeChoice == 3) {
								s.nextLine();
								System.out.println("What's title of cd: ");
								String title = s.nextLine();
								System.out.println("What's length of cd: ");
								int length = s.nextInt();
								s.nextLine();
								System.out.println("Who's director of cd: ");
								String director = s.nextLine();
								System.out.println("What's cost of cd: ");
								float cost = s.nextFloat();
								s.nextLine();
								System.out.println("What's category of cd: ");
								String category = s.nextLine();
								System.out.println("What's artist of cd: ");
								String artist = s.nextLine();
								List<Track> tracks = new ArrayList<Track>();
								Track track1 = new Track("Well done", 4);
								tracks.add(track1);
								CompactDisc m = new CompactDisc(store.getItemsInStore().size(), title, category,  director, length, cost, artist, tracks);
								store.addMedia(m);
							} else if (typeChoice == 0) break;
						}
					} else if (updateStoreChoice == 2) {
						s.nextLine();
						System.out.println("What's title of media you want to remove: ");
						String title = s.nextLine();
						int flag = 0;
						for (Media item : store.getItemsInStore()) {
							if (item.getTitle().compareTo(title) == 0) {
								store.removeMedia(item);
								flag = 1;
								break;
							}
						}
						if (flag == 0) System.out.println("No media with this title.");
					} else if (updateStoreChoice == 0) {
						break;
					}
				}
			} else if (showMenuChoice == 3) {
				cart.displayCart();
				while(true) {
					cartMenu();
					int cartMenuChoice = s.nextInt();
					if (cartMenuChoice == 1) {
						while(true) {
							System.out.println("Options: ");
							System.out.println("-----------------------------");
							System.out.println("1. Filter by id");
							System.out.println("2. Filter by title");
							System.out.println("0. Back");
							System.out.println("-----------------------------");
							int filterChoice = s.nextInt();
							if (filterChoice == 1) {
								System.out.println("ID you want to filter: ");
								int id = s.nextInt();
								cart.searchById(id);
							} else if (filterChoice == 2) {
								s.nextLine();
								System.out.println("Title you want to filter: ");
								String title = s.nextLine();
								cart.searchByTitle(title);
							} else if (filterChoice == 0) {
								break;
							}
						}
					} else if (cartMenuChoice == 2) {
						while(true) {
							System.out.println("Options: ");
							System.out.println("-----------------------------");
							System.out.println("1. Sort by title");
							System.out.println("2. Sort by cost");
							System.out.println("0. Back");
							System.out.println("-----------------------------");
							int sortChoice = s.nextInt();
							if (sortChoice == 1) {
								cart.getItemsOrdered().sort(Media.COMPARE_BY_TITLE_COST);
								cart.getItemsOrdered().toString();
							} else if (sortChoice == 2) {
								cart.getItemsOrdered().sort(Media.COMPARE_BY_COST_TITLE);
								cart.getItemsOrdered().toString();
							} else if (sortChoice == 0) {
								break;
							}
						}
					} else if (cartMenuChoice == 3) {
						s.nextLine();
						System.out.println("Title you want to remove from cart: ");
						String title = s.nextLine();
						for (Media item : cart.getItemsOrdered()) {
							if (item.getTitle().equals(title)){
								cart.removeMedia(item);
								break;
							}
						}
					} else if (cartMenuChoice == 4) {
						s.nextLine();
						System.out.println("What's title of media: ");
						String title = s.nextLine();
						int flag = 0;
						for (Media item : cart.getItemsOrdered()) {
							if (item.getTitle().compareTo(title) == 0) {
								if (item instanceof DigitalVideoDisc) {
									DigitalVideoDisc dvd = (DigitalVideoDisc) item;
								    try {
										dvd.play();
									} catch (PlayerException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else if (item instanceof CompactDisc) {
									CompactDisc cd = (CompactDisc) item;
									try {
										cd.play();
									} catch (PlayerException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else {
									System.out.println("Can't play with this type of media.");
								}
							}
							flag = 1;
							break;
						}
						if (flag == 0) System.out.println("Not media with this title in store.");
					} else if (cartMenuChoice == 5) {
						cart.getItemsOrdered().clear();
						System.out.println("Order is created.");
					} else if (cartMenuChoice == 0) {
						break;
					}
				}
			} else if (showMenuChoice == 0) {
				break;
			}
		}
	}
}
