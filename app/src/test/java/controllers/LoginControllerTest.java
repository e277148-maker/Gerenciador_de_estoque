package controllers;

import org.junit.jupiter.api.Test;
import usuarios.ControleUsuarios;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    @Test
    public void deveInjetarDependenciaDeControleDeUsuarios() {
        LoginController controller = new LoginController();
        ControleUsuarios controle = new ControleUsuarios(new ArrayList<>());
        
        // Garante que o método inicializar não gera exceções ao receber os dados[cite: 41]
        assertDoesNotThrow(() -> {
            controller.inicializar(controle);
        });
        
        assertNotNull(controller);
    }
}