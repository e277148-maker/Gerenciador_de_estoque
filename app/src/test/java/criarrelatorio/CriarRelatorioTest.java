package criarrelatorio;

import estoque.Estoque;
import historico.Historico;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CriarRelatorioTest {

    @Test
    public void deveChamarGeracaoDeRelatorioSemLancarErro() {
        Estoque estoque = new Estoque(new ArrayList<>(), 0);
        Historico historico = new Historico(new ArrayList<>());

        // Aqui o objetivo é apenas garantir que a rotina que captura LocalDate
        // e formata não vai estourar nenhum erro no sistema (Exception)
        assertDoesNotThrow(() -> {
            CriarRelatorio.gerar(estoque, historico);
        });
    }
}