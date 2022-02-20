import java.io.*;
import java.util.Scanner;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Ex03_Sheng_Ye
 * Created by: sheng
 * Date : 04/10/2021
 * Description:
 * Crea una aplicación donde pidamos la ruta de un fichero por teclado y un texto que queramos a escribir en el fichero.
 * Deberás mostrar por pantalla el mismo texto pero variando entre mayúsculas y minúsculas, es decir, si escribo
 * “Bienvenido” deberá devolver “bIENVENIDO”. Si se escribe cualquier otro carácter, se quedara tal y como se escribió.
 * Deberás crear un método para escribir en el fichero el texto introducido y otro para mostrar el contenido en mayúsculas.
 **/
public class Ex03_Sheng_Ye {
    public static void main(String[] args) throws IOException {
        //Introducimos el scanner para que nos lo pida por teclado
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una ruta del fichero para guardar: ");
        String rutas = sc.nextLine();
        System.out.println("Introduce el contenido dentro del fichero: ");
        String ficheros = sc.nextLine();
        //Metodo donde llama la ruta y el fichero al que hemos introducido por teclado
        rutafichero(rutas, ficheros);
        //Metodo que muestra el fichero por la ruta
        MostrarFichero(rutas);
    }

    //Metodo que muestra el fichero por pantalla , si es mayus mostra minus y asi a lo contrario
    public static void MostrarFichero(String mostrar) throws IOException {
        //Lo que hara es leer el fichero
        int numero = 0;
        FileReader fr = new FileReader(mostrar);
        while(numero!=-1) {

            //Cambia si es minus o al mayus
            char letras = (char) numero;
            if (letras >= 'a' && letras <= 'z') {
                letras -= 32;
            } else if (letras >= 'A' && letras <= 'Z') {
                letras += 32;
            }
            //Muestra por pantalla lo escrito
            System.out.print(letras);
            numero = fr.read();
        }
    }

    //Metodo donde escribe la ruta del fichero y lo escribe para luego guardarlo
    public static void rutafichero(String ruta, String fichero) throws IOException {
        File file = new File(ruta);
        FileWriter fw = new FileWriter(file);
        fw.write(fichero);
        fw.close();
    }

}

