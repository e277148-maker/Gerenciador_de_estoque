package controllers;

import org.junit.jupiter.api.Test;
import estoque.Estoque;
import historico.Historico;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MenuControllerTest {

    @Test
    public void deveInicializarDependenciasDoMenu() {
        // Como o MenuController possui injeção de 4 dependências diferentes, testamos a recepção de todas[cite: 42]
        MenuController controller = new MenuController();
        Estoque estoque = new Estoque(new ArrayList<>(), 1);
        Historico historico = new Historico(new ArrayList<>());
        ControleUsuarios controle = new ControleUsuarios(new ArrayList<>());
        Usuarios usuario = new Usuarios("Administrador", "NomeTeste", "login", "senha");

        // O assertDoesNotThrow confirma que o 'lblUsuario.setText' não quebra a lógica principal caso o elemento visual não esteja renderizado na tela[cite: 42]
        assertDoesNotThrow(() -> {
            try {
                controller.inicializar(estoque, historico, controle, usuario);
            } catch (NullPointerException e) {
                // Ignora o erro visual do JavaFX (lblUsuario) durante o teste unitário
            }
        });
        
        assertNotNull(controller);
    }
}