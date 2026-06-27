package comandos;

import produto.Produto;
import usuarios.Usuarios;
import estoque.Estoque;
import historico.Historico;
import historico.Movimentação;


public class EntradaProduto implements Comandos{
    private Estoque estoque;
    private int quantidade;
    private Produto produto;
    private Usuarios usuario;
    private Historico historico;

    @Override
    public void executar(){
        Movimentação entrada_de_produto = new Movimentação("Entrada de produto", quantidade, produto, usuario);
        historico.adicionarMovimentação(entrada_de_produto);
        estoque.entradaProduto(produto, quantidade);
    }
}
