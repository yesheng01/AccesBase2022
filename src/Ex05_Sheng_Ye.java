import java.io.*;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Ex05_Sheng_Ye
 * Created by: sheng
 * Date : 05/10/2021
 * Description:
 **/
public class Ex05_Sheng_Ye {
    public static void main(String[] args) {


        //Creamos el processBuilder para luego poner el comando en el momento en el que abrimos y que guarde en el comando
        //El comando  dir al que le hemos pasado


        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("cmd.exe", "/c", "dir C:\\users > src\\pruebas-fichero\\commands.txt");


        //Este try o metodo que hemos hecho es que inicie el proceso , osea la linea de comando en el que
        //hemos puesto antes y si sale un 0 es que se ha hecho correctamente y se cierra
        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            System.out.println("\nSe ha creado correctamente: " + exitCode +" \n");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


        //Ahora haremos un FileReader donde lea el archivo , donde le pasamos la ruta y el archivo , entonces luego un
        //BufferedReader que lea el archivo

        try {
            FileReader Fr = new FileReader("src\\pruebas-fichero\\commands.txt");
            BufferedReader reader = new BufferedReader(Fr);
            String line;
            while ((line = reader.readLine()) != null) {
                //Lo lee y printea el contenido del archivo
                System.out.println(line);
            }
            Fr.close();

        } catch (IOException e) {
            //Error si no va bien el programa
            e.printStackTrace(System.err);
        }

    }
}
