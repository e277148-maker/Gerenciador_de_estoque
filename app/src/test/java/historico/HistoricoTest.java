package historico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import usuarios.Usuarios;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HistoricoTest {

    private Historico historico;
    private Movimentação mov1;

    @BeforeEach
    public void setUp() {
        historico = new Historico(new ArrayList<>());
        Produto fonte = new Produto("Fonte ATX", 5, 1, 2);
        Usuarios user = new Usuarios("Tecnico", "Ana", "ana", "senha");
        
        mov1 = new Movimentação("Entrada de produto", 10, fonte, user);
        historico.adicionarMovimentação(mov1);
    }

    @Test
    public void deveBuscarMovimentacaoPorQuantidade() {
        List<Movimentação> resultado = historico.buscarMovimentaçãoQuantidade(10);
        assertEquals(1, resultado.size());
        assertEquals(10, resultado.get(0).getQuantidade());
    }

    @Test
    public void deveSalvarHistoricoSemErros() {
        // Valida se o bloco try-catch do ObjectMapper que salva o JSON na pasta ../dados/ executa adequadamente[cite: 29]
        assertDoesNotThrow(() -> {
            historico.salvarHistorico();
        });
    }
}