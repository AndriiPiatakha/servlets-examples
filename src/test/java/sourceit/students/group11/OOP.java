package sourceit.students.group11;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OOP {
	/*
	  5. Book: id, Название, Автор (ы), Издательство, Год издания, Количество стра-
		ниц, Цена, Тип переплета.
		Создать массив объектов. Вывести:
		a) список книг заданного автора;
		b) список книг, выпущенных заданным издательством;
		c) список книг, выпущенных после заданного года.
	 */
	private long id;
	private String title;
	private String[] author;
	private String publishing;	
	private int year;
	private int pages;
	private float price;
	private String cover;
	

	// Book with parameters
	public OOP(long id, String title, String[] author, String publishing,
			int year, int pages, float price, String cover) { 
		super();
		this.id = id; this.title = title; this.author = author; this.publishing = publishing; 
		this.year = year; this.pages = pages; this.price = price; this.cover = cover; 
	}
	public String[] getAuthor () {
		return (String[]) author.clone();
	}	
	public String getPublisher () {
		return publishing;
	}	
	public int getYear() {
		return year;
	}
	static int count = 0;
	
	@Override
	public String toString() {
		count++;
		return "Book " + count + 
				"\n**************************\n" + 
				"id: " + id +
				"\nTitle: " + title +
				"\nAuthor: " + Arrays.toString(author) +
				"\nPublishing: " + publishing +
				"\nYear: " + year +
				"\nPages: " + pages +
				"\nPrice: " + price +
				"\nCover: " + cover + 
				"\n**************************\n";
	}
	
	
	
	public static void main(String[] args) {
		
		String[] authorDanAbnett = {"Dan Abnett"};
		OOP first = new OOP(9781844164981L, "Horus Rising", authorDanAbnett, "Black Library",
				2006, 320, 7.97f, "hardcover" );
		OOP second = new OOP(9781844167760L, "Prospero Burns", authorDanAbnett, "Black Library",
				2011, 416, 11.58f, "softcover" );
		
		String[] authorHelgeKautz = {"Helge Kautz"};
		OOP third = new OOP(9785998507564L, "Yoshiko - Abyss of the Stars", authorHelgeKautz, "EGOSOFT GmbH",
				2006, 284, 6.59f, "softcover" );
		OOP forth = new OOP(9783833210419L, "Nopileos", authorHelgeKautz, "EGOSOFT GmbH",
				2004, 387, 4.99f, "softcover" );
		OOP[] books = {first, second, third, forth};
		
		count = 0;
		System.out.println("Sort by author: \n\n" + booksByAuthor("Dan Abnett", books));
		count = 0;
		System.out.println("Sort by publisher: \n\n" + booksByPublisher("EGOSOFT GmbH", books));
		count = 0;
		System.out.println("Released after the specified year: \n\n" + booksAfterYear(2005, books));
		
	}
	public static List<OOP> booksByAuthor(String author, OOP[] books){
		List<OOP> result = new ArrayList<>();
		for(OOP book: books) {
			for (String authorBook : book.getAuthor()){
				if(author.equals(authorBook)) {
					result.add(book);
				}
			}	
		}
		
		return result;
	}
	public static List<OOP> booksByPublisher(String publishing, OOP[] books){
		List<OOP> result = new ArrayList<>();
		for(OOP book: books) {
			if(publishing.equals(book.getPublisher())) {
				result.add(book);
			}
		}
		
		return result;
	}
	public static List<OOP> booksAfterYear(int year, OOP[] books){
		List<OOP> result = new ArrayList<>();
		for(OOP book: books) {
			if(year <= book.getYear()) {
				result.add(book);
			}
		}
		
		return result;
	}
	

}
