package controllers;

import org.junit.jupiter.api.Test;
import estoque.Estoque;
import historico.Historico;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AdicionarProdutoControllerTest {

    @Test
    public void deveInicializarDependencias() {
        AdicionarProdutoController controller = new AdicionarProdutoController();
        Estoque estoque = new Estoque(new ArrayList<>(), 1);
        Historico historico = new Historico(new ArrayList<>());
        ControleUsuarios controle = new ControleUsuarios(new ArrayList<>());
        Usuarios usuario = new Usuarios("Administrador", "Leo", "leo", "senha");

        assertDoesNotThrow(() -> {
            controller.inicializar(estoque, historico, controle, usuario);
        });
        assertNotNull(controller);
    }
}