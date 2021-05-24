package leetcode;

import java.io.FileInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class mysaxHandler extends DefaultHandler {
	public void startDocument() {
		System.out.println("Document begins here");
	}

	public void startElement(String uri, String localName, String qName, Attributes attrs) {
		System.out.print("<" + qName + "> ");
	}

	public void characters(char ch[], int start, int len) {
		System.out.print(new String(ch, start, len));
	}

	public void endElement(String uri, String localName, String qName) {
		System.out.println("" + qName + ">");
	}

	public void endDocument() {
		System.out.println("Document ends here");
	}

}