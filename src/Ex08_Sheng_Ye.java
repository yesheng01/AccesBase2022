import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Ex08_Sheng_Ye
 * Created by: sheng
 * Date : 13/10/2021
 * Description:Es demana una programa que faci el següent.
 *
 * Carregui un xml videjocs.xml
 * Crea un mètode per afegir al XML fills videojoc amb els nodes títol, creador, sinopsis, plataforma i l’atribut creat_en.
 * Crea un mètode per mostrar el contingut del arbre actual.
 * Crea un mètode que rebi per paràmetre el títol d’un videojoc i modifiqui el títol al nou títol també introduït per paràmetre.
 * Crea un mètode que rebi per paràmetre el títol d’un videojoc i l’elimini.
 * Finalment crea el mètode que escrigui l'arbre en un nou XML anomentar modificat.xml.
 *
 * El programa principal haurà de fer:
 *
 * Crear un arbre amb 5 nodes videojoc.
 * Modificar 2 videojocs.
 * Eliminar 1 videojoc.
 * Crear un nou xml amb les modificacions.
 **/
public class Ex08_Sheng_Ye {

    //Creamos los elementos para luego ser llamado en el metodo principal
    public Document CrearElemento(Document document, String crea_en, String titulo, String creador, String sinopsis, String plataforma) {
        //Creamos los elementos de los campos que queremos
        Element nodevideojuego = document.createElement("videojuego");
        nodevideojuego.setAttribute("crea_en", crea_en);


        Node nodetitulo = document.createElement("titulo");
        Node nodetitulotext = document.createTextNode(titulo);
        nodetitulo.appendChild(nodetitulotext);

        Node nodecreador = document.createElement("creador");
        Node nodecreadortext = document.createTextNode(creador);
        nodecreador.appendChild(nodecreadortext);

        Node nodesinopsis = document.createElement("sinopsis");
        Node nodesinoptext = document.createTextNode(sinopsis);
        nodesinopsis.appendChild(nodesinoptext);

        Node nodeplataforma = document.createElement("plataforma");
        Node nodeplattext = document.createTextNode(plataforma);
        nodeplataforma.appendChild(nodeplattext);

        //Y lo guardaremos
        nodevideojuego.appendChild(nodetitulo);
        nodevideojuego.appendChild(nodecreador);
        nodevideojuego.appendChild(nodesinopsis);
        nodevideojuego.appendChild(nodeplataforma);

        //Y hacemos que se coja del ultimo lista
        document.getLastChild().appendChild(nodevideojuego);

        return document;
    }


    //Metodo para guardar el xml en otro archivo con el tipo de formato y la ruta en que queremos y transformalo
    //En xml

    public void save(Document doc , String stream) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File(stream));
        transformer.transform(domSource, streamResult);

    }

    //Metodo para mostrar el contenido del xml por pantalla
    public void printPantalla(Document doc) {
        //Creamos la lista de los elementos
        NodeList nList = doc.getElementsByTagName("videojuego");
        //Por lo que podemos enseñar el numero de la lista de los elementos que hemos hecho
        System.out.println("Número de videojuegos: " + nList.getLength());

        //Y aqui hacer que se printee las veces que tenemos de la lista en el xml
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                System.out.println("\nFecha de salida: " + eElement.getAttribute("crea_en"));
                System.out.println("Titulo: "
                        + eElement.getElementsByTagName("titulo").item(0).getTextContent());
                System.out.println("Creador: "
                        + eElement.getElementsByTagName("creador").item(0).getTextContent());
                System.out.println("Sinopsis: "
                        + eElement.getElementsByTagName("sinopsis").item(0).getTextContent());
                System.out.println("Plataforma: "
                        + eElement.getElementsByTagName("plataforma").item(0).getTextContent());
            }
        }

        System.out.println("\n===================== Fin =========================");

    }

    //Metodo para cambiar el titulo de un campo del xml , a donde le llamaremos por el titulo antiguo y añadir por un titulo
    //nuevo y hacemos el cambio
    public Document cambiar(Document doc, String tituloOld,String titulonuevo){

        NodeList items = doc.getElementsByTagName("titulo");
        for (int ix = 0; ix < items.getLength(); ix++) {
            Element element = (Element) items.item(ix);
            // Elegir el elemento que queremos con su contenido y si es igual entonces cambiamos el titulo por otro
            if (element.getTextContent().equals(tituloOld)) {
                //Cambiamos el titulo
                element.setTextContent(titulonuevo);
            }
        }
        return doc;

    }

    //Metodo para eliminar un nodo (un campo) del xml en donde le llamamos por el titulo que tiene en ese campo
    public Document eliminar(Document doc, String tituloOld){

        //Al que le pasamos una lista en nodos
        NodeList items = doc.getElementsByTagName("titulo");
        for (int ix = 0; ix < items.getLength(); ix++) {
            Element element = (Element) items.item(ix);
            // elegir un elemento especifico por algun atributo
            if (element.getTextContent().equals(tituloOld)) {
                // borramos el elemento
                element.getParentNode().getParentNode().removeChild(element.getParentNode());
            }
        }
        //Y que nos devuelva otra vez el xml
        return doc;

    }


    //Metodo main
    public static void main(String[] args) {
        //Llamamos por nuestro parametro
        Ex08_Sheng_Ye n = new Ex08_Sheng_Ye();
        try {
            //Miramos en que archivo añadir
            File xml = new File("src/xml/xml-videojuego.xml");

            //Apartir de este documento la queremos crear
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(xml);

            //Las listas de los elementos al que creamos , en donde le pasamos por el metodo y los campos a rellenar
            Document primero = n.CrearElemento(document, "08/08/2021", "Overwatch", "Adam lovines", "Juego multijugador de disparos", "PC");
            Document segundo = n.CrearElemento(primero, "20/12/2018", "Outlast", "Javier noseque", "Juego de Terror", "PC/PS4");
            Document tercero = n.CrearElemento(segundo, "21/06/2020", "Detroit", "Detroit neowhgman", "Juego de interracion", "PC/PS4/Xbox");
            Document cuarto = n.CrearElemento(tercero, "05/09/2021", "Pokemon arceus legends", "Nintendo", "Juego de interactuar y lucha", "Nintendo Switch");
            Document quinto = n.CrearElemento(cuarto, "18,10/2018", "Until Dawn", "Dawana Noales", "Juego de terror", "PC");

            //Enseñamos toda la lista
            n.printPantalla(quinto);
            n.save(quinto , "src/xml/xml-videojuego.xml");

            //Hacemos el cambio de titulo y lo printeamos
            Document cambio = n.cambiar(quinto,"Outlast","OutNo");
            Document cambio2 = n.cambiar(cambio, "Pokemon arceus legends", "Pokemon espada");
            n.printPantalla(cambio);
            n.printPantalla(cambio2);

            //Eliminamos por el metodo el titulo con el metodo de eliminar
            Document acabado=n.eliminar(cambio2,"Overwatch");
            n.printPantalla(acabado);

            //Metodo para guardalo dentro del archivo al que hemos especificado
            n.save(acabado , "src/xml/Nuevo-videojuego.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

