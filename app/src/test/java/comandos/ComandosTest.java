package comandos;

import estoque.Estoque;
import historico.Historico;
import historico.Movimentação;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import usuarios.Usuarios;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ComandosTest {

    private Estoque estoque;
    private Historico historico;
    private Usuarios usuarioLogado;
    private Produto telaNotebook;

    @BeforeEach
    public void setUp() {
        estoque = new Estoque(new ArrayList<>(), 0);
        historico = new Historico(new ArrayList<>());
        usuarioLogado = new Usuarios("Tecnico", "Carlos", "carlos.tec", "123");
        
        telaNotebook = new Produto("Tela 15.6 LED", 10, 0, 2);
        estoque.criarProduto(telaNotebook);
    }

    @Test
    public void comandoEntradaDeveAtualizarEstoqueEGerarHistorico() {
        EntradaProduto entrada = new EntradaProduto(estoque, 5, telaNotebook, usuarioLogado, historico);
        entrada.executar();

        // 1. Verifica se o estoque subiu de 10 para 15
        assertEquals(15, telaNotebook.getQuantidade());
        
        // 2. Verifica se gerou o registro no histórico
        assertEquals(1, historico.getMovimentaçoes().size());
        Movimentação mov = historico.getMovimentaçoes().get(0);
        assertEquals("Entrada de produto", mov.getTipo());
        assertEquals(5, mov.getQuantidade());
    }

    @Test
    public void comandoSaidaDeveAtualizarEstoqueEGerarHistorico() {
        SaidaProduto saida = new SaidaProduto(estoque, 3, telaNotebook, usuarioLogado, historico);
        saida.executar();

        assertEquals(7, telaNotebook.getQuantidade());
        assertEquals(1, historico.getMovimentaçoes().size());
        assertEquals("Saída de produto", historico.getMovimentaçoes().get(0).getTipo());
    }
}
