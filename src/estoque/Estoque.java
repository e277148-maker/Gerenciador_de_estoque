package estoque;

import java.util.List;


import exeções.ProdutoNaoEncontradoException;
import produto.Produto;

public class Estoque {
    private List<Produto> produtos;


    public void entradaProduto(Produto produto, int quantidade){
        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }

    public void saidaProduto(Produto produto, int quantidade){
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }

    public void criarProduto(Produto produto){
        produtos.add(produto);
    }
    
    public Produto buscarProduto(int ID) throws ProdutoNaoEncontradoException{
        for(int i = 0; i < produtos.size(); i++){
            Produto p = produtos.get(i);
            if (ID == p.getID()){
                return p;
            }
        }   
        throw new ProdutoNaoEncontradoException("Produto com ID " + ID + " não encontrado.");
    }

    public void aferirQuantidade(Produto produto){
        if (produto.getQuantidade() < produto.getQuantidadeMinima()){
            System.out.println("Produto abaixo da quantidade minima");
        }
    }
}
