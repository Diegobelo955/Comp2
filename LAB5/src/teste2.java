import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class teste2 {
    public static void main(String[] args) {
        ArrayList<String> tags = new ArrayList<>();

        String frase = "#Testando algo,sdf com #hashtags no meio #teste vamos ver!fdfgf";
            String[] palavras = frase.split("[\\s,!]");
            for (String palavra : palavras) {
                if (palavra.startsWith("#")) {
                    System.out.println(palavra);
                    tags.add(palavra);

                }
            }

        System.out.println(tags.contains("#Testando"));
        }





       }


