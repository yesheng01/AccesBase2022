import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class videojocs {

    //Con este metodo crearemos una estructura de datos xml en java con el documento que pasemos por parametro y lo devolveremos para usarlo en los demas metodos.
    public static Document CargarXML(String nombredoc) throws SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(nombredoc));
        return doc;
    }

    //Cream un element videojoc amb els seus fills pasats per parametre.
    public static Document CrearElemento(Document doc, String atribut_lloc, String nomjoc, String nomcreador, String sinopsis, String plataforma) throws SAXException, IOException, ParserConfigurationException {
        //Cream un nou element videojoc amb els parametres que li pasem.
        Node nodevideojoc = doc.createElement("videojoc");
        ((Element) nodevideojoc).setAttribute("creat_en", atribut_lloc); //Con esto le pondremos el attributo de creado_en pasado por parametro.

        //Element Nom del joc.
        Node nodetitol = doc.createElement("titol");
        Node nodetitolText = doc.createTextNode(nomjoc);
        nodetitol.appendChild(nodetitolText);

        //Element creador del joc.
        Node nodecreador = doc.createElement("creador");
        Node nodecreadorText = doc.createTextNode(nomcreador);
        nodecreador.appendChild(nodecreadorText);

        //Element sinopsis del joc.
        Node nodesinopsis = doc.createElement("sinopsis");
        Node nodesinopsisText = doc.createTextNode(sinopsis);
        nodesinopsis.appendChild(nodesinopsisText);

        //Element plataforma del joc.
        Node nodeplataforma = doc.createElement("plataforma");
        Node nodeplataformaText = doc.createTextNode(plataforma);
        nodeplataforma.appendChild(nodeplataformaText);

        //Amb aixó fem que els elements que hem creat siguin fills de videojoc.
        nodevideojoc.appendChild(nodetitol);
        nodevideojoc.appendChild(nodecreador);
        nodevideojoc.appendChild(nodesinopsis);
        nodevideojoc.appendChild(nodeplataforma);

        //Després del ultim fill creat afegim un fill nout amb tots els elements que hem ficat ara.
        doc.getLastChild().appendChild(nodevideojoc);
        return doc;
    }

    //Feim un bucle for per mostrar tots els elements videojoc i els seus fills que hem creat fins ara,
    //cada videojoc esta separat per ---------- y cada vegada que s'hi crida al metode el separa amb @@@.
    public static void MostrarArbre(Document doc) {
        NodeList nodes = doc.getElementsByTagName("videojoc");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;
            System.out.println("Creat en: " + element.getAttribute("creat_en"));
            System.out.println("Nom videojoc: " + element.getElementsByTagName("titol").item(0).getTextContent());
            System.out.println("Creador: " + element.getElementsByTagName("creador").item(0).getTextContent());
            System.out.println("Sinopsis: " + element.getElementsByTagName("sinopsis").item(0).getTextContent());
            System.out.println("Plataforma: " + element.getElementsByTagName("plataforma").item(0).getTextContent());
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println("\n");

        }
        System.out.println("@@@@@@@@@@@@@@@@@@  Fi de mostrar arbre  @@@@@@@@@@@@@@@@@@\n");

    }

    //Pasam per parametre el nom del joc que volem modificar y el nou nom que volem ficar per modificar el joc.
    public static Document ModificarNomJoc(Document doc, String nomtitol, String nomtitol_nou) throws SAXException, IOException, ParserConfigurationException {
        //Recream els nodes amb node list i cercam els elements titol
        NodeList nodes = doc.getElementsByTagName("titol");
        //Pasam per tots els elements titol amb el for
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;

            if (element.getTextContent() == nomtitol) { //Si el text que hi ha al titol es el nom que hem cercat entrara a l'if i ho canviara per el nou titol que li donem.
                element.setTextContent(nomtitol_nou);
                break; //Si entra a l'if no fa falta que cerqui mes per aixó aquest break
            }

        }
        return doc;

    }

    //Pasam per parametre el nom del joc que volem eliminar.
    public static Document EliminarJoc(Document doc, String nomtitol) throws SAXException, IOException, ParserConfigurationException {
        NodeList nodes = doc.getElementsByTagName("videojoc");
        //Tornam a fer un bucle per cercar el joc per titol.
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;
            //Feim una nova variable per trobar el nom del joc que esteim cercant com solament hi ha un joc posam .item(0) ja que solament podrá estar a la possicio 0.
            String titulo = element.getElementsByTagName("titol").item(0).getTextContent();
            if (titulo.equals(nomtitol)) { //Si el titol es igual al que hem pasat per parametre simplement l'eliminarà.
                element.getParentNode().removeChild(element);
            }
        }
        return doc;

    }

    //Cream un nou archiu amb el nom que li passem per parametre i amb l'informació del doc.
    public static void GuardarArchivo(Document doc, String documento) throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transf = tf.newTransformer();
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult file = new StreamResult(new File(documento));
        transf.transform(source, file);
    }


    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        // TODO Auto-generated method stub
        try {
            //Utilizamos el metodo CargarXML y le pasamos por parametro el documento que queremos modificar.
            Document doc = CargarXML("videojocs.xml");

            //Con este nodelist nos situamos en los elementos videojoc.
            NodeList nodes = doc.getElementsByTagName("videojoc");

            //Creamos 5 juegos con el metodo CrearElemento().
            CrearElemento(doc, "JAP", "The legend of Zelda", "Shigeru Miyamoto", "famosa saga de videojocs de gènere RPG/Aventura ambientats en la seva majoria al regne fantàstic d'Hyrule, cadascun dels videojocs que componen la sèrie tenen com a protagonista a Link.", "NES");

            CrearElemento(doc, "USA", "Bioshock Infinite", "Ken Levine", " BioShock Infinite es un videojuego de disparos en primera persona y la tercera entrega de la franquicia BioShock, desarrollado por Irrational Games y distribuido por 2K Games.", "PC PS XBOX SWITCH");

            CrearElemento(doc, "JAP", "Kingdom Hearts 1", "Tetsura Nomura", " el nombre de la serie de videojuegos, perteneciente al género de juegos de rol de acción, desarrollado y publicado por Square Enix.", "PS2");

            CrearElemento(doc, "JAP", "Final Fantasy VII", "Yoshinori Kitase", " és un videojoc RPG desenvolupat per la companyia japonesa Squaresoft. Va sortir al mercat japonès el gener de 1997 convertint-se en la primera entrega de la saga Final Fantasy en usar com a plataforma la consola PlayStation de Sony.", "PS2");

            CrearElemento(doc, "JAP", "Knack 2", "Takamitsu Iijima", "Knack II is an action-platform game developed by SIE Japan Studio and published by Sony Interactive Entertainment for PlayStation 4.", "PS4");

            GuardarArchivo(doc, "creat.xml");

            MostrarArbre(doc);

            //Modificamos 2 juegos con el metodo ModificarNomJoc().
            ModificarNomJoc(doc, "The legend of Zelda", "La leyenda de Antonio el duende verde");

            ModificarNomJoc(doc, "Kingdom Hearts 1", "Kingdom Hearts 2");

            GuardarArchivo(doc, "modificats.xml");

            MostrarArbre(doc);

            //Eliminamos 1 juego con el Metodo EliminarJoc().
            EliminarJoc(doc, "La leyenda de Antonio el duende verde");

            GuardarArchivo(doc, "eliminat.xml");

            //Despues de modificar y borrar mostramos el arbol una vez para ver los cambios con el metodo MostrarArbre().
            MostrarArbre(doc);

            //Finalmente con el metodo GuardarArchivo() lo guardamos en un archivo llamado modificat.xml.
            GuardarArchivo(doc, "final.xml");

        } catch (Exception e) {
            e.getMessage();
        }

    }
}

