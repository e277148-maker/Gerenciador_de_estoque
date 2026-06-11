package estoque;

import java.util.List;


import exeções.ProdutoNaoEncontradoException;
import observer.Observer;
import produto.Produto;

public class Estoque implements Observer{
    private List<Produto> produtos;


    public void entradaProduto(Produto p, int quantidade){
        p.setQuantidade(p.getQuantidade() + quantidade);
    }

    public void saidaProduto(Produto p, int quantidade){
        p.setQuantidade(p.getQuantidade() - quantidade);
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

    public void atualizar(Produto produto){
        if (produto.getQuantidade() < produto.getQuantidadeMinima()){
            System.out.println("Produto abaixo da quantidade minima");
        }
    }
}
