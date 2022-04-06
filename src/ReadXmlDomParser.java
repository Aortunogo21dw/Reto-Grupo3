import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ReadXmlDomParser {

  private static final String FILENAME = "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/filecamion2.xml";

  public static void main(String[] args) {

      // Instantiate the Factory
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {

          // optional, but recommended
          // process XML securely, avoid attacks like XML External Entities (XXE)
          dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

          // parse XML file
          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(new File(FILENAME));

          // optional, but recommended
          // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
          doc.getDocumentElement().normalize();

          System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
          System.out.println("------");

          // get <staff>
          NodeList list = doc.getElementsByTagName("coche");

          for (int temp = 0; temp < list.getLength(); temp++) {

              Node node = list.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {

                  Element element = (Element) node;

                 
                  
                  String NumBastidor = element.getElementsByTagName("numBastidor").item(0).getTextContent();
                  String capacidadMaletero = element.getElementsByTagName("capacidadMaletero").item(0).getTextContent();
                  String numPuertas = element.getElementsByTagName("numPuertas").item(0).getTextContent();
                  String matricula = element.getElementsByTagName("matricula").item(0).getTextContent();
                  String color = element.getElementsByTagName("color").item(0).getTextContent();
                  String numAsientos = element.getElementsByTagName("numAsientos").item(0).getTextContent();
                  String precio = element.getElementsByTagName("precio").item(0).getTextContent();

                  

                  
                  System.out.println("NumBastidor : " + NumBastidor);
                  System.out.println("Matricula : " + matricula);
                  System.out.println("NumPuertas : " + numPuertas);
                  System.out.println("Color : " + color);
                  System.out.println("Precio : " + precio);
                  System.out.println("Capacidad Maletero : " + capacidadMaletero);
                  System.out.println("NumAsientos : " + numAsientos);
                  System.out.println();
                 

              }
          }

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }

  }


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


