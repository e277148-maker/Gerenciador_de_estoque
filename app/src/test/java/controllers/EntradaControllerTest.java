package controllers;

import org.junit.jupiter.api.Test;
import estoque.Estoque;
import historico.Historico;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class EntradaControllerTest {

    @Test
    public void deveInicializarDependencias() {
        EntradaController controller = new EntradaController();
        assertDoesNotThrow(() -> {
            controller.inicializar(new Estoque(new ArrayList<>(), 1), new Historico(new ArrayList<>()), new ControleUsuarios(new ArrayList<>()), new Usuarios());
        });
        assertNotNull(controller);
    }
}
