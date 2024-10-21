package XML;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class Principal {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("feed-rss.xml"));
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nList = document.getElementsByTagName("channel");
        System.out.println("");
        Node nodo;
        for (int i = 0; i < nList.getLength(); i++) {
            nodo = nList.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                System.out.println("El titulo del programa es: " + elemento.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("El copyright es: " + elemento.getElementsByTagName("copyright").item(0).getTextContent());
                System.out.println("");
                NodeList nList2 = document.getElementsByTagName("item");
                Node nodo2;
                for (int i2 = 0; i2 < nList2.getLength(); i2++) {
                    nodo2 = nList2.item(i2);
                    if (nodo2.getNodeType() == Node.ELEMENT_NODE) {
                        Element elemento2 = (Element) nodo2;
                        System.out.println("El titulo de la noticia es: " + elemento2.getElementsByTagName("title").item(0).getTextContent());
                        System.out.println("La descripcion de la noticia es: " + elemento2.getElementsByTagName("description").item(0).getTextContent());
                        System.out.println("------------------------------------");
                    }
                }
            }
        }
    }
}
