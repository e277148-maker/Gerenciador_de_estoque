package controllers;

import java.io.IOException;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.Login;
import usuarios.ControleUsuarios;
import usuarios.Usuarios;

public class LoginController {

    private ControleUsuarios controleUsuarios;

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private Button entrarButton;

    @FXML
    private void entrar() throws IOException{

        String login = usuarioField.getText();
        String senha = senhaField.getText();

        Usuarios usuario = Login.autenticar(login, senha, controleUsuarios.getUsuarios());

        if(usuario != null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));

            Scene scene = new Scene(loader.load());

            MenuController controller = loader.getController();

            controller.inicializar(App.getEstoque(), App.getHistorico(), App.getControleUsuarios(), usuario);

            Stage stage = (Stage) entrarButton.getScene().getWindow();

            stage.setScene(scene);
        }
    }

    public void setControleUsuarios(ControleUsuarios controleUsuarios) {
        this.controleUsuarios = controleUsuarios;
    }
}