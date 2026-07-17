package controllers;

import java.io.IOException;

import comandos.CriarProduto;
import estoque.Estoque;
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

public class AdicionarProdutoController {
    
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtQuantidadeMin;

    @FXML
    private Button btnAdicionar ;

    @FXML
    private Label lblMensagem;

    @FXML
    private Button btnVoltar;


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
    private void adicionar() {

        if (txtNome.getText().isBlank() || txtQuantidade.getText().isBlank() || txtQuantidadeMin.getText().isBlank()) {
            lblMensagem.setText("Preencha todos os campos.");
            return;
        }        
        
        try {
            String nome = txtNome.getText();
            int Quantidade = Integer.parseInt(txtQuantidade.getText());
            int QuantidadeMin = Integer.parseInt(txtQuantidadeMin.getText());

            Produto produto = new Produto(nome, Quantidade, 0, QuantidadeMin);
            CriarProduto comando = new CriarProduto(estoque, produto, usuario, historico);
            comando.executar();
            lblMensagem.setText("Produto adicionado com sucesso");

        } catch (NumberFormatException e) {
            lblMensagem.setText("Quantidade inválida.");
        }
    }

    @FXML
    private void voltar() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));

        Scene scene = new Scene(loader.load());

        MenuController controller = loader.getController();

        controller.inicializar(estoque, historico, controleUsuarios, usuario);

        Stage stage = (Stage) txtNome.getScene().getWindow();

        stage.setScene(scene);
    }
}
