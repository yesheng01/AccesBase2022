import java.io.*;
import java.util.Scanner;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Ex10Sheng_Ye
 * Created by: sheng
 * Date : 21/10/2021
 * Description:
 * Escribir una clase llamada Mayúsculas que haga lo siguiente:
 * Cree un proceso hijo.
 *
 * El proceso padre y el proceso hijo se comunicarán de manera bidireccional utilizando streams.
 *
 * El proceso padre leerá líneas de su entrada estándar y las enviará a la entrada estándar del
 * hijo (utilizando el OutputStream del hijo).
 *
 * El proceso hijo lee el texto por su entrada estándar, lo transformará en letras mayúsculas y lo imprimirá para su salida estándar. Para realizar el programa hijo se puede utilizar cualquier lenguaje de programación, generando un ejecutable.
 *
 * El padre imprimirá en pantalla lo que recibe del hijo a través del InputStream de este
 **/

public class Ex10_Sheng_Ye {


    public static void main(String[] args) throws IOException {

        /** Primero de crearemos el processbuilder ya para pasarle un proceso */
        ProcessBuilder processBuilder = new ProcessBuilder();

        /** Hacemos un scanner en donde le pregunta para escribir */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe lo que quieras: ");


        /** En el process le pasamos como el comando desde el powershell en donde le pasamos el parametro del
         * scanner en donde leera el archivo de powershell */
        processBuilder.command("powershell.exe" , "src/Mayusculas.ps1 -line '"+scanner.nextLine()+"'");


        /** Inicializamos el proceso */
        try{
            Process process = processBuilder.start();

            /** Ahora le pasamos el bufferedReader en donde leera las lineas */

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));


            /** Y hacemos un sout en donde le pasamos el bufferedreader de la linea leida*/
            String linea = bufferedReader.readLine();
            System.out.println(linea);

            /** Esperamos que el proceso se termine */
            process.waitFor();


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
