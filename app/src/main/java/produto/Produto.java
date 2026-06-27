package produto;

public class Produto {
    private String nome;
    private int quantidade;
    private int ID;
    private int quantidadeMinima;

    public Produto(String nome, int quantidade, int iD, int quantidadeMinima) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.ID = iD;
        this.quantidadeMinima = quantidadeMinima;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }
    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }
}
