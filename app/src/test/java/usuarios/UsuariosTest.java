package usuarios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuariosTest {

    @Test
    public void deveCriarUsuarioEVerificarAtributos() {
        Usuarios usuario = new Usuarios("Administrador", "Leonardo", "leo.admin", "senhaSegura");

        assertEquals("Administrador", usuario.getTipo());
        assertEquals("Leonardo", usuario.getNome());
        assertEquals("leo.admin", usuario.getLogin());
        assertEquals("senhaSegura", usuario.getSenha());
    }
}