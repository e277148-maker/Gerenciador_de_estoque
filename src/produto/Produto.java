package produto;
public class Produto {
    private String nome;
    private int quantidade;
    private int ID;
    public Produto(String nome, int quantidade, int iD) {
        this.nome = nome;
        this.quantidade = quantidade;
        ID = iD;
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
}
