package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	public Book(int id, String title) {
		super(id, title);
	}
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	private List<String> authors = new ArrayList<String>();
	
	public boolean containAuthor(String au) {
		return authors.contains(au);
	}
	public void addAuthor(String au) {
		if (containAuthor(au)) {
			System.out.println("Add failed! The author already in Author list of this book.");
			return ;
		} else {
			authors.add(au);
			System.out.println("Add author successfully.");
		}
	}
	public void removeAuthor(String au) {
		if (containAuthor(au)) {
			authors.remove(au);
			System.out.println("Remove author successfully.");
		} else {
			System.out.println("Remove failed. The author not in the Author list of this book.");
		}
	}
	public String getAuthor() {
		String s = "";
		for (String author : authors) {
			s += author + ", ";
		}
		return s;
	}
	@Override
	public String toString() {
		return "Book - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + "[" + this.getAuthor() + "]" + " - " + this.getCost() + "$" ;
	}
}
