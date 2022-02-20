package saxxml;

/**
 * saxxml
 * Nombre_project: AccesBase
 * Musica
 * Created by: sheng
 * Date : 09/11/2021
 * Description:
 **/
public class Musica {

    private String nombre_grupo;
    private String categoria;
    private String nombre_cancion;
    private String nombre_album;
    private String año;

    public Musica() {
    }

    public Musica(String nombre_grupo, String categoria, String nombre_cancion, String nombre_album, String año) {
        this.nombre_grupo = nombre_grupo;
        this.categoria = categoria;
        this.nombre_cancion = nombre_cancion;
        this.nombre_album = nombre_album;
        this.año = año;
    }
    public String getNombre_grupo() {
        return nombre_grupo;
    }

    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getNombre_album() {
        return nombre_album;
    }

    public void setNombre_album(String nombre_album) {
        this.nombre_album = nombre_album;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

}
