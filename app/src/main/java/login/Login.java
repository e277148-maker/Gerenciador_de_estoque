package login;

import usuarios.Usuarios;

import java.util.List;

public class Login {
    

    public static Usuarios autenticar(String login, String senha, List<Usuarios> usuarios){
        for(Usuarios u : usuarios){
            if(u.getLogin().equals(login) && u.getSenha().equals(senha)){
                return u;
            }
        }
        return null;
    }
}
