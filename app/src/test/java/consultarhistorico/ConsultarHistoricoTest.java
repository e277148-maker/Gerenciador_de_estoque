package consultarhistorico;

import historico.Historico;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class ConsultarHistoricoTest {

    @Test
    public void deveIniciarESairDoMenuDeHistorico() {
        Historico historico = new Historico(new ArrayList<>());

        String inputSimulado = "sair\n";
        Scanner scannerFake = new Scanner(new ByteArrayInputStream(inputSimulado.getBytes()));

        ConsultarHistorico.consultar(scannerFake, historico);
        
        assertNotNull(historico);
    }
}
