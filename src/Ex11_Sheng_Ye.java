import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
   PACKAGE_NAME
   Nombre_project: AccesBase
AleatorioPrincipal
    Created by: sheng
    Date : 27/10/2021
    Description:
**/public class Ex11_Sheng_Ye {


    public static void main(String[] args) throws IOException, InterruptedException {

        //Inicializamos el processbuilder para poder añadir el comando que lo haremos por powershell
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("powershell.exe", "get-random -minimum 0 -maximum 11");
        //Le pasaremos el scanner
        Scanner entrada = new Scanner(System.in);
        //Le pasamos el string que se llama texto
        String texto;
        try {
            //Hacemos el print para mostrar los numeros que se quiere mostrar
            System.out.println("Escriba aqui:");

            do {
                //Iniciamos el proceso con el processbuilder
                Process procesos = processBuilder.start();
                //Leemos el proceso
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(procesos.getInputStream()));
                //Cogemos el texto  cuando escribimos por teclado
                texto = entrada.nextLine();
                //Hacemos un if en donde si el texto  no es fin
                if (!texto.equals("fin")) {
                    //Lee la linea del string
                    String linea = bufferedReader.readLine();
                    //Printea la linea del numero aleatorio
                    System.out.println(linea);
                }

            //Cuando la linea es fin , acaba
            }while (!texto.equals("fin")); {
                System.out.println("Acaba");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
