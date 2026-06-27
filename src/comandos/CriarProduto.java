package comandos;

import estoque.Estoque;
import historico.Historico;
import historico.Movimentação;
import produto.Produto;
import usuarios.Usuarios;

public class CriarProduto implements Comandos {
    private Estoque estoque;
    private Produto produto;
    private Usuarios usuario;
    private Historico historico;

    @Override
    public void executar(){
        Movimentação produtoNovo = new Movimentação("Criação de produto", produto.getQuantidade(), produto, usuario);
        historico.adicionarMovimentação(produtoNovo);
        estoque.criarProduto(produto);
    }
}
