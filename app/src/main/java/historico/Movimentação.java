package historico;

import java.time.LocalDate;

import produto.Produto;
import usuarios.Usuarios;

public class Movimentação {
    private String tipo;
    private int quantidade;
    private LocalDate data;
    private Produto produto;
    private Usuarios usuario;


    public Movimentação(String tipo, int quantidade, Produto produto, Usuarios usuario) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = LocalDate.now();
        this.produto = produto;
        this.usuario = usuario;
    }

    public Movimentação() {
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }


    public Produto getProduto() {
        return produto;
    }


    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public Usuarios getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
