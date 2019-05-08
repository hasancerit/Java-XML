

package xmlgiris;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.lang.Exception;

public class XMLgiris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            
        File file = new File("xdeneme.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        
        Element e = doc.getDocumentElement();//Root Elementi 
        
        System.out.println("Root Element:"+e.getNodeName());
        NodeList nList = doc.getElementsByTagName("question");//nList İçinde Question parentları tutuluyor
        System.out.println("-----------------------------------------------------");
     
        for(int i = 0 ; i<nList.getLength() ; i++){
            Node nNode = nList.item(i);
            
            System.out.println("Soru:"+nNode.getNodeName());//Node Adını Yaz(quesion)

            if(nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;
                System.out.println("Question İD="+eElement.getAttribute("number"));
                System.out.println("Soru:" + eElement
                  .getElementsByTagName("text")
                  .item(0)
                  .getTextContent());
                System.out.println(eElement.getElementsByTagName("sika").item(0).getNodeName()+eElement
                        .getElementsByTagName("sika")
                        .item(0)
                        .getTextContent());
                System.out.println("B:"+eElement
                        .getElementsByTagName("sikb")
                        .item(0)
                        .getTextContent());
                System.out.println("C:"+eElement
                        .getElementsByTagName("sikc")
                        .item(0)
                        .getTextContent());
                System.out.println("D:"+eElement
                        .getElementsByTagName("sikd")
                        .item(0)
                        .getTextContent());
            }
        }
        } catch (Exception e) {
            System.out.println("xmlgiris.XMLgiris.main()");
        }
        
    }
    
}
