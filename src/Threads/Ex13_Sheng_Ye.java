package Threads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Threads.Ex13_Sheng_Ye
 * Created by: sheng
 * Date : 05/11/2021
 * Description:
 **/
public class Ex13_Sheng_Ye extends Thread{

    public static void main(String[] args) {

        Ex13_Sheng_Ye ex13_sheng_ye = new Ex13_Sheng_Ye();
        //Inicializamos el thread con un start
        ex13_sheng_ye.start();
    }

    //Hacemos un metodo run en donde se ejecutaran los codigos al que le pasemos
    @Override
    public void run() {
        //Donde le pasamos un boolean en que le pasaremos por un while
        boolean fin = false;
        //Hacemos un bucle while cuando es verdadero hara lo siguiente
        while (!fin){
            //Nos preguntara el nombre del alumno
            System.out.println("Nombre de alumno: ");
            Scanner scanner = new Scanner(System.in);
            String nombre;
            nombre = scanner.nextLine();
            //y hacemos un if en donde si escribe fin o un intro finaliza el programa
            if (nombre.equals("fin") || nombre.equals("")){
                fin = true;
                //De lo contrario hara el programa
            }else{
                //Donde le preguntaremos por la hora y el minuto
                System.out.println("Hora y minutos al que has llegado(En formato HH:mm): ");
                Scanner scanner1 = new Scanner(System.in);
                String hora = scanner1.nextLine();
                //Damos el formateo a la hora de como lo que queremos
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

                //Le pasaremos el parametro por la fecha
                Date date = null;
                try {
                    //Le pasamos la fecha en que le parsearemos
                  date = dateFormat.parse(hora);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                assert date != null;
                //Hacemos el if de las horas segun en que llega el alumno
                if (date.getHours() < 15){
                    System.out.println("Ha llegado antes de la hora " + nombre);
                }else if (date.getMinutes() > 00){
                    System.out.println("Ha llegado tarde " + nombre);
                }else if (date.getHours() == 15){
                    System.out.println("Ha llegado justo a la hora " + nombre);
                }

            }

        }

    }
}
