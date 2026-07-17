package app;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controllers.LoginController;
import estoque.Estoque;
import historico.Historico;
import historico.Movimentação;
import produto.Produto;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;

public class App  extends Application{

    private static Estoque estoque;
    private static Historico historico;
    private static ControleUsuarios controleUsuarios;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        List<Produto> produtos = new ArrayList<>();
        estoque = new Estoque(produtos, 1);
        estoque.carregarEstoque();

        List<Movimentação> movimentacoes = new ArrayList<>();
        historico = new Historico(movimentacoes);
        historico.carregarHistorico();

        List<Usuarios> usuarios = new ArrayList<>();
        controleUsuarios = new ControleUsuarios(usuarios);
        controleUsuarios.carregarUsuarios();

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

    public static Estoque getEstoque() {
        return estoque;
    }

    public static Historico getHistorico() {
        return historico;
    }

    public static ControleUsuarios getControleUsuarios() {
        return controleUsuarios;
    }
}