import Sax2.Cliente;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Ex09_Sheng_Ye
 * Created by: sheng
 * Date : 20/10/2021
 * Description:
 **/
public class Ex09_Sheng_Ye {

    /** Primero hacemos un metodo arraylist en donde lee los clientes*/
    public ArrayList<Clientee> clienteeArrayList() {
        ArrayList<Clientee> list = new ArrayList<>();

        try {
            /** Luego pasamos por file el archivo de cliente.dat*/
            File file = new File("src/clientes/clientes.dat");
            /** Para coger el objeto*/
            ObjectInputStream f = new ObjectInputStream(new FileInputStream(file));
            /** Y un while para que lea la lista que cuando solo sea 5 te pase la lista*/
            while (true) {
                if (list.size() == 5) {
                    return list;
                }
                /** Y esto lo añade en la lista*/
                list.add((Clientee) f.readObject());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /** Y ahora hacemos el metodo para crear el fichero en donde guardaremos el archivo que es por objeto en
     * .dat y le añadimos los clientes */
    public void crearFichero() {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("src/clientes/clientes.dat"));

            Clientee uno = new Clientee("dani" , 19);
            Clientee dos = new Clientee("sheng" , 25);
            Clientee tres = new Clientee("jose" , 35);
            Clientee cuatro = new Clientee("juanjo" , 87);
            Clientee cinco = new Clientee("pampo" , 97);

            /** Lo escribimos en el fichero */

            file.writeObject(uno);
            file.writeObject(dos);
            file.writeObject(tres);
            file.writeObject(cuatro);
            file.writeObject(cinco);

            /** Cerramos el fichero */
            file.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /** Crearemos el xml que paso por el array del cliente */
    public void crearXml (ArrayList<Clientee> list) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        //Elemento raíz
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("clientes");
        doc.appendChild(rootElement);


        /** Y hacemos el for en donde coja la lista de cliente en que habiamos creado antes y lo añadimos en elemento
         * y tambien en nodo para que guarde en el xml tanto el nombre y la edad */
        for (Clientee value : list) {

            Element clientee  = doc.createElement("cliente");
            rootElement.appendChild(clientee);

            Node nombre = doc.createElement("nombre");
            Node tx = doc.createTextNode(value.getNombre());
            nombre.appendChild(tx);
            Node edad = doc.createElement("edad");
            Node ed = doc.createTextNode(String.valueOf(value.getEdad()));
            edad.appendChild(ed);

            clientee.appendChild(nombre);
            clientee.appendChild(edad);

        }

        /** Metodo para guardar el archivo , llamando en el doc */
        GuardarArchivo(doc , "src/xml/Ex09_Sheng_Ye.xml");

        /** Metodo para printear el archivo de xml */
        MostrarArbre();

    }


    /** Metodo para mostrar o printear el archivo de xml */
    public static void MostrarArbre() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        //Elemento raíz
        /** Elegimos que xml leer o guardar */
        Document doc = docBuilder.parse(new File("src/xml/Ex09_Sheng_Ye.xml"));

        /** Pasamos el primer nodo cliente */
        NodeList nodes = doc.getElementsByTagName("cliente");
        /** Y un for en que muestre los clientes */
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;
            System.out.println("Nombre " + element.getElementsByTagName("nombre").item(0).getTextContent());
            System.out.println("Edad: " + element.getElementsByTagName("edad").item(0).getTextContent());
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println("\n");

        }
        System.out.println("--------------------------------- Fi de mostrar arbre -------------------------------\n");

    }


    /** Metodo para guardar el archivo al que le pasamos por el parametro y el lugar en donde que queremos guardar */

    public static void GuardarArchivo(Document doc, String documento) throws TransformerException {
        TransformerFactory tfe = TransformerFactory.newInstance();
        Transformer transf = tfe.newTransformer();
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult file = new StreamResult(new File(documento));
        transf.transform(source, file);
    }


    /** Metodo main */
    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
        Ex09_Sheng_Ye ex = new Ex09_Sheng_Ye();
        /** creamos el fichero */
        ex.crearFichero();
        /** pasamos el arraylist de los clientes */
        ex.clienteeArrayList();
        /** Creamos el xml con el cliente de arraylist */
        ex.crearXml(ex.clienteeArrayList());
    }



}
