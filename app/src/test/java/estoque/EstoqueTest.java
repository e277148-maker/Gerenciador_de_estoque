package estoque;

import exeções.ObjetoNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class EstoqueTest {

    private Estoque estoque;

    @BeforeEach
    public void setUp() {
        // Roda antes de cada teste para garantir um estoque limpo
        estoque = new Estoque(new ArrayList<>(), 0);
    }

    @Test
    public void deveCriarProdutoEGerarId() {
        Produto placaMae = new Produto("Placa Mãe B450", 5, 0, 2);
        estoque.criarProduto(placaMae);

        assertEquals(1, estoque.getProdutos().size());
        assertEquals(1, placaMae.getID()); // O ID deve ter sido gerado
    }

    @Test
    public void deveDarEntradaEmProduto() throws ObjetoNaoEncontradoException {
        Produto ssd = new Produto("SSD M.2 512GB", 10, 0, 5);
        estoque.criarProduto(ssd);
        
        estoque.entradaProduto(ssd, 15);
        
        assertEquals(25, ssd.getQuantidade());
    }

    @Test
    public void deveDarSaidaEmProduto() {
        Produto ram = new Produto("Memória RAM 16GB", 20, 0, 4);
        estoque.criarProduto(ram);
        
        estoque.saidaProduto(ram, 5);
        
        assertEquals(15, ram.getQuantidade());
    }

    @Test
    public void deveLancarExcecaoAoBuscarProdutoInexistente() {
        // AssertThrows verifica se a sua exceção ObjetoNaoEncontradoException foi disparada
        assertThrows(ObjetoNaoEncontradoException.class, () -> {
            estoque.buscarProduto(999);
        });
    }
}