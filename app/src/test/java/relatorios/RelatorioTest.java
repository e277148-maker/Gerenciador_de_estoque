package relatorios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RelatorioTest {

    @Test
    public void deveInstanciarRelatorio() {
        // Cobre o construtor padrão da classe vazia
        Relatorio r = new Relatorio();
        assertNotNull(r);
    }
}
