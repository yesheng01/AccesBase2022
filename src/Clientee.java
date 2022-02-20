/**
 * PACKAGE_NAME
 * Nombre_project: AccesBase
 * Cliente
 * Created by: sheng
 * Date : 03/11/2021
 * Description:
 **/
public class Clientee {

    private String nombre;
    private int edad;

    public Clientee(String nombre, int edad) {
        this.nombre=nombre;
        this.edad=edad;
    }
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