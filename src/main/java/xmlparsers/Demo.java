package xmlparsers;

public class Demo {
	

//
//    Dom Parser − Parses an XML document by loading the complete contents of the document and creating its complete hierarchical tree in memory.
//
//    SAX Parser − Parses an XML document on event-based triggers. Does not load the complete document into the memory.
//
//    JDOM Parser − Parses an XML document in a similar fashion to DOM parser but in an easier way.
//
//    StAX Parser − Parses an XML document in a similar fashion to SAX parser but in a more efficient way.
//
//    XPath Parser − Parses an XML document based on expression and is used extensively in conjunction with XSLT.
//
//    DOM4J Parser − A java library to parse XML, XPath, and XSLT using Java Collections Framework. It provides support for DOM, SAX, and JAXP.
//

	
	
//	You should use a DOM parser when −
//
//    You need to know a lot about the structure of a document.
//
//    You need to move parts of an XML document around (you might want to sort certain elements, for example).
//
//    You need to use the information in an XML document more than once.

	
//	The DOM defines several Java interfaces. Here are the most common interfaces −
//
//    Node − The base datatype of the DOM.
//
//    Element − The vast majority of the objects you'll deal with are Elements.
//
//    Attr − Represents an attribute of an element.
//
//    Text − The actual content of an Element or Attr.
//
//    Document − Represents the entire XML document. A Document object is often referred to as a DOM tree.

	
	
//	When you are working with DOM, there are several methods you'll use often −
//
//    Document.getDocumentElement() − Returns the root element of the document.
//
//    Node.getFirstChild() − Returns the first child of a given Node.
//
//    Node.getLastChild() − Returns the last child of a given Node.
//
//    Node.getNextSibling() − These methods return the next sibling of a given Node.
//
//    Node.getPreviousSibling() − These methods return the previous sibling of a given Node.
//
//    Node.getAttribute(attrName) − For a given Node, it returns the attribute with the requested name.

	
	
	
	
}
