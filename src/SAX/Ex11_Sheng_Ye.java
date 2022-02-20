package SAX;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * xml
 * Nombre_project: AccesBase
 * Ex11_Sheng_Ye
 * Created by: sheng
 * Date : 27/10/2021
 * Description:
 **/
public class Ex11_Sheng_Ye {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //Crearemos la instancia del parser donde invoca un handler
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        //Iniciamos el handler
        Handler handler = new Handler();
        //Parser donde parsea la ruta del xml y el handler para leer
        saxParser.parse("src/xml/Food-XML.xml", handler);
        //Listeamos el array del desayuno
        List<Food> list = handler.getDesayuno();
        //Donde hacemos el for en donde le cogemos el nombre , descripcion , precio y de las calorias
        for (Food food : list) {
            System.out.println("Name: " + food.getNombre());
            System.out.println("Description: " + food.getDescripcion());
            System.out.println("Price: " + food.getPrecio());
            System.out.println("Calories: " + food.getCalorias());
            System.out.println("---------------------------------------------------------------------------------------------");
        }
    }
}
