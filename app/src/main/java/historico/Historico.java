package historico;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import produto.Produto;
import usuarios.Usuarios;



public class Historico {
    private List<Movimentação> movimentaçoes;

    public Historico(List<Movimentação> movimentaçoes) {
        this.movimentaçoes = movimentaçoes;
    }

    public void adicionarMovimentação(Movimentação movimentação){
        movimentaçoes.add(movimentação);
    }

    public void removerMovimentação(Movimentação movimentação){
        for(int i = 0; i < movimentaçoes.size(); i++){
            if(movimentaçoes.get(i) == movimentação){
                movimentaçoes.remove(i);
            }
        }
    }

    public List <Movimentação> buscarMovimentação(Produto produto){
        List<Movimentação> m = new ArrayList<>();
        for (int i = 0; i < movimentaçoes.size(); i++){
            Produto p = movimentaçoes.get(i).getProduto();
            if (produto == p){
                m.add(movimentaçoes.get(i));
            }
        }
        return m;
    }

    public List <Movimentação> buscarMovimentação(LocalDate data){
        List<Movimentação> m = new ArrayList<>();
        for (int i = 0; i < movimentaçoes.size(); i++){
            LocalDate d = movimentaçoes.get(i).getData();
            if (data == d){
                m.add(movimentaçoes.get(i));
            }
        }
        return m;
    }

    public List <Movimentação> buscarMovimentação(Usuarios usuario){
        List<Movimentação> m = new ArrayList<>();
        for (int i = 0; i < movimentaçoes.size(); i++){
            Usuarios u = movimentaçoes.get(i).getUsuario();
            if (usuario == u){
                m.add(movimentaçoes.get(i));
            }
        }
        return m;
    }

    public List <Movimentação> buscarMovimentação(int quantidade){
        List<Movimentação> m = new ArrayList<>();
        for (int i = 0; i < movimentaçoes.size(); i++){
            int q = movimentaçoes.get(i).getQuantidade();
            if (quantidade == q){
                m.add(movimentaçoes.get(i));
            }
        }
        return m;
    }

    public List<Movimentação> getMovimentaçoes() {
        return movimentaçoes;
    }

    public void setMovimentaçoes(List<Movimentação> movimentaçoes) {
        this.movimentaçoes = movimentaçoes;
    }
}