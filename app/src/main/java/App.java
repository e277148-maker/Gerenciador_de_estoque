import java.util.ArrayList;
import java.util.List;

import estoque.Estoque;
import historico.Historico;
import historico.Movimentação;
import produto.Produto;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Criat estoque e historico

        List<Produto> produtos = new ArrayList<>();
        Estoque estoque = new Estoque(produtos);

        List<Movimentação> movimentaçoes = new ArrayList<>();
        Historico historico = new Historico(movimentaçoes);

        

    }
}
