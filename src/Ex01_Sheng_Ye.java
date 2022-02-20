import java.io.IOException;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Ex01_Sheng_Ye
 * Created by: sheng
 * Date : 01/10/2021
 * Description:
 **/
public class Ex01_Sheng_Ye {

    public static void main(String[] args) throws IOException {
        //Creamos un try en donde le pasamos el parametro Process en donde el metodo de "Runtime.getRuntime().exec(atgs)" que
        //inicie args y luego añadirle el start , de esta forma se ejecuta el proceso que queremos , es lo mismo que el anterior
        //ProcessBuilder pero el runtime vale por una sola cadena.
        try {
            System.out.println("Ejecutando el programa");
            Process process = Runtime.getRuntime().exec(args);
            process.destroy();
            //Por lo tanto al salir , podemos ver que la salida del codigo es 1 ya que lo hemos cerrado
            System.out.println("\nCodigo de salida: " + process.waitFor());
        } catch (InterruptedException e) {
            //Error si no va bien el programa
            e.printStackTrace(System.err);
        }

    }
}
