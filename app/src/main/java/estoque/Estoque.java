package estoque;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import exeções.ObjetoNaoEncontradoException;
import produto.Produto;

public class Estoque {
    private List<Produto> produtos;
    private int proximoID;


    public Estoque(List<Produto> produtos, int geradorID) {
        this.produtos = produtos;
        this.proximoID = geradorID;
    }

    public void entradaProduto(Produto produto, int quantidade){
        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }

    public void saidaProduto(Produto produto, int quantidade){
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }

    public void criarProduto(Produto produto){
        produto.setID(proximoID);
        proximoID++;
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

    public void salvarEstoque(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("../dados/estoque.json"), produtos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o estoque: " + e.getMessage());
        }
    }

    public void carregarEstoque() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        produtos = mapper.readValue(new File("../dados/estoque.json"), new TypeReference<List<Produto>>() {});

        proximoID = 1;

        for (Produto p : produtos) {
            if (p.getID() >= proximoID){
                proximoID = p.getID() + 1;
            }
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getproximoID() {
        return proximoID;
    }

    public void setproximoID(int proximoID) {
        this.proximoID = proximoID;
    }
}
