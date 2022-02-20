package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * SAX
 * Nombre_project: AccesBase
 * Handler
 * Created by: sheng
 * Date : 27/10/2021
 * Description:
 **/
public class Handler extends DefaultHandler {
    private boolean nomber;
    private boolean precio;
    private boolean descripcion;
    private boolean calorias;

    private Food comida = new Food();
    //Añadimos en un array el desayuno
    private final List<Food> desayuno = new ArrayList<>();

    //Recogemos el inicio de los elementos
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals(Desayuno.NAME.getName())) {
            nomber = true;
        }
        if (qName.equals(Desayuno.PRICE.getName())) {
            precio = true;
        }
        if (qName.equals(Desayuno.DESCRIPTION.getName())) {
            descripcion = true;
        }
        if (qName.equals(Desayuno.CALORIES.getName())) {
            calorias = true;
        }
    }

    //Llamaremos donde se encuentra los caracteres de la informacion dentro de un elemento
    @Override
    public void characters(char[] ch, int start, int length) {
        if (nomber) {
            comida.setNombre(new String(ch, start, length));
            nomber = false;
        }
        if (precio) {
            comida.setPrecio(Double.parseDouble(new String(ch, start, length)));
            precio = false;
        }
        if (descripcion) {
            comida.setDescripcion(new String(ch, start, length));
            descripcion = false;
        }
        if (calorias) {
            comida.setCalorias(Integer.parseInt(new String(ch, start, length)));
            calorias = false;
        }
    }

    //Este llama el final del elemento al que es cogido del xml
    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals(Desayuno.FOOD.getName())) {
            desayuno.add(comida);
            comida = new Food();
        }
    }

    public List<Food> getDesayuno() {
        return desayuno;
    }
}
