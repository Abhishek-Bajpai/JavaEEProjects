package leetcode;

import java.io.FileInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class TestCode {
	public static void main(String args[]) throws Exception {
		SAXParser p = SAXParserFactory.newInstance().newSAXParser();
		p.parse(new FileInputStream(
				"C:\\Users\\abbac\\eclipse-workspace\\Edureka-JavaBatch\\src\\leetcode\\students.xml"),new mysaxHandler());
	}
}