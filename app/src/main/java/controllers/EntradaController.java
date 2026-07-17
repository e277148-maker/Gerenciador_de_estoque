package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import produto.Produto;

import java.io.IOException;

import comandos.EntradaProduto;
import estoque.Estoque;
import exeções.ObjetoNaoEncontradoException;
import historico.Historico;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;

public class EntradaController {

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private Label lblMensagem;

    private Estoque estoque;
    private Historico historico;
    private ControleUsuarios controleUsuarios;
    private Usuarios usuario;

    public void inicializar(Estoque estoque, Historico historico, ControleUsuarios controleUsuarios, Usuarios usuario){

        this.estoque = estoque;
        this.historico = historico;
        this.controleUsuarios = controleUsuarios;
        this.usuario = usuario;
    }

    @FXML
    private void confirmar() {

        int id = Integer.parseInt(txtID.getText());
        int quantidade = Integer.parseInt(txtQuantidade.getText());

        try {
            Produto produto = estoque.buscarProduto(id);

            EntradaProduto comando = new EntradaProduto(estoque, quantidade, produto, usuario, historico);

            comando.executar();

            lblMensagem.setText("Entrada realizada com sucesso.");

            txtID.clear();
            txtQuantidade.clear();
            txtID.requestFocus();

        } catch (ObjetoNaoEncontradoException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
private void voltar() throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));

    Scene scene = new Scene(loader.load());

    MenuController controller = loader.getController();

    controller.inicializar(estoque, historico, controleUsuarios, usuario
    );

    Stage stage = (Stage) txtID.getScene().getWindow();

    stage.setScene(scene);
}
}