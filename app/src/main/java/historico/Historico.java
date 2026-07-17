package historico;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
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

    public List <Movimentação> buscarMovimentaçãoProduto(int ID_produto){
        List<Movimentação> m = new ArrayList<>();
        for (int i = 0; i < movimentaçoes.size(); i++){
            Produto p = movimentaçoes.get(i).getProduto();
            int ID = p.getID();
            if (ID == ID_produto){
                m.add(movimentaçoes.get(i));
            }
        }
        return m;
    }

    public List <Movimentação> buscarMovimentaçãoData(LocalDate data){
        List<Movimentação> m = new ArrayList<>();
        for (int i = 0; i < movimentaçoes.size(); i++){
            LocalDate d = movimentaçoes.get(i).getData();
            if (data == d){
                m.add(movimentaçoes.get(i));
            }
        }
        return m;
    }

    public List <Movimentação> buscarMovimentaçãoUsuario(String loginUsuario){
        List<Movimentação> m = new ArrayList<>();
        for (int i = 0; i < movimentaçoes.size(); i++){
            Usuarios u = movimentaçoes.get(i).getUsuario();
            String login = u.getLogin();
            if (login == loginUsuario){
                m.add(movimentaçoes.get(i));
            }
        }
        return m;
    }

    public List <Movimentação> buscarMovimentaçãoQuantidade(int quantidade){
        List<Movimentação> m = new ArrayList<>();
        for (int i = 0; i < movimentaçoes.size(); i++){
            int q = movimentaçoes.get(i).getQuantidade();
            if (quantidade == q){
                m.add(movimentaçoes.get(i));
            }
        }
        return m;
    }

    public void salvarHistorico(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            mapper.writeValue(new File("../dados/historico.json"), movimentaçoes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarHistorico() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        movimentaçoes = mapper.readValue(new File("../dados/historico.json"), new TypeReference<List<Movimentação>>() {});
    }

    public List<Movimentação> getMovimentaçoes() {
        return movimentaçoes;
    }

    public void setMovimentaçoes(List<Movimentação> movimentaçoes) {
        this.movimentaçoes = movimentaçoes;
    }
}