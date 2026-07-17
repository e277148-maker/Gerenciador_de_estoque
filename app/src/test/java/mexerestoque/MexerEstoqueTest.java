package mexerestoque;

import estoque.Estoque;
import historico.Historico;
import org.junit.jupiter.api.Test;
import usuarios.Usuarios;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class MexerEstoqueTest {

    @Test
    public void deveIniciarESairDoMenuDeEstoque() {
        Estoque estoque = new Estoque(new ArrayList<>(), 0);
        Historico historico = new Historico(new ArrayList<>());
        Usuarios usuario = new Usuarios("Admin", "Leonardo", "leo", "123");

        // Simula o usuário abrindo o menu e já escolhendo a opção de sair para não travar o loop
        String inputSimulado = "terminar\n";
        Scanner scannerFake = new Scanner(new ByteArrayInputStream(inputSimulado.getBytes()));

        // Se o método executar e encerrar corretamente, o teste passa!
        MexerEstoque.alterarEstoque(scannerFake, estoque, historico, usuario);
        
        assertNotNull(estoque);
    }
}
