
package app;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controllers.LoginController;
import estoque.Estoque;
import historico.Historico;
import historico.Movimentação;
import produto.Produto;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;
import login.Login;


public class App {

    public static void main(String[] args) throws Exception {

        // Criar estoque, historico e scanner

        List<Produto> produtos = new ArrayList<>();
        Estoque estoque = new Estoque(produtos, 1);

        List<Movimentação> movimentaçoes = new ArrayList<>();
        Historico historico = new Historico(movimentaçoes);

        List<Usuarios> usuarios = new ArrayList<>();
        ControleUsuarios controleUsuarios = new ControleUsuarios(usuarios);


        Scanner scanner = new Scanner(System.in);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));

        Scene scene = new Scene(loader.load());

        // Recupera o controller criado pelo FXMLLoader
        LoginController controller = loader.getController();

        // Passa o ControleUsuarios para ele
        controller.setControleUsuarios(controleUsuarios);

        stage.setTitle("Gerenciador de Estoque");
        stage.setScene(scene);
        stage.show();
    }


        // Login
        Usuarios usuario = Login.ExecutarLogin(scanner, controleUsuarios.getUsuarios());
        // Gerenciamento do estoque

        String escolha = scanner.nextLine();
        if ("mexer estoque".equals(escolha)){
            MexerEstoque.alterarEstoque(scanner, estoque, historico, usuario);
        }
        if ("Ver historico".equals(escolha)){
            ConsultarHistorico.consultar(scanner, historico);
        }
        if ("Adicionar usuario".equals(escolha)){
            AdicionarUsuarios.adicionar(scanner, controleUsuarios);
        }
    }
}