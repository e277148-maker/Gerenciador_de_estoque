package login;

import usuarios.Usuarios;

import java.util.List;
import java.util.Scanner;

public class Login {
    

    private static Usuarios encontrarUsuario(String login, String senha, List<Usuarios> usuarios){
        for(int i = 0; i < usuarios.size(); i++){
            Usuarios u = usuarios.get(i);
            if(u.getLogin() == login && u.getSenha() == senha){
                return u;
            }
        }
        return null;
    }

    public static Usuarios ExecutarLogin(Scanner scanner, List<Usuarios> usuarios){
        String login = scanner.next();
        String senha = scanner.next();
        Usuarios usuario = encontrarUsuario(login, senha, usuarios);
        if (usuario == null){
            while (usuario == null) {
                System.err.println("Usuario ou senha incorretos");
                System.err.println("Tente novamente");
                login = scanner.next();
                senha = scanner.next();
                usuario = encontrarUsuario(login, senha, usuarios);
            }
        }
        return usuario;
    }
}
