package Threads;

import java.util.concurrent.Semaphore;

/**
 * Threads
 * Nombre_project: AccesBase
 * Client
 * Created by: sheng
 * Date : 16/11/2021
 * Description:
 **/
public class Client implements Runnable{

    //Atributos de los clientes

    int idCliente;
    Ex17_Sheng_Ye carniceria;
    static int numeroPermisos = 5;
    static Semaphore semaphore = new Semaphore(numeroPermisos);

    //Iniciamos la clase de cliente
    public Client(int id , Ex17_Sheng_Ye carne){
        this.idCliente =id;
        this.carniceria = carne;
    }


    //Hacemos el metodo run
    @Override
    public void run() {
        try{
            //Donde el semaforo le damos permiso
            semaphore.acquire();
            this.carniceria.compraCarne(this.idCliente);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Liberamos el semaforo del ermiso
        semaphore.release();

    }
}
