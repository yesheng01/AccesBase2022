package saxxml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * saxxml
 * Nombre_project: AccesBase
 * Handler2
 * Created by: sheng
 * Date : 09/11/2021
 * Description:
 **/
public class Handler2 extends DefaultHandler {
    private boolean nombre_grupo;
    private boolean Categoria;
    private boolean nombre_cancion;
    private boolean nombre_album;
    private boolean publicacion;

    private Musica musica = new Musica();
    //Añadimos en un array el desayuno
    private final List<Musica> musicas = new ArrayList<>();

    //Recogemos el inicio de los elementos
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals(Musicas.MUSICAS.getName())) {
            nombre_grupo = true;
        }
        if (qName.equals(Musicas.CATEGORIA.getName())) {
            Categoria = true;
        }
        if (qName.equals(Musicas.NOMBRE.getName())) {
            nombre_cancion = true;
        }
        if (qName.equals(Musicas.ALBUM.getName())) {
            nombre_album = true;
        }
        if (qName.equals(Musicas.PUBLICACION.getName())) {
            publicacion = true;
        }
    }

    //Llamaremos donde se encuentra los caracteres de la informacion dentro de un elemento
    @Override
    public void characters(char[] ch, int start, int length) {
        if (nombre_grupo) {
            musica.setNombre_grupo(new String(ch, start, length));
            nombre_grupo = false;
        }
        if (Categoria) {
            musica.setCategoria(new String(ch, start, length));
            Categoria = false;
        }
        if (nombre_cancion) {
            musica.setNombre_cancion(new String(ch, start, length));
            nombre_cancion = false;
        }
        if (nombre_album) {
            musica.setNombre_album(new String(ch, start, length));
            nombre_album = false;
        }
        if (publicacion) {
            musica.setAño(new String(ch, start, length));
            publicacion = false;
        }
    }

    //Este llama el final del elemento al que es cogido del xml
    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals(Musicas.MUSICAS.getName())) {
            musicas.add(musica);
            musica = new Musica();
        }
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
}
