package module6.assignment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * @author Abhishek Bajpai
 * Date May 15 2021
 *
 * Assignment: "XML using DOM" >> Write a XML file containing Employee details in the XML File using DOM. Fields of the XML are: Emp_id , name , Dept 
 *
 */
public class EmployeeXMLDocumentCreatorDOM {

	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("<<<<      Lets begin collecting employee data     >>>\n\n");
		System.out.println("How many employees in your company : ");
		int noOfEmployees = scanner.nextInt();
		
		String[] idString = new String[noOfEmployees];
		String[] nameString = new String[noOfEmployees];
		String[] deptString = new String[noOfEmployees];
		
		for(int i=0; i<noOfEmployees; i++) {
			System.out.println("Pls enter employee ID : ");
			 idString[i]=scanner.next();
			System.out.println("Pls enter employee Name (First Name ONLY): ");
			 nameString[i]=scanner.next();
			System.out.println("Pls enter employee Department : ");
			 deptString[i]=scanner.next();
		} 

		Document document=null;
		try {
			document = buildEmployeeDocument(idString, nameString, deptString, noOfEmployees);
			writeDocumentToXMLFile(document);
		} catch (FileNotFoundException | ParserConfigurationException | TransformerFactoryConfigurationError
				| TransformerException e) {
			e.printStackTrace();
		}
		scanner.close();
	}


	private static Document buildEmployeeDocument(String[] empID, String[] empName, String[] empDepartment, int noOfEmployees) throws ParserConfigurationException, TransformerFactoryConfigurationError, FileNotFoundException, TransformerException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		Element rootElement = document.createElement("Employees");

		for (int i = 0; i < noOfEmployees; i++) {
			Element empDataElement = document.createElement("Employee");
			Element empIdElement = document.createElement("ID");
			Element empNameElement = document.createElement("Name");
			Element empDeptElement = document.createElement("Department");

			Text empIDTextNode = document.createTextNode(empID[i]);
			Text empNameTextNode = document.createTextNode(empName[i]);
			Text empDepartmentTextNode = document.createTextNode(empDepartment[i]);

			empIdElement.appendChild(empIDTextNode);
			empNameElement.appendChild(empNameTextNode);
			empDeptElement.appendChild(empDepartmentTextNode);

			empDataElement.appendChild(empIdElement);
			empDataElement.appendChild(empNameElement);
			empDataElement.appendChild(empDeptElement);
			rootElement.appendChild(empDataElement);
		}
		document.appendChild(rootElement);

		System.out.println("Employee Data Document Ready .. ");

		return document;
	}
	
	private static void writeDocumentToXMLFile(Document document) throws TransformerFactoryConfigurationError, FileNotFoundException, TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream("C:\\Users\\abbac\\eclipse-workspace\\Edureka-JavaBatch\\src\\module6\\assignment\\employeeCreatedUsingDOM.xml")));
		System.out.println("Employee XML file generated..Congratulations...!! ");
		
	}

}
