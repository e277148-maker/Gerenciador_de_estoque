package usuarios;

import java.io.File;
import java.util.List;

import exeções.ObjetoNaoEncontradoException;

public class ControleUsuarios {
    public List <Usuarios> usuarios;

    public ControleUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
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

        mapper.writeValue(new File("usuarios.json"), usuarios);
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
}
