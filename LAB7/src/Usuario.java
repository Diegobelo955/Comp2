import java.awt.*;
import java.util.Objects;

public class Usuario {

    public static final int MIN_TUITES_SENIOR = 200;
    public static final int MIN_TUITES_NINJA = 1000;

    private final String email;
    private final String nome;
    private Image foto;
    private int contadorTuite;

    // Pode ser INICIANTE, SENIOR ou NINJA
    private NivelUsuario nivel;

    public Usuario(String nome, String email) {
        this.email = email;
        this.nome = nome;
        this.nivel = NivelUsuario.INICIANTE;
        this.contadorTuite = 0;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return this.foto;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    public NivelUsuario getNivel() {
        return nivel;
    }

    public void atualizaNivel(NivelUsuario nivelUsuario) {
        this.nivel = nivelUsuario;
    }

    //Contador para saber o número de tuites realizados.

    public int aumentaContador() {
        return this.contadorTuite++;
    }
    public int getContadorTuite() {
        return this.contadorTuite;
    }

    //Método criado para alterar o nível do usuário
    public static void setarUsuario(Usuario usuario) {
        if (usuario.getContadorTuite() < 200 || usuario.getContadorTuite() >= 1000) {
            if (usuario.getContadorTuite() >= 1000) {
                usuario.atualizaNivel(NivelUsuario.NINJA);
            }
        } else {
            usuario.atualizaNivel(NivelUsuario.SENIOR);
        }
    }

    //Override do método equals da classe Object

    @Override
    public boolean equals(Object o1) {
        if(!(o1 instanceof  Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o1;
        return this.getEmail().equals(((Usuario) o1).getEmail());


    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
