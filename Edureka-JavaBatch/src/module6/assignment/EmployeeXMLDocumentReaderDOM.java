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

/**
 * @author Abhishek Bajpai Date May 15 2021
 */
public class EmployeeXMLDocumentReaderDOM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File xmlFileToRead = new File("C:\\Users\\abbac\\eclipse-workspace\\Edureka-JavaBatch\\src\\module6\\assignment\\employeeCreatedUsingDOM.xml");
		readXMLFileUsingDOM(xmlFileToRead);
	}


	/**
	  	<Employees>
			<Employee>
				<ID>1001</ID>
				<Name>Abhishek Bajpai</Name>
				<Department>CEO</Department>
			</Employee>
		</Employees>	
	 */
	private static void readXMLFileUsingDOM(File xmlFileToRead) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFileToRead);

			System.out.println("Root element :" + document.getDocumentElement().getNodeName());
			NodeList empNodeList = document.getElementsByTagName("Employee");
			System.out.println("Total no of employees found :- " + empNodeList.getLength());

			for (int empNodeCounter = 0; empNodeCounter < empNodeList.getLength(); empNodeCounter++) {
				Node empNode = empNodeList.item(empNodeCounter);
				if (empNode.getNodeType() == Node.ELEMENT_NODE) {
					Element empNodeElement = (Element) empNode;
					System.out.println(
							"\n\nEmploee ID : " + empNodeElement.getElementsByTagName("ID").item(0).getTextContent());
					System.out
							.println("First Name : " + empNodeElement.getElementsByTagName("Name").item(0).getTextContent());
					System.out.println(
							"Department : " + empNodeElement.getElementsByTagName("Department").item(0).getTextContent());
					Thread.sleep(100);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
