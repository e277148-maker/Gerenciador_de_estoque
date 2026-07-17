package controllers;

import java.io.IOException;
import java.util.List;

import estoque.Estoque;
import historico.Historico;
import historico.Movimentação;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;

public class ConsultaHistoricoController {

    @FXML
    private TextField txtID;

    @FXML
    private Button btnConsultar;

    @FXML
private ListView<String> listaHistorico;
    

    @FXML
    private Label lblMensagem;

    @FXML
    private Button btnVoltar;

    private Historico historico;
    private Estoque estoque;
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
        listaHistorico.getItems().clear();
        int id = Integer.parseInt(txtID.getText());
        List<Movimentação> lista = historico.buscarMovimentaçãoProduto(id);

        if(lista.isEmpty()){
            listaHistorico.getItems().add("Nenhuma movimentação encontrada.");
            return;
        }

        for(Movimentação m : lista){
            listaHistorico.getItems().add(m.getTipo() + " | Quantidade: " + m.getQuantidade() + " | Data: " + m.getData() + " | Usuário: " + m.getUsuario().getLogin());
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
