package usuarios;

import java.io.File;
import java.util.List;

public class ControleUsuarios {
    public List <Usuarios> usuarios;

    public void salvarUsuarios(){
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File("usuarios.json"), usuarios);
    }
}
