//package xmlparsers.xpath;
//
//import java.io.File;
//import java.io.IOException;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.xpath.XPath;
//import javax.xml.xpath.XPathConstants;
//import javax.xml.xpath.XPathExpressionException;
//import javax.xml.xpath.XPathFactory;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.NodeList;
//import org.w3c.dom.Node;
//import org.w3c.dom.Element;
//import org.xml.sax.SAXException;
//
//public class XPathParserDemo {
//   
//   public static void main(String[] args) {
//      
//      try {
//         File inputFile = new File("input.txt");
//         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//         DocumentBuilder dBuilder;
//
//         dBuilder = dbFactory.newDocumentBuilder();
//
//         Document doc = dBuilder.parse(XPathParserDemo.class.getClassLoader().getResourceAsStream("xml/toParse/demo.xml"));
//         doc.getDocumentElement().normalize();
//
//         XPath xPath =  XPathFactory.newInstance().newXPath();
//
//         String expression = "/class/student";	        
//         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
//            doc, XPathConstants.NODESET);
//
//         for (int i = 0; i < nodeList.getLength(); i++) {
//            Node nNode = nodeList.item(i);
//            System.out.println("\nCurrent Element :" + nNode.getNodeName());
//            
//            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//               Element eElement = (Element) nNode;
//               System.out.println("Student roll no :" + eElement.getAttribute("rollno"));
//               System.out.println("First Name : " 
//                  + eElement
//                  .getElementsByTagName("firstname")
//                  .item(0)
//                  .getTextContent());
//               System.out.println("Last Name : " 
//                  + eElement
//                  .getElementsByTagName("lastname")
//                  .item(0)
//                  .getTextContent());
//               System.out.println("Nick Name : " 
//                  + eElement
//                  .getElementsByTagName("nickname")
//                  .item(0)
//                  .getTextContent());
//               System.out.println("Marks : " 
//                  + eElement
//                  .getElementsByTagName("marks")
//                  .item(0)
//                  .getTextContent());
//            }
//         }
//      } catch (ParserConfigurationException e) {
//         e.printStackTrace();
//      } catch (SAXException e) {
//         e.printStackTrace();
//      } catch (IOException e) {
//         e.printStackTrace();
//      } catch (XPathExpressionException e) {
//         e.printStackTrace();
//      }
//   }
//}
