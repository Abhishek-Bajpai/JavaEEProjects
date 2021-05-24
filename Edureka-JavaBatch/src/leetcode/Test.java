package leetcode;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Test 
{    
public static void main(String args[])throws Exception    
{        
DocumentBuilderFactory f=DocumentBuilderFactory.newInstance();        
DocumentBuilder b=f.newDocumentBuilder();
        Document doc=b.newDocument();
                Element rootele=doc.createElement("students");        
Element studentele=doc.createElement("student");        
Element nameele=doc.createElement("name");                 
Text t1=doc.createTextNode("Charan");
                 
nameele.appendChild(t1);
          studentele.appendChild(nameele);
        
rootele.appendChild(studentele);
       doc.appendChild(rootele);
       Transformer t=TransformerFactory.newInstance().newTransformer();
       t.transform(new DOMSource(doc),new StreamResult(new FileOutputStream("C:\\Users\\abbac\\eclipse-workspace\\Edureka-JavaBatch\\src\\leetcode\\students.xml")));
       System.out.println("XML file generated..");    
}
}