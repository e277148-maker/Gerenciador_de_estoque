package historico;

import org.junit.jupiter.api.Test;
import produto.Produto;
import usuarios.Usuarios;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class MovimentacaoTest {

    @Test
    public void deveCriarMovimentacaoComDataDeHoje() {
        Produto hd = new Produto("HD 1TB", 5, 1, 2);
        Usuarios tecnico = new Usuarios("Tecnico", "Carlos", "carlos", "123");

        Movimentação mov = new Movimentação("Saída", 2, hd, tecnico);

        assertEquals("Saída", mov.getTipo());
        assertEquals(2, mov.getQuantidade());
        assertEquals(hd, mov.getProduto());
        assertEquals(tecnico, mov.getUsuario());
        
        // Valida se a data automática gerada no construtor é exatamente o dia de hoje
        assertEquals(LocalDate.now(), mov.getData());
    }
}