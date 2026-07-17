package comandos;

import usuarios.ControleUsuarios;
import usuarios.Usuarios;

public class CriarUsuario  implements Comandos{

    private Usuarios usuario;
    private ControleUsuarios controleUsuario;



    public CriarUsuario(Usuarios usuario, ControleUsuarios controleUsuario) {
        this.usuario = usuario;
        this.controleUsuario = controleUsuario;
    }

    @Override
    public void executar(){
        controleUsuario.adicionarUsuario(usuario);
        controleUsuario.salvarUsuarios();
    }
    
     
}
