package adicionarusuario;

import org.junit.jupiter.api.Test;
import usuarios.ControleUsuarios;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class AdicionarUsuariosTest {

    @Test
    public void deveAdicionarUsuarioViaScanner() {
        ControleUsuarios controle = new ControleUsuarios(new ArrayList<>());
        
        // Simulando o que o usuário digitaria no terminal, separado por espaços
        // Ordem esperada no seu código: nome -> login -> senha -> tipo
        String inputSimulado = "Marcos marcos.tec 1234 Tecnico";
        ByteArrayInputStream in = new ByteArrayInputStream(inputSimulado.getBytes());
        Scanner scannerFake = new Scanner(in);

        // Executa o método injetando o Scanner falso
        AdicionarUsuarios.adicionar(scannerFake, controle);

        // Verifica se o usuário foi salvo na lista
        assertEquals(1, controle.getUsuarios().size());
        assertEquals("Marcos", controle.getUsuarios().get(0).getNome());
        assertEquals("marcos.tec", controle.getUsuarios().get(0).getLogin());
    }

    @Test
    public void naoDevePermitirLoginRepetido() {
        ControleUsuarios controle = new ControleUsuarios(new ArrayList<>());
        // Adiciona um usuário pré-existente
        controle.adicionarUsuario(new usuarios.Usuarios("Admin", "Admin", "admin.tec", "000"));
        
        // Tenta adicionar um novo usuário com o MESMO login ("admin.tec")
        String inputSimulado = "NovoNome admin.tec 1234 Tecnico";
        Scanner scannerFake = new Scanner(new ByteArrayInputStream(inputSimulado.getBytes()));

        AdicionarUsuarios.adicionar(scannerFake, controle);

        // A lista deve continuar com tamanho 1, pois o repetido foi barrado
        assertEquals(1, controle.getUsuarios().size());
        assertEquals("Admin", controle.getUsuarios().get(0).getNome()); // Garante que é o original
    }
}
