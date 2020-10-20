import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 *  Esta classe implementa um sistema de mensagens curtas estilo Twitter.
 *  É preciso cadastrar um usuário, identificado pelo seu e-mail, para que tuítes possam ser feitos.
 *  Usuários começam como iniciantes, depois são promovidos a senior e a ninja, em função do número de tuítes.
 *  Existe um tamanho máximo permitido por mensagem (constante TAMANHO_MAXIMO_TUITES).
 *  As mensagens podem conter hashtags (palavras iniciadas por #), que são detectadas automaticamente.
 *  Os tuítes podem conter, além da mensagem de texto, um anexo qualquer.
 *  Há um método para retornar, a qualquer momento, qual a hashtag mais usada em toda a história do sistema.
 */
public class TuiterLite<T> {

    public static final int TAMANHO_MAXIMO_TUITES = 120;
    Map<String,Usuario> usuarioByEmail = new HashMap<>();

    Map<String, Integer> wordCount = new HashMap<>();
    ArrayList<String>auxiliar = new ArrayList<>();





    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * Se o email informado já estiver em uso, não faz nada e retorna null.
     *
     * @param nome  O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) {
        Usuario novoUsuario = new Usuario(nome, email);
            if (this.usuarioByEmail.containsKey(email)) {
                return null;
            }


        usuarioByEmail.put(email,novoUsuario);


        return novoUsuario;
    }

    /**
     * Tuíta algo, retornando o objeto Tuíte criado.
     * Se o tamanho do texto exceder o limite pré-definido, não faz nada e retorna null.
     * Se o usuário não estiver cadastrado, não faz nada e retorna null.
     *
     * @param usuario O autor do tuíte
     * @param texto   O texto desejado
     * @return Um "tuíte", que será devidamente publicado no sistema
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) {
        if (texto.length() > TAMANHO_MAXIMO_TUITES ) {
            return null;
        }
        if(!this.usuarioByEmail.containsKey(usuario.getEmail())) return null;

        Tuite novoTuite = new Tuite(usuario, texto);
        auxiliar.addAll(novoTuite.getHashtags());
        usuario.aumentaContador();
        Usuario.setarUsuario(usuario);
        return novoTuite;
    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     *
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {
        Integer maior = 0;
        String Certa = null;
        for(String auxWord : auxiliar ) {
            Integer count = wordCount.get(auxWord);
            wordCount.put(auxWord,(count==null) ? 1 : count +1);
        }

        for(Map.Entry<String, Integer> entrada : wordCount.entrySet()) {
            String valueWordmap = entrada.getKey();
            Integer c = entrada.getValue();
            if(c == 0) {
                return null;
            }
            else if (maior < c) {
                maior = c;
                Certa = valueWordmap;
            }

        }

        

        return Certa;

    }





}

