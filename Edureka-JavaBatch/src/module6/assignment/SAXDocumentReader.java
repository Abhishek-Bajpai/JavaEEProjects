package module6.assignment;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

/**
 * @author Abhishek Bajpai Date May 15 2021
 *
 */
public class SAXDocumentReader extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Document begins here");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<" + qName + ">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch, start, length));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</" + qName + ">");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Document ends here");
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, FileNotFoundException, IOException {
	    SAXParser saxParserp=SAXParserFactory.newInstance().newSAXParser();
	    saxParserp.parse(new FileInputStream("C:\\Users\\abbac\\eclipse-workspace\\Edureka-JavaBatch\\src\\module6\\assignment\\student.xml"),new SAXDocumentReader());
	}

}
