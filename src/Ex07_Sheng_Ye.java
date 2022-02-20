import java.io.*;
import java.util.Scanner;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Ex07_Sheng_Ye
 * Created by: sheng
 * Date : 08/10/2021
 * Description:
 **/
public class Ex07_Sheng_Ye {

    //Hacemos el metodo para crear el fichero al que le pasamos el fileWriter y añadimos la ruta en donde estara el fichero
    public static void crearFichero() {

        FileWriter fw = null;
        try {
            fw = new FileWriter("src/pruebas-fichero/numeros.txt");
            PrintWriter pw = new PrintWriter(fw);
            //Metodo para escribir el fichero los numeros volcados
            escribirFicheo(pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //Metodo para crear numeros pares hasta 100 y que printee en los ficheros
    public static void escribirFicheo(PrintWriter pw) throws Exception{
        for (int i = 0; i < 200; i++) {

            if (i % 2 == 0 ) {
                pw.println(i);
            }

        }
    }

    //Este metodo enseña el fichero , el contenido del archivo que se llama numeros y alli estan guardadas

    public static void mostrarFichero() {
        FileReader fr = null;
        try {
            //Le pasamos la ruta
            File fichero = new File("src/pruebas-fichero/numeros.txt");
            fr = new  FileReader(fichero);
            //Esto para leer el fichero
            BufferedReader br = new BufferedReader(fr);
            leerFichero(br);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }finally{

            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

        }

    }
    //Metodo para leer el fichero linea por linea , por lo que luego printea los numeros
    public static void leerFichero(BufferedReader br)throws Exception{
        String linea;
        linea = br.readLine();
        while (linea != null) {
            System.out.println(linea);
            linea = br.readLine();
        }
    }

    //Ejecutamos los metodos
    public static void main(String[] args) {
        crearFichero();
        mostrarFichero();
    }

}
