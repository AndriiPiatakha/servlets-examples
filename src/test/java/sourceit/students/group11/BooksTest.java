package sourceit.students.group11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BooksTest {
	String[] authorDanAbnett = { "Dan Abnett" };
	String[] authorHelgeKautz = { "Helge Kautz" };
	OOP first = new OOP(9781844164981L, "Horus Rising", authorDanAbnett, "Black Library", 2006, 320, 7.97f,
			"hardcover");
	OOP second = new OOP(9781844167760L, "Prospero Burns", authorDanAbnett, "Black Library", 2011, 416, 11.58f,
			"softcover");
	OOP third = new OOP(9785998507564L, "Yoshiko - Abyss of the Stars", authorHelgeKautz, "EGOSOFT GmbH", 2006, 284,
			6.59f, "softcover");
	OOP forth = new OOP(9783833210419L, "Nopileos", authorHelgeKautz, "EGOSOFT GmbH", 2004, 387, 4.99f, "softcover");
	private OOP[] books = { first, second, third, forth };
	private OOP[] expectedBooks = { third, forth };

	@Test
	public void testToCompareTheResult() {
		Assert.assertEquals(booksByAuthor("Helge Kautz", expectedBooks), booksByAuthor("Helge Kautz", books));
	}

	@Test
	public void testToCompareTheResult2() {
		Assert.assertNotEquals(booksByPublisher("EGOSOFT GmbH", expectedBooks),
				booksByPublisher("Black Library", books));
		Assert.assertEquals(booksByPublisher("EGOSOFT GmbH", expectedBooks), booksByPublisher("EGOSOFT GmbH", books));
	}

	public static List<OOP> booksByAuthor(String author, OOP[] books) {
		List<OOP> result = new ArrayList<>();
		for (OOP book : books) {
			for (String authorBook : book.getAuthor()) {
				if (author.equals(authorBook)) {
					result.add(book);
				}
			}
		}

		return result;
	}

	public static List<OOP> booksByPublisher(String publishing, OOP[] books) {
		System.out.println("===================");
		List<OOP> result = new ArrayList<>();
		for (OOP book : books) {
			if (publishing.equals(book.getPublisher())) {
				result.add(book);
			}
		}

		return result;
	}
	
	@Test
	public void test() {
		booksByPublisher("asd", expectedBooks);
	}

}
