package relatorios;

import org.junit.jupiter.api.Test;
import estoque.Estoque;
import historico.Historico;
import produto.Produto;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class RelatorioTest {

    @Test
    public void deveGerarRelatorioTXT() {
        // Cria um ambiente simulado com um produto
        Estoque estoque = new Estoque(new ArrayList<>(), 1);
        Produto p = new Produto("Teclado", 10, 1, 5);
        estoque.criarProduto(p);
        
        Historico historico = new Historico(new ArrayList<>());

        // Valida se o File e o PrintWriter conseguem formatar os dados e criar o arquivo .txt na pasta relatorios[cite: 33]
        assertDoesNotThrow(() -> {
            Relatorio.gerarRelatorioEstoque(estoque, "teste_relatorio_automatizado", historico);
        });
    }
}