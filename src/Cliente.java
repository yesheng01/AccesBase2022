//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Scanner;
//
///**
// * Created by: Daniels
// * Date: 15/02/2022
// * Description: Cliente para la Practica de Servicios
// */
//public class Cliente {
//    public static void main(String[] args) {
//        try(Socket socket = new Socket("192.168.100.175", 5050)){
//
//            //Scanner del cliente
//            Scanner scanner = new Scanner(System.in);
//            //Scanner del server
//            Scanner scannerSocket = new Scanner(socket.getInputStream());
//            //PrintWriter del cliente
//            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
//
//            //Usuario
//            System.out.println(scannerSocket.nextLine());
//            printWriter.println(scanner.nextLine());
//            //Contraseña
//            System.out.println(scannerSocket.nextLine());
//            printWriter.println(scanner.nextLine());
//
//            System.out.println(scannerSocket.nextLine());
//
//            //Ciclo de comandos
//            System.out.println("Para hacer un GET: GET <nombre_de_clave>");
//            System.out.println("Para hacer un SET: PUT <nombre_de_clave> <valor>");
//            System.out.println("Para editar un valor: SET <nombre_de_clave> <valor>");
//            System.out.println("Para hacer un DELETE: DELETE <nombre_de_clave>");
//            System.out.println("-----------------------------------------------------");
//            System.out.println("(CTRL+D para terminar el programa)");
//
//            while(true){
//                printWriter.println(scanner.nextLine());
//                System.out.println(scannerSocket.nextLine());
//            }
//        }catch (Exception e){
//            System.out.println("Saliendo del programa");
//        }
//    }
//}
