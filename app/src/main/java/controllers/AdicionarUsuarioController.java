package controllers;

import java.io.IOException;

import comandos.CriarUsuario;
import estoque.Estoque;
import historico.Historico;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;

public class AdicionarUsuarioController {
        @FXML
        private TextField txtNome;

        @FXML
        private TextField txtLogin;

        @FXML
        private TextField txtSenha;

        @FXML
        private Button btnAdministrador;

        @FXML
        private Button btnGerente;

        @FXML
        private Button btnCriar;

        @FXML
        private Label lblMensagem;

        @FXML
        private Button btnVoltar;

        private Estoque estoque;
        private Historico historico;
        private ControleUsuarios controleUsuarios;
        private Usuarios usuario;
        private String tipo;

    public void inicializar(Estoque estoque, Historico historico, ControleUsuarios controleUsuarios, Usuarios usuario){

        this.estoque = estoque;
        this.historico = historico;
        this.controleUsuarios = controleUsuarios;
        this.usuario = usuario;
    }

    @FXML
    private void selecionarAdministrador(){
        this.tipo = "Administrador";
    }

    @FXML
    private void selecionarGerente(){
        this.tipo = "Gerente";
    }

    @FXML
    private void criar() {
        String nome = txtNome.getText();
        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        if (nome.isBlank() || login.isBlank() || senha.isBlank()) {
            lblMensagem.setText("Preencha todos os campos.");
            return;
        }

        if (tipo == null) {
            lblMensagem.setText("Selecione o tipo de usuário.");
            return;
        }

        Usuarios novoUsuario = new Usuarios(tipo, nome, login, senha);

        CriarUsuario comando = new CriarUsuario(novoUsuario, controleUsuarios);
        comando.executar();

        lblMensagem.setText("Usuário criado com sucesso.");
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
