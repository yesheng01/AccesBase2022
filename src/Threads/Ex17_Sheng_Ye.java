package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Threads
 * Nombre_project: AccesBase
 * Ex17_Sheng_Ye
 * Created by: sheng
 * Date : 16/11/2021
 * Description:
 **/
public class Ex17_Sheng_Ye {


    //Iniciamos el metodo donde los clientes va a comprar el carne
    public void compraCarne(int idCliente){
        //Le ponemos en un tiempo random al que ira a comprar
        long tiempo = (long) (Math.random() * 10000);
        try {
            System.out.println("El cliente " + idCliente + " Entra a la cola para comprar ");
            Thread.sleep(tiempo); // El cliente se tomara su tiempo para comprar.
            System.out.println("El cliente " + idCliente + " Ha tardado en comprar en:  " + tiempo);
        } catch (InterruptedException E) {
            System.out.println("Fail");
        }
    }


    //Hacemos el metodo main
    public static void main(String[] args) {
        //Iniciamos la clase
        Ex17_Sheng_Ye client = new Ex17_Sheng_Ye();
        //Hacemos el metodo de ejecutar
        ExecutorService ejecutor = Executors.newFixedThreadPool(5);
        //Un For que recoja 20 cleintes y que se va ejecutando
        for (int i = 0; i < 20; i++) {
            ejecutor.execute(new Client(i,client));
        }
        //Al llegar todos se termina
        ejecutor.shutdown();
        while (!ejecutor.isTerminated());

    }

}
