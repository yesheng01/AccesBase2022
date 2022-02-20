package Sax2;

/**
 * Sax2
 * Nombre_project: AccesBase
 * Clientes
 * Created by: sheng
 * Date : 03/11/2021
 * Description:
 **/
public enum Clientes {



    CLIENTES("nombre") , EDAD("edad");

    private final String name;

    //Constructor de desayuno donde le pasamos el nombre
    Clientes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
