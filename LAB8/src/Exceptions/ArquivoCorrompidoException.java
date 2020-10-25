package Exceptions;

public class ArquivoCorrompidoException extends Exception {
    public ArquivoCorrompidoException(int linhas) {
        super("Quantidade de linhas inválias superior ao de linhas válidas. Total: " + linhas);

    }
}
