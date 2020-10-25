package Classes;

import Exceptions.ArquivoCorrompidoException;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Locale.*;

public class CalculadoraDeMedia {

    private Exception ArquivoCorrompidoException;

    public float calcularMedia(String nomeDoArquivo) throws Exception {
        List<Float> notas = new ArrayList<>();

        int contadorLinhasInvalidas = 0;
        int contadorNotasValidas = 0;
        float somatorioNotas = 0;
        float CONSTANTE_RETORNO_EXECAO = 2;

        File file;
        file = new File("C:\\Users\\Naruto\\Desktop\\Comp2\\Comp2\\LAB8\\src\\Arquivos\\" + nomeDoArquivo);

        Scanner scanner = null;

            //System.out.println("Digite o arquivo em que deseja procurar as médias");
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                return CONSTANTE_RETORNO_EXECAO;
            }




            while (scanner.hasNext()) {
                //System.out.println(scanner.nextLine());
                try {
                    notas.add(Float.parseFloat(scanner.nextLine()));
                    //notas.add(nota);
                    contadorNotasValidas++;
                } catch (Exception e) {
                    contadorLinhasInvalidas++;
                }
            }


            if (contadorLinhasInvalidas <= contadorNotasValidas) {
                for (float aux : notas) {
                    somatorioNotas += aux;
                }
                float mediaFinal = somatorioNotas / contadorNotasValidas;
                return mediaFinal;
            } else {
                throw new ArquivoCorrompidoException(contadorLinhasInvalidas);
            }


    }
}
