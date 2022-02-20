package SAX;

/**
 * SAX
 * Nombre_project: AccesBase
 * Food
 * Created by: sheng
 * Date : 27/10/2021
 * Description:
 **/
public class Food {

    //Crearemos las etiquetas que tienen el xml del cual lo cogeremos para despues

    private String nombre;
    private double precio;
    private String descripcion;
    private int calorias;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
