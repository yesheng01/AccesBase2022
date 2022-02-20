import java.io.*;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Ex06_Sheng_Ye
 * Created by: sheng
 * Date : 06/10/2021
 * Description:
 * Crear un programa que sea capaz de contar cuantas vocales hay en un fichero (por ejemplo el texto de este enunciado).
 * El programa padre debe lanzar cinco procesos hijo, donde cada uno de ellos se ocupará de contar una vocal concreta
 * (que puede ser minúscula o mayúscula). Cada subproceso que cuenta vocales deberá dejar el resultado en un fichero.
 * El programa padre se ocupará de recuperar los resultados de los ficheros,
 * sumar todos los subtotales y mostrar el resultado final en pantalla
 **/
public class Ex06_Sheng_Ye {

    public static int numeros(ProcessBuilder processBuilder) throws IOException {
        //Iniciamos los procesos y de esta forma empieza a leer
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            //Leemos las lineas del fichero
            String line = reader.readLine();
        //Intentamos que haga el return y nos de los resultados
        return Integer.parseInt(line);
    }



    public static void main(String[] args) {

        //Hago un comando con el ProcessBuilder para que este lea el fichero y ejecute el comando por powershell

        ProcessBuilder commandoA = new ProcessBuilder();
        commandoA.command("powershell.exe", "C:\\Users\\sheng\\IdeaProjects\\AccesBase\\src\\Ejercicio-Vocales\\a.ps1");
        ProcessBuilder comandoE = new ProcessBuilder();
        comandoE.command("powershell.exe", "C:\\Users\\sheng\\IdeaProjects\\AccesBase\\src\\Ejercicio-Vocales\\e.ps1");
        ProcessBuilder comandoI = new ProcessBuilder();
        comandoI.command("powershell.exe", "C:\\Users\\sheng\\IdeaProjects\\AccesBase\\src\\Ejercicio-Vocales\\i.ps1");
        ProcessBuilder comandoO = new ProcessBuilder();
        comandoO.command("powershell.exe", "C:\\Users\\sheng\\IdeaProjects\\AccesBase\\src\\Ejercicio-Vocales\\o.ps1");
        ProcessBuilder comandoU = new ProcessBuilder();
        comandoU.command("powershell.exe", "C:\\Users\\sheng\\IdeaProjects\\AccesBase\\src\\Ejercicio-Vocales\\u.ps1");

        try {

            //Muestra cuantos vocales hay en un fichero

            System.out.println("Cantidad de A = " + numeros(commandoA));
            System.out.println("Cantidad de E = " + numeros(comandoE));
            System.out.println("Cantidad de I = " + numeros(comandoI));
            System.out.println("Cantidad de O = " + numeros(comandoO));
            System.out.println("Cantidad de U = " + numeros(comandoU));


            //Hacemos la suma
            int suma = numeros(commandoA)+numeros(comandoE)+numeros(comandoI)+numeros(comandoO)+numeros(comandoU);

            System.out.print("En total hacen que el numero de vocales sea igual a: "+suma);


        } catch (IOException | NumberFormatException e) { //Excepciones
            e.printStackTrace();
        }
    }

}