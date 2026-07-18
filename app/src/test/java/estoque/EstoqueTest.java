package estoque;

import exeções.ObjetoNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class EstoqueTest {

    private Estoque estoque;
    private Produto ssd;

    @BeforeEach
    public void setUp() {
        estoque = new Estoque(new ArrayList<>(), 1);
        ssd = new Produto("SSD NVMe 1TB", 10, 0, 5);
        estoque.criarProduto(ssd);
    }

    @Test
    public void deveCriarProdutoEIncrementarProximoID() {
        // O proximoID começa em 1. Após criar o SSD, o ID do SSD deve ser 1 e o proximoID deve ir para 2.
        assertEquals(1, ssd.getID());
        assertEquals(2, estoque.getproximoID());
    }

    @Test
    public void deveEncontrarProdutoPorID() throws ObjetoNaoEncontradoException {
        Produto encontrado = estoque.buscarProduto(1);
        assertEquals("SSD NVMe 1TB", encontrado.getNome());
    }

    @Test
    public void deveLancarExcecaoParaIDNaoExistente() {
        assertThrows(ObjetoNaoEncontradoException.class, () -> {
            estoque.buscarProduto(99);
        });
    }

    @Test
    public void deveSalvarEstoqueSemErros() {
        // Valida se o ObjectMapper consegue executar o salvamento na pasta ../dados/ sem travar o sistema
        assertDoesNotThrow(() -> {
            estoque.salvarEstoque();
        });
    }
}