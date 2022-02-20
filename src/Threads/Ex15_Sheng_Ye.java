package Threads;

/**
 * Threads
 * Nombre_project: AccesBase
 * Ex14_Sheng_Ye
 * Created by: sheng
 * Date : 11/11/2021
 * Description:
 **/
public class Ex15_Sheng_Ye extends Thread {



    public static void main(String[] args) throws InterruptedException {

        Ex15_Sheng_Ye corredor1 = new Ex15_Sheng_Ye();
        Ex15_Sheng_Ye corredor2 = new Ex15_Sheng_Ye();
        Ex15_Sheng_Ye corredor3 = new Ex15_Sheng_Ye();

        //Añadimos el nombre a los corredores
        corredor1.setName("Juan ");
        corredor2.setName("Jorge ");
        corredor3.setName("Dani ");



        //Le damos la prioridad a los corredores , cuando mas alto es el numero mas rapido llegan a la meta
        corredor1.setPriority(1);
        corredor2.setPriority(6);
        corredor3.setPriority(9);

        //Iniciamos los corredores
        corredor1.start();
        corredor2.start();
        corredor3.start();

        //Añadimos a los corredores
        corredor1.join();
        corredor2.join();
        corredor3.join();

    }

    //Hacemos el metodo run
    @Override
    public void run() {
        //Donde haya un bucle en que la carrera haga 50metros
        int carrera = 0;
        while (carrera < 50){
            carrera++;
            //printeamso con el nombre
            System.out.println(getName() + carrera + " metros");
        }
        //Y decimos que se ha acabado
        System.out.println(getName()+"ha acabado");
    }
}
