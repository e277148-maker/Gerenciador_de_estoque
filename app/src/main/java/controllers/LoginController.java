package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private void entrar() {

        String login = usuarioField.getText();
        String senha = senhaField.getText();

        Usuarios usuario = Login.autenticar(login, senha, controleUsuarios.getUsuarios());

        if (usuario == null) {
            System.out.println("Login inválido");
        } else {
            System.out.println("Bem-vindo " + usuario.getNome());
        }
    }

    public void setControleUsuarios(ControleUsuarios controleUsuarios) {
        this.controleUsuarios = controleUsuarios;
    }
}