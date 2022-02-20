package Sax2;

import SAX.Desayuno;
import SAX.Food;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Sax2
 * Nombre_project: AccesBase
 * Handler1
 * Created by: sheng
 * Date : 03/11/2021
 * Description:
 **/
public class Handler1 extends DefaultHandler {
    private boolean nombre;
    private boolean edad;

    private Cliente cliente = new Cliente();
    //Añadimos en un array el desayuno
    private final List<Cliente> clientes = new ArrayList<>();

    //Recogemos el inicio de los elementos
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals(Clientes.CLIENTES.getName())) {
            nombre = true;
        }
        if (qName.equals(Clientes.EDAD.getName())) {
            edad = true;
        }
    }

    //Llamaremos donde se encuentra los caracteres de la informacion dentro de un elemento
    @Override
    public void characters(char[] ch, int start, int length) {
        if (nombre) {
            cliente.setNombre(new String(ch, start, length));
            nombre = false;
        }
        if (edad) {
            cliente.setEdad(Integer.parseInt(new String(ch, start, length)));
            edad = false;
        }
    }

    //Este llama el final del elemento al que es cogido del xml
    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals(Clientes.CLIENTES.getName())) {
            clientes.add(cliente);
            cliente = new Cliente();
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
