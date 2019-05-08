import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
 
import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.File;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
public class CreateXmlFile {
 
    public static void main(String[] args) {
        System.out.println("Starting Creating XML file operation.");
 
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();
            Element phoneBookRootElement = document.createElement("PhoneBook");
            document.appendChild(phoneBookRootElement);
 
            Element memberElement = document.createElement("Member");
            phoneBookRootElement.appendChild(memberElement);
            memberElement.setAttribute("id", "01");
 
            Element firstnameElement = document.createElement("Firstname");
            Text firstnameText = document.createTextNode("Süleyman");
            
            memberElement.appendChild(firstnameElement);
            firstnameElement.appendChild(firstnameText);
 
            Element middlenameElement = document.createElement("Middlename");
            Text middlenameText = document.createTextNode("Oğuzhan");
            middlenameElement.appendChild(middlenameText);
            memberElement.appendChild(middlenameElement);
 
            Element lastnameElement = document.createElement("Lastname");
            lastnameElement.appendChild(document.createTextNode("KINIK"));
            memberElement.appendChild(lastnameElement);
 
            Element phoneNumberElement = document.createElement("PhoneNumber");
            phoneNumberElement.appendChild(document.createTextNode("0123456789"));
            memberElement.appendChild(phoneNumberElement);
 
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("C:\\Users\\Hasan\\Documents\\a\\b.xml"));
 
            transformer.transform(domSource, streamResult);
 
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
 
        System.out.println("Successfully finished Creating XML file operation.");
    }
}