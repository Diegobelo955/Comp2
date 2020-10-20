import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;
    private T anexo;
    public ArrayList<String> tags = new ArrayList<>();

    // hashtags?
    // objeto anexado?



    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
    }

    public  void anexarAlgo(T objeto) {
        this.anexo = objeto;


    }

    public Object getAnexo() {
        return this.anexo;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public ArrayList<String> getHashtags() {
        String[] text = this.texto.split("[\\s,!]");
        for (String hastags : text) {
            if (hastags.startsWith("#")) {
                tags.add(hastags);

            }

            int numOccurences = Collections.frequency(tags, "");

        }
        return this.tags;
    }

}
