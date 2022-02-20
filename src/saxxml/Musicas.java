package saxxml;

/**
 * saxxml
 * Nombre_project: AccesBase
 * Musicas
 * Created by: sheng
 * Date : 09/11/2021
 * Description:
 **/
public enum Musicas {

    MUSICAS("Nombre_grupo") , CATEGORIA("Categoria") , NOMBRE("Nombre_cancion") ,
    ALBUM("Nombre_album") , PUBLICACION("año");


    private final String name;
    Musicas(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
