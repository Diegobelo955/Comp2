package Classes;

import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        CalculadoraDeMedia calculadoraDeMedia = new CalculadoraDeMedia();
        String nomeDoArquivo;


     Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo em que estão armazenadas as notas");
        do {
            nomeDoArquivo = scanner.nextLine();
            if (calculadoraDeMedia.calcularMedia(nomeDoArquivo)==2){
                System.out.println("Arquivo não encontrado, digite novamente");
            }
        }while (calculadoraDeMedia.calcularMedia(nomeDoArquivo)==2);
        System.out.println(calculadoraDeMedia.calcularMedia(nomeDoArquivo));

    }
}
