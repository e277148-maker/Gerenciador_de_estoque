package controllers;

import java.io.IOException;

import estoque.Estoque;
import exeções.ObjetoNaoEncontradoException;
import historico.Historico;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import produto.Produto;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;

public class ConsultaController {
    
    @FXML
    private TextField txtID;

    @FXML
    private Button btnConsultar;

    @FXML
    private Label lblProduto;

    @FXML
    private Label lblQuantidade;

    @FXML
    private Label lblQuantidadeMin;

    @FXML
    private Label lblMensagem;

    @FXML
    private Button lblVoltar;

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
    private void consultar() {

        int id = Integer.parseInt(txtID.getText());

        try {

            Produto produto = estoque.buscarProduto(id);

            lblProduto.setText("Produto: " + produto.getNome());
            lblQuantidade.setText("Quantidade: " + produto.getQuantidade());
            lblQuantidadeMin.setText("Quantidade mínima: " + produto.getQuantidadeMinima());

            lblMensagem.setText("");

        } catch (ObjetoNaoEncontradoException e) {

            lblMensagem.setText(e.getMessage());

        }
    }

    @FXML
    private void voltar() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));

        Scene scene = new Scene(loader.load());

        MenuController controller = loader.getController();

        controller.inicializar(estoque, historico, controleUsuarios, usuario);

        Stage stage = (Stage) txtID.getScene().getWindow();

        stage.setScene(scene);
    }

}
