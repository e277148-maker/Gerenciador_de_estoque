package estoque;

import java.util.List;


import exeções.ObjetoNaoEncontradoException;
import produto.Produto;

public class Estoque {
    private List<Produto> produtos;
    private int geradorID;


    public Estoque(List<Produto> produtos, int geradorID) {
        this.produtos = produtos;
        this.geradorID = geradorID;
    }

    public void entradaProduto(Produto produto, int quantidade){
        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }

    public void saidaProduto(Produto produto, int quantidade){
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }

    public void criarProduto(Produto produto){
        geradorID++;
        produto.setID(geradorID);
        produtos.add(produto);
    }
    
    public Produto buscarProduto(int ID) throws ObjetoNaoEncontradoException{
        for(int i = 0; i < produtos.size(); i++){
            Produto p = produtos.get(i);
            if (ID == p.getID()){
                return p;
            }
        }   
        throw new ObjetoNaoEncontradoException("Produto com ID " + ID + " não encontrado.");
    }

    public void aferirQuantidade(Produto produto){
        if (produto.getQuantidade() < produto.getQuantidadeMinima()){
            System.out.println("Produto abaixo da quantidade minima");
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getGeradorID() {
        return geradorID;
    }

    public void setGeradorID(int geradorID) {
        this.geradorID = geradorID;
    }
}
