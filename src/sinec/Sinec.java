
package sinec;


import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import static sinec.Homes.rutaFile;
import static sinec.Homes.serie;




public class Sinec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        
        
        
        Homes v=new Homes();
        
        
        v.setTitle("Escaner SINEC   V 1.01");
        v.setVisible(true); 
        
       
    }

    
            public static void generar(){
 
try {

                      

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                   
               
                

		// elemento raiz

		Document doc = docBuilder.newDocument();
             
                doc.setXmlStandalone(true);
                 
                
                 
		Element lista = doc.createElement("Serial_Number_list");
                
		doc.appendChild(lista);
                
                      for (int i = 0; i < 20; i++) {
                          // serial
		Element serial = doc.createElement("Serial_Number");
		lista.appendChild(serial);
              
		// pcb
		Element PCB = doc.createElement("PCB");
                int a=i+1;
                PCB.appendChild(doc.createTextNode(Integer.toString(a)));
		serial.appendChild(PCB);
                
                //nc
                Element SN =doc.createElement("SN");
                SN.appendChild(doc.createTextNode(serie[i]));
                serial.appendChild(SN);
                      }

		
               
              
		
		// escribimos el contenido en un archivo .xml

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
            
		Transformer transformer = transformerFactory.newTransformer();
                     
               transformer.setOutputProperty(OutputKeys.INDENT, "yes");
               transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
               transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "3");
		DOMSource source = new DOMSource(doc);
                rutaFile=rutaFile+"\\archivo.xml";
                      System.out.println(rutaFile);
		StreamResult result = new StreamResult(new File(rutaFile));

		//StreamResult result = new StreamResult(new File("archivo.xml"));
		transformer.transform(source, result);
		System.out.println("File saved!");

 

		} catch (ParserConfigurationException | TransformerException pce) {
                      System.out.println("mall");
                            
		}
            }
    }
    

