package comandos;

import estoque.Estoque;
import historico.Historico;
import historico.Movimentação;
import produto.Produto;
import usuarios.Usuarios;

public class SaidaProduto implements Comandos {
    private Estoque estoque;
    private int quantidade;
    private Produto produto;
    private Usuarios usuario;
    private Historico historico;

    @Override
    public void executar(){
        if(quantidade < produto.getQuantidade()){
            Movimentação entrada_de_produto = new Movimentação("Saída de produto", quantidade, produto, usuario);
            historico.adicionarMovimentação(entrada_de_produto);
            estoque.saidaProduto(produto, quantidade);    
        }
        else{
            System.out.println("Produto em quantidade insuficiente");
        }
    }
}