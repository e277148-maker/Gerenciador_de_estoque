package controllers;

import org.junit.jupiter.api.Test;
import estoque.Estoque;
import historico.Historico;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SaidaControllerTest {

    @Test
    public void deveInicializarDependenciasDaSaida() {
        SaidaController controller = new SaidaController();
        Estoque estoque = new Estoque(new ArrayList<>(), 1);
        Historico historico = new Historico(new ArrayList<>());
        ControleUsuarios controle = new ControleUsuarios(new ArrayList<>());
        Usuarios usuario = new Usuarios("Gerente", "Teste", "teste", "123");

        // Valida a assinatura do método inicializar do SaidaController[cite: 43]
        assertDoesNotThrow(() -> {
            controller.inicializar(estoque, historico, controle, usuario);
        });
        
        assertNotNull(controller);
    }
}