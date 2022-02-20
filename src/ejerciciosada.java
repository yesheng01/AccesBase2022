import java.util.ArrayList;

/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * ejerciciosada
 * Created by: sheng
 * Date : 11/02/2022
 * Description:
 **/
public class ejerciciosada {
    public static void main(String[] args) {
        ArrayList<Integer>arrayList = new ArrayList<Integer>();

        int o = 12;

        for (int i = 2; i < o; i++){
            if (o % i == 0){
                arrayList.add(i);
                System.out.println(i);
            }
        }

        int result ;

        if (arrayList.size() < 2){
            result = arrayList.size();
        }else{
            result = arrayList.get(arrayList.size() - 2);
        }
        System.out.println(result);

        if (arrayList.size() == 0){
            System.out.println("el resultado es 0");
        }else if (arrayList.size()== 1){
            System.out.println("el resultado es 1");
        }




    }
}
