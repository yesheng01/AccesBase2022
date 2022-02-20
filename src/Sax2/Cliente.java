package Sax2; /**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Sax2.Cliente
 * Created by: sheng
 * Date : 20/10/2021
 * Description:
 **/
public class Cliente {

    private String nombre;
    private int edad;

    //Getter and Setter

    public void setNombre (String nom) {
        this.nombre=nom;
    }
    public void setEdad (int ed) {
        this.edad=ed;
    }

    public String getNombre() {
        return this.nombre;
    }
    public int getEdad() {
        return this.edad;
    }

}
