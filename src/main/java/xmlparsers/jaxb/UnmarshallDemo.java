package xmlparsers.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshallDemo {
	
	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Bookstore.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Bookstore bookstore = (Bookstore) jaxbUnmarshaller.unmarshal(
				UnmarshallDemo.class.getClassLoader().getResourceAsStream("xml/jaxb/bookstore-jaxb.xml"));
		System.out.println(bookstore);

	}

}
