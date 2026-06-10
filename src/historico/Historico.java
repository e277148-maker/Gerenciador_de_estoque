package historico;

import java.util.List;



public class Historico {
    private List<Movimentação> movimentaçoes;

    public void adicionarMovimentação(Movimentação movimentação){
        movimentaçoes.add(movimentação);
    }
}
