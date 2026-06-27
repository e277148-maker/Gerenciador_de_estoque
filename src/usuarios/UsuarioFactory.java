package usuarios;

public class UsuarioFactory {
    
    public Usuarios criarUsuario(String tipo, String nome, String login, String senha) {

        switch(tipo) {
            case "ADMINISTRADOR":
                return new Administrador(nome, login, senha);

            case "GERENTE":
                return  new Gerente(nome, login, senha);

            default:
                throw new IllegalArgumentException (
                    "Tipo de usuário inválido"
                );
        }
    }
}
