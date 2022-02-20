import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Prueba1FileWriter
 * Created by: sheng
 * Date : 29/09/2021
 * Description:
 **/
public class Prueba1FileWriter {
    public static void main(String[] args) throws IOException {
        //Hacemos un BufferedWriter para añadir al archivo

        BufferedWriter bw = null;

        try {
            //Hacemos un string donde podemos ver el contenido del archivo y para hacer que parezca a un xml ,
            //lo que hemos hecho es poner \n para añadir que digamos un "enter" y tambien la \t para hacer tabular
            //de esta forma para que se parezca
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<Libros>\n" + "\t<Libro>\n" + "\t\t<Titulo> El Capote </Titulo>\n" + "\t</Libro>\n" + "</Libros>";
        //Ruta
        String path = "src\\";
        //Nombre del fichero
        String filename = "Prueba.xml";
        File file = new File(path + filename);
        //Este if comprueba si el arhcivo existe o no
            if (!file.exists()) {
                file.createNewFile();
            }
            //Crearemos el archivo y el contenido
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(xml);


        }catch (Exception e){
            e.printStackTrace();
            }finally {

                //Si existe entonces se cierra y sino le saldra un error donde le especifica que no vaya bien
                try {
                    if (bw != null)
                        bw.close();
                } catch (Exception ex) {
                    System.out.println("Error in closing the BufferedWriter" + ex);
                }
            }
    }
}
