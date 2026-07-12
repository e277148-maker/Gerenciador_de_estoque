package usuarios;

import java.io.File;
import java.io.IOException;
import java.util.List;

import exeções.ObjetoNaoEncontradoException;
import com.fasterxml.jackson.databind.ObjectMapper; 

public class ControleUsuarios {
    public List <Usuarios> usuarios;

    public ControleUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public void adicionarUsuario(Usuarios usuario){
        usuarios.add(usuario);
    }

    public Usuarios buscarUsuario(String login) throws ObjetoNaoEncontradoException{
        for (int i = 0; i < usuarios.size(); i++){
            Usuarios usuario = usuarios.get(i);
            if (usuario.getLogin() == login){
                return usuario;
            }
        }
        throw new ObjetoNaoEncontradoException("Usuario não encontrado");
    }


    public void salvarUsuarios(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("usuarios.json"), usuarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os usuários: " + e.getMessage());
        }
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
}
