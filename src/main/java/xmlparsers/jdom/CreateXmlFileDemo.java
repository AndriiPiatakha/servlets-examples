package xmlparsers.jdom;

import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class CreateXmlFileDemo {

   public static void main(String[] args) {

      try{
         //root element
         Element carsElement = new Element("cars");
         Document doc = new Document(carsElement);

         //supercars element
         Element supercarElement = new Element("supercars");
         supercarElement.setAttribute(new Attribute("company","Ferrari"));

         //supercars element
         Element carElement1 = new Element("carname");
         carElement1.setAttribute(new Attribute("type","formula one"));
         carElement1.setText("Ferrari 101");

         Element carElement2 = new Element("carname");
         carElement2.setAttribute(new Attribute("type","sports"));
         carElement2.setText("Ferrari 202");

         supercarElement.addContent(carElement1);
         supercarElement.addContent(carElement2);

         doc.getRootElement().addContent(supercarElement);

         XMLOutputter xmlOutput = new XMLOutputter();

         // display ml
         xmlOutput.setFormat(Format.getPrettyFormat());
         xmlOutput.output(doc, System.out); 
      } catch(IOException e) {
         e.printStackTrace();
      }
   }
}
