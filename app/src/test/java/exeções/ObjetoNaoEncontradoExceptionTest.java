package exeções;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObjetoNaoEncontradoExceptionTest {

    @Test
    public void deveLancarExcecaoComMensagemCorreta() {
        String mensagemErro = "Produto não existe no banco";
        
        ObjetoNaoEncontradoException excecao = new ObjetoNaoEncontradoException(mensagemErro);
        
        assertEquals(mensagemErro, excecao.getMessage());
    }
}