import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import estoque.Estoque;
import historico.Historico;
import historico.Movimentação;
import produto.Produto;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;
import login.Login;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Criat estoque, historico e scanner

        List<Produto> produtos = new ArrayList<>();
        Estoque estoque = new Estoque(produtos);

        List<Movimentação> movimentaçoes = new ArrayList<>();
        Historico historico = new Historico(movimentaçoes);

        List<Usuarios> usuarios = new ArrayList<>();
        ControleUsuarios controleUsuarios = new ControleUsuarios(usuarios);

        Scanner scanner = new Scanner(System.in);


        // Login
        Usuarios usuario = Login.ExecutarLogin(scanner, controleUsuarios.getUsuarios());

        String escolha = scanner.next();
        if (escolha == "mexer estoque"){
            
        }
    }
}
