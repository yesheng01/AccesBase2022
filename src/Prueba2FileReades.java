import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Prueba2FileReades
 * Created by: sheng
 * Date : 30/09/2021
 * Description:
 * Crea un fichero de texto con el nombre y contenido que tu quieras.
 * Ahora crea una aplicación que lea este fichero de texto carácter a carácter y muestre su contenido por pantalla  sin espacios.
 * Por ejemplo, si un fichero tiene el siguiente texto “Esto es una prueba”, deberá mostrar “Estoesunaprueba”.
 **/
public class Prueba2FileReades {
    public static void main(String[] args) throws IOException {
        //String para decir el archivo
        String path = "src\\Prueba1.txt";
        //Try para que lea el archivo
        FileReader fr = new FileReader(path);
        try (fr) {
            int letra = fr.read();
            //Lo que hace en un bucle while es que lea letra por letra y dependiendo de que si es una letra te lo printea y si te lee
            //un espacio lo que hace es no printear y vuelve para la siguiente letra.
            while (letra != -1) {
                if (letra != ' ') {
                    //Printeamos los resultados
                    System.out.print((char)letra);
                }
                //Cerramos el bucle cuando termine
                letra = fr.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
