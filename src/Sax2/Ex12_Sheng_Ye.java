package Sax2;

import SAX.Food;
import SAX.Handler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * Sax2
 * Nombre_project: AccesBase
 * Ex12_Sheng_Ye
 * Created by: sheng
 * Date : 03/11/2021
 * Description:
 **/
public class Ex12_Sheng_Ye {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //Crearemos la instancia del parser donde invoca un handler
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        //Iniciamos el handler
        Handler1 handler = new Handler1();
        //Parser donde parsea la ruta del xml y el handler para leer
        saxParser.parse("src/xml/Ex09_Sheng_Ye.xml", handler);
        //Listeamos el array del desayuno
        List<Cliente> list = handler.getClientes();
        //Donde hacemos el for en donde le cogemos el nombre , descripcion , precio y de las calorias
        for (Cliente cliente : list) {
            System.out.println("Name: " + cliente.getNombre());
            System.out.println("Edad: " + cliente.getEdad());
            System.out.println("---------------------------------------------------------------------------------------------");
        }
    }


}
