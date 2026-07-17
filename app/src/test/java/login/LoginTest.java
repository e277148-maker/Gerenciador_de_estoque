package login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usuarios.Usuarios;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private List<Usuarios> bancoDeUsuarios;

    @BeforeEach
    public void setUp() {
        bancoDeUsuarios = new ArrayList<>();
        bancoDeUsuarios.add(new Usuarios("Tecnico", "Ana", "ana.tec", "senha123"));
    }

    @Test
    public void deveAutenticarComCredenciaisCorretas() {
        Usuarios logado = Login.autenticar("ana.tec", "senha123", bancoDeUsuarios);
        
        assertNotNull(logado);
        assertEquals("Ana", logado.getNome());
    }

    @Test
    public void naoDeveAutenticarComSenhaIncorreta() {
        Usuarios logado = Login.autenticar("ana.tec", "senhaErrada", bancoDeUsuarios);
        
        assertNull(logado);
    }

    @Test
    public void naoDeveAutenticarUsuarioInexistente() {
        Usuarios logado = Login.autenticar("usuario.fantasma", "senha123", bancoDeUsuarios);
        
        assertNull(logado);
    }
}