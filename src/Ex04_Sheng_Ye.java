import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Ex04_Sheng_Ye
 * Created by: sheng
 * Date : 04/10/2021
 * Description:
 **/
public class Ex04_Sheng_Ye {

    //Metodo donde uniremos dos ficheros
    public static void union(File file1 , File file2 ,File rutaDestino) {
        try {
            //Leeremos los dos ficheros
            BufferedReader br=new BufferedReader(new FileReader(file1));
            BufferedReader bR=new BufferedReader(new FileReader(file2));

            int numero = -1;


            //Esto por lo tanto lo leeremos y miraremos si existe ya o no el archivo , si existe ya te saldra una ventana en donde
            //te pregunta si quieres sobreescribirla
            if (rutaDestino.exists()) {
                numero = JOptionPane.showConfirmDialog(null,
                        "El fichero ya existe, ¿Quieres sobrescribir el fichero " + rutaDestino.getName() + "?", "Escribir",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
            if (numero != JOptionPane.CANCEL_OPTION) {

                //Guardamos o escribimos dentro del fichero final
                BufferedWriter bw;
                FileWriter fw = new FileWriter(rutaDestino);
                bw = new BufferedWriter(fw);
                //Copiamos el contenido al fichero destino
                escribir(bw, br);
                escribir(bw, bR);

                //Despues de copiar cerramos el buffered

                bw.close();

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void escribir(BufferedWriter bw, BufferedReader br) throws IOException{

        //Leamos la linea del archivo que leeremos
        String linea=br.readLine();
        //Bucle para que escriba en los archivos que indicamos
        while(linea!=null){

            bw.write(linea);
            //Lee en tiempo y asi se queda guardado
            bw.flush();

            linea=br.readLine();
        }

    }

    public static void main(String[] args) {

        //Introducimos el scanner para que nos lo pida por teclado
        Scanner sc = new Scanner(System.in);


        //Preguntamos el primer fichero a lo que hace que mire el primer fichero indicado
        System.out.println("Indica el fichero de la primera ruta: ");
        String fichero1 = sc.nextLine();
        File ficha1 = new File(fichero1);

        //Preguntamos por el segundo fichero y sera indicado de la segunda
        System.out.println("Indica el fichero de la segunda ruta: ");
        String fichero2 = sc.nextLine();
        File ficha2 =new File(fichero2);


        //Preguntamos por donde guardar los dos archivos al que queremos guardar
        System.out.println("Indica la ruta para guardar: ");
        String rutafinal = sc.nextLine();

        //Quitamos la extension del primer fichero para que se quede sin extension
        String ficherosa = ficha1.getName();
        ficherosa = ficherosa.substring(0 , ficherosa.lastIndexOf('.'));

        //Como guardar el fichero y con que nombre
        String nombreFicheroFinal=ficherosa+"_"+ficha2.getName();


        rutafinal+=nombreFicheroFinal;

        //Creamos el archivo de la salida final
        File ruta=new File(rutafinal);

        //Y con el metodo la creamos

        union(ficha1 ,ficha2,ruta);

    }


}
