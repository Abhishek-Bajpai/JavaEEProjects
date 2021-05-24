package module1.assignment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class TestFailures {

	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, FileNotFoundException, TransformerException {

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.newDocument();
		Element rootele = doc.createElement("students");
		Element studentele = doc.createElement("student");
		Element nameele = doc.createElement("name");
		Text t1 = doc.createTextNode("Charan");

		nameele.appendChild(t1);
		studentele.appendChild(nameele);

		rootele.appendChild(studentele);
		doc.appendChild(rootele);
		Transformer t = TransformerFactory.newInstance().newTransformer();
		t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("C:\\Users\\abbac\\eclipse-workspace\\Edureka-JavaBatch\\src\\module6\\assignment\\student.xml")));
		System.out.println("XML file generated..");

	}
}