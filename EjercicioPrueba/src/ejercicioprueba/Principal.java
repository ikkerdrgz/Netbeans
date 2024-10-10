/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioprueba;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.SAXException;
/**
 *
 * @author FP
 */
public class Principal {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document document = builder.parse(new File("C:\\Users\\FP\\Documents\\NetBeansProjects\\EjercicioPrueba\\camaras.xml"));
        FileWriter escritura = new FileWriter("C:\\Users\\FP\\Desktop\\nuevo.txt");
        document.getDocumentElement().normalize();
        
        Element root = document.getDocumentElement();
        escritura.write("Lo ULTIMO de las camaras web\n");
        
        NodeList nList = document.getElementsByTagName("camara");
        escritura.write("\n===========================");
        
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElemento = (Element) node;
                escritura.write("\nNombre de la cámara ¡¡ " + eElemento.getElementsByTagName("nombre").item(0).getTextContent() + "\n");
                escritura.write("\nModelo ¡¡ " + eElemento.getElementsByTagName("modelo").item(0).getTextContent() + "\n");
                escritura.write("\nMarca ¡¡ " + eElemento.getElementsByTagName("marca").item(0).getTextContent() + "\n");
                escritura.write("\nDIMENSIONES altura # " + eElemento.getElementsByTagName("altura").item(0).getTextContent() + "\n");
                escritura.write("\nDIMENSIONES anchura @ " + eElemento.getElementsByTagName("anchura").item(0).getTextContent() + "\n");
                escritura.write("\nDIMENSIONES profundidad # " + eElemento.getElementsByTagName("profundidad").item(0).getTextContent() + "\n");
                escritura.write("\nDIMENSIONES peso @ " + eElemento.getElementsByTagName("peso").item(0).getTextContent() + "\n");
                escritura.write("\nRESOLUCION megapixeles # " + eElemento.getElementsByTagName("megapixel").item(0).getTextContent() + "\n");
                escritura.write("\nComentarios: " + eElemento.getElementsByTagName("comentario").item(0).getTextContent() + "\n");
                if (i != nList.getLength()-1) {
                    escritura.write("\n***************************");
                } else if (i == nList.getLength()-1) {
                    escritura.write("\n+++++++++++++++++++++++++++\n");
                    escritura.write("\nFIN DEL DOCUMENTO XML");
                }
            }
        }
        escritura.close();
    }
}
