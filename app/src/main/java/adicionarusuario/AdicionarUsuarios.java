package adicionarusuario;

import java.util.List;
import java.util.Scanner;

import usuarios.ControleUsuarios;
import usuarios.Usuarios;

public class AdicionarUsuarios {
    public static void adicionar(Scanner scanner, ControleUsuarios controleUsuarios){
        System.out.println("nome: ");
        String nome = scanner.next();
        System.out.println("login: ");
        String login = scanner.next();
        System.out.println("senha: ");
        String senha = scanner.next();
        System.out.println("tipo: ");
        String tipo = scanner.next();
        List<Usuarios> usuarios = controleUsuarios.getUsuarios();
        boolean loginUnico = checarLoginRepetido(login, usuarios);
        if (loginUnico == true){
            Usuarios novoUsuario = new Usuarios(tipo, nome, login, senha);
            controleUsuarios.adicionarUsuario(novoUsuario);
            System.out.println("Usuario inserido no sistema");
        }
        else{
            System.out.println("Login repetido, tente outro");
        }
    }

    private static boolean checarLoginRepetido(String login, List<Usuarios> usuarios){

        for (int i = 0; i < usuarios.size(); i++){
            Usuarios u = usuarios.get(i);
            if(login.equals(u.getLogin())){
                return false;
            }
        }
        return true;
    }
}
