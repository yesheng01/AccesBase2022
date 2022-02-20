package SAX;

/**
 * SAX
 * Nombre_project: AccesBase
 * Desayuno
 * Created by: sheng
 * Date : 27/10/2021
 * Description:
 **/
//Hacemos un clase enum en donde el nombre del xml  y de la clase
public enum Desayuno {

    //Recogemos los elementos y el nombre de cada uno dentro de la clase Handler que es donde le pasaremos

    FOOD("food"), NAME("name"), PRICE("price"), DESCRIPTION("description"), CALORIES("calories");

    private final String name;

    //Constructor de desayuno donde le pasamos el nombre
    Desayuno(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
