package saxxml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * saxxml
 * Nombre_project: AccesBase
 * Ex14_Sheng_Ye
 * Created by: sheng
 * Date : 09/11/2021
 * Description:
 **/
public class Ex14_Sheng_Ye {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Boolean salir = false;
        ArrayList<Musica> musicas = new ArrayList<>();
        Ex14_Sheng_Ye ex14_sheng_ye = new Ex14_Sheng_Ye();
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nombre del grupo: ");
            String texto = scanner.nextLine();

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Categoria a la que pertenece: ");
            String texto1 = scanner1.nextLine();

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Nombre de la cancion: ");
            String texto2 = scanner2.nextLine();

            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Nombre del album al que pertenece a la cancion:");
            String texto3 = scanner3.nextLine();

            Scanner scanner4 = new Scanner(System.in);
            System.out.println("Año de publicacion: ");
            String texto4 = scanner4.nextLine();


            Musica musica = new Musica( texto, texto1,texto2, texto3 , texto4);
            musicas.add(musica);
            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Si quieres seguir pon: si y si no pon : no ");
            String texto5 = scanner5.nextLine();

            if (texto5.equals("no")){
                salir=true;
            }else if (texto5.equals("si")){
                System.out.println("seguimos");
            }

        }while (!salir);
        //Crearemos la instancia del parser donde invoca un handler
        ex14_sheng_ye.crearxml(musicas);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        //Iniciamos el handler
        Handler2 handlers = new Handler2();
        //Parser donde parsea la ruta del xml y el handler para leer
        saxParser.parse("src/xml/musica.xml", handlers);

        //Listeamos el array del desayuno
        List<Musica> liste = handlers.getMusicas();
        //Donde hacemos el for en donde le cogemos el nombre , descripcion , precio y de las calorias
        for (Musica musico : liste) {
            System.out.println("nombre_grupo: " + musico.getNombre_grupo());
            System.out.println("Categoria: " + musico.getCategoria());
            System.out.println("nombre_cancion: " + musico.getNombre_cancion());
            System.out.println("nombre_album: " + musico.getNombre_album());
            System.out.println("nombre_publicacion: " + musico.getAño());
        }
    }


    public void crearxml(ArrayList<Musica> list){

        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try{
            fileWriter = new FileWriter("src/xml/musica.xml");
            printWriter = new PrintWriter(fileWriter);
            printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\t");
            printWriter.println("<Canciones>\t");
            for (int i = 0; i < list.size(); i++) {
                printWriter.println("\t<Cancion>");
                printWriter.println("\t\t<Nombre_grupo>" + list.get(i).getNombre_grupo()+ "</Nombre_grupo>");
                printWriter.println("\t\t<Categoria>" + list.get(i).getCategoria()+ "</Categoria>");
                printWriter.println("\t\t<Nombre_cancion>" + list.get(i).getNombre_cancion()+ "</Nombre_cancion>");
                printWriter.println("\t\t<Nombre_album>" + list.get(i).getNombre_album()+ "</Nombre_album>");
                printWriter.println("\t\t<año>" + list.get(i).getAño()+ "</año>");
                printWriter.println("\t</Cancion>");
            }
            printWriter.println("</Canciones>");
            printWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
