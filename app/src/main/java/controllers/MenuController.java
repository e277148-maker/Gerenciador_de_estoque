package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import relatorios.Relatorio;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import app.App;
import estoque.Estoque;
import historico.Historico;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;

public class MenuController {

    @FXML
    private Label lblUsuario;

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

        lblUsuario.setText("Bem-vindo, " + usuario.getNome());
    }

    @FXML
    private void abrirEntrada() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/entrada.fxml"));
        Scene scene = new Scene(loader.load());
        EntradaController controller = loader.getController();
        controller.inicializar(estoque, historico, controleUsuarios, usuario);
        Stage stage = (Stage) lblUsuario.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void abrirSaida() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/saida.fxml"));
        Scene scene = new Scene(loader.load());
        SaidaController controller = loader.getController();
        controller.inicializar(estoque, historico, controleUsuarios, usuario);
        Stage stage = (Stage) lblUsuario.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void abrirConsulta() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/consultarEstoque.fxml"));
        Scene scene = new Scene(loader.load());
        ConsultaController controller = loader.getController();
        controller.inicializar(estoque, historico, controleUsuarios, usuario);
        Stage stage = (Stage) lblUsuario.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void abrirHistorico() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/consultarHistorico.fxml"));
        Scene scene = new Scene(loader.load());
        ConsultaHistoricoController controller = loader.getController();
        controller.inicializar(estoque, historico, controleUsuarios, usuario);
        Stage stage = (Stage) lblUsuario.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void adicionarUsuario() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/adicionarUsuario.fxml"));
        Scene scene = new Scene(loader.load());
        AdicionarUsuarioController controller = loader.getController();
        controller.inicializar(estoque, historico, controleUsuarios, usuario);
        Stage stage = (Stage) lblUsuario.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void adicionarProduto() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/adicionarProduto.fxml"));
        Scene scene = new Scene(loader.load());
        AdicionarProdutoController controller = loader.getController();
        controller.inicializar(estoque, historico, controleUsuarios, usuario);
        Stage stage = (Stage) lblUsuario.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void gerarRelatorio(){
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String data = hoje.format(formato);

        String nomeRelatorio = "relatorio-" + data;
        
        Relatorio.gerarRelatorioEstoque(estoque, nomeRelatorio, historico);

        lblMensagem.setText("Relatório gerado com sucesso");
    }

    @FXML
    private void sair() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Scene scene = new Scene(loader.load());
        LoginController controller = loader.getController();
        controller.inicializar(App.getControleUsuarios());
        Stage stage = (Stage) lblUsuario.getScene().getWindow();
        stage.setScene(scene);
    }
}