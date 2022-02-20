package Xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathExpression;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Xpath
 * Nombre_project: AccesBase
 * Ex16_Sheng_ye
 * Created by: sheng
 * Date : 11/11/2021
 * Description:
 **/
public class Ex16_Sheng_ye {

    public static void main(String[] args) {
        Ex16_Sheng_ye ex16_sheng_ye = new Ex16_Sheng_ye();

        Boolean salir = false;

        //Iniciamos el bucle
        while(!salir){
            //Preguntamso si se quiere mostrar el xml
            System.out.println("Mostrar el xml (s/n)?");
            Scanner scanner = new Scanner(System.in);
            String texto = scanner.nextLine();

            //Donde le preguntamso si quiere mostrar , entonces , si quiere mostrar , entonces mostramos el xml
            if (texto.equals("s")){
                System.out.println("El xml: " );
                //cogemos el metodo al que hemos hecho y le pasamos el parametro de la manera para que lea el archivo
                ex16_sheng_ye.Leerxml("//@nombre/..");
            }

            //Preguntamso por el elemento al que le pasaremos
            System.out.println("\t Añade el elemento del cual quieres buscar: ");
            Scanner sc = new Scanner(System.in);
            String elemento = sc.nextLine();

            //Preguntaremos el valor
            System.out.println("Introduce el valor del elemento del cual quieres buscar: ");
            Scanner scanner1 = new Scanner(System.in);
            String valor = scanner1.nextLine();


            //Y los parametros al que son pasados , leeremos el xml con los parametros dadas y de esta manera leera
            //De la manera que queremos
            ex16_sheng_ye.Leerxml(ex16_sheng_ye.passStringXpath(valor , elemento));

            //Pregunta por salir
            System.out.println("Desea salir? (s/n)");
            Scanner scanner2 = new Scanner(System.in);
            String adios = scanner2.nextLine();
            //Si quiere salir el bucle finaliza
            if (adios.equals("s")) {
                salir = true;
            }

        }


    }




    public void Leerxml(String Xpath){
        try{
            //Cogemos el archivo al que queremos leer
            FileInputStream file = new FileInputStream(new File("src/xml/Futbol.xml"));

            //Contruimos el documento
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =  builderFactory.newDocumentBuilder();

            Document xmlDocument = builder.parse(file);

            //Añadimos el xpath de esta manera leera
            XPath xPath =  XPathFactory.newInstance().newXPath();

            //Añadimos una lista de nodos en que le psaremos un for en que lea el archivo de la maneraa al que le pasaremos
            //El parametro
            NodeList nodos = (NodeList) xPath.evaluate(Xpath,xmlDocument, XPathConstants.NODESET);
            //Recorremos el nodelist
            for (int i=0;i<nodos.getLength();i++){
                //Mostramos el resultado
                System.out.println(nodos.item(i).getNodeName()+" : " +
                        nodos.item(i).getAttributes().getNamedItem("nombre"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String passStringXpath(String value, String element) {
        //Creamos el String que sera una expresion de xPath
        return "//"+element+"[@nombre='"+value+"']";
    }

}
