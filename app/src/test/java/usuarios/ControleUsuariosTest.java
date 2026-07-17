package usuarios;

import exeções.ObjetoNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ControleUsuariosTest {

    private ControleUsuarios controle;

    @BeforeEach
    public void setUp() {
        controle = new ControleUsuarios(new ArrayList<>());
    }

    @Test
    public void deveAdicionarEBuscarUsuarioComSucesso() throws ObjetoNaoEncontradoException {
        Usuarios admin = new Usuarios("Admin", "Leonardo", "leo.admin", "senha123");
        controle.adicionarUsuario(admin);

        Usuarios usuarioEncontrado = controle.buscarUsuario("leo.admin");
        
        assertNotNull(usuarioEncontrado);
        assertEquals("Leonardo", usuarioEncontrado.getNome());
    }

    @Test
    public void deveLancarExcecaoAoBuscarUsuarioInexistente() {
        assertThrows(ObjetoNaoEncontradoException.class, () -> {
            controle.buscarUsuario("usuario.fantasma");
        });
    }
}