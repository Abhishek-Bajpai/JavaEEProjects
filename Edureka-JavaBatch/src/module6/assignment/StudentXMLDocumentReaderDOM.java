/**
 * 
 */
package module6.assignment;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.jndi.cosnaming.IiopUrl.Address;

/**
 * @author Abhishek Bajpai Date May 15 2021
 */
public class StudentXMLDocumentReaderDOM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File xmlFileToRead = new File("C:\\Users\\abbac\\eclipse-workspace\\Edureka-JavaBatch\\src\\module6\\assignment\\student.xml");
		readXMLFileUsingDOM(xmlFileToRead);
	}


	/**
		<students>
			<student>
				<id>1</id>
				<name>Everest</name>
				<Standard>2</Standard>
				<gender>male</gender>
				<marks>95</marks>
				<address>
					<StreetName>Touchstone Ter</StreetName>
					<HouseNumber>4735</HouseNumber>
					<City>Fremont</City>
					<ZipCode>94555</ZipCode>
				</address>
			</student>	
		</students>
	 */
	private static void readXMLFileUsingDOM(File xmlFileToRead) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFileToRead);

			System.out.println("Root element :" + document.getDocumentElement().getNodeName());
			NodeList empNodeList = document.getElementsByTagName("student");
			System.out.println("Total no of students found :- " + empNodeList.getLength());

			for (int empNodeCounter = 0; empNodeCounter < empNodeList.getLength(); empNodeCounter++) {
				Node empNode = empNodeList.item(empNodeCounter);
				if (empNode.getNodeType() == Node.ELEMENT_NODE) {
					Element empNodeElement = (Element) empNode;
					System.out.println(
							"\nID : " + empNodeElement.getElementsByTagName("id").item(0).getTextContent());
					System.out
							.println("First Name : " + empNodeElement.getElementsByTagName("name").item(0).getTextContent());
					System.out.println(
							"Standard : " + empNodeElement.getElementsByTagName("Standard").item(0).getTextContent());
					System.out.println(
							"Gender : " + empNodeElement.getElementsByTagName("gender").item(0).getTextContent());
					System.out.println(
							"Marks : " + empNodeElement.getElementsByTagName("marks").item(0).getTextContent());
					
					//Addrerss
					System.out.println("Address : " + empNodeElement.getElementsByTagName("HouseNumber").item(0).getTextContent() +" " 
					+ empNodeElement.getElementsByTagName("StreetName").item(0).getTextContent() + "\n\t  " + empNodeElement.getElementsByTagName("City").item(0).getTextContent() + " " + empNodeElement.getElementsByTagName("ZipCode").item(0).getTextContent());
					
					
					Thread.sleep(100);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
