package produto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void deveCriarProdutoEVerificarAtributos() {
        Produto produto = new Produto("Teclado Mecânico", 15, 1, 5);

        assertEquals("Teclado Mecânico", produto.getNome());
        assertEquals(15, produto.getQuantidade());
        assertEquals(1, produto.getID());
        assertEquals(5, produto.getQuantidadeMinima());
    }

    @Test
    public void deveModificarAtributosDoProduto() {
        Produto produto = new Produto("Memória 8GB", 10, 2, 2);
        
        produto.setNome("Memória 16GB");
        produto.setQuantidade(12);

        assertEquals("Memória 16GB", produto.getNome());
        assertEquals(12, produto.getQuantidade());
    }
}