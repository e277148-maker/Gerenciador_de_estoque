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

    public EntradaProduto(Estoque estoque, int quantidade, Produto produto, Usuarios usuario, Historico historico) {
        this.estoque = estoque;
        this.quantidade = quantidade;
        this.produto = produto;
        this.usuario = usuario;
        this.historico = historico;
    }

    @Override
    public void executar(){
        Movimentação entrada_de_produto = new Movimentação("Entrada de produto", quantidade, produto, usuario);
        historico.adicionarMovimentação(entrada_de_produto);
        estoque.entradaProduto(produto, quantidade);
    }
}
