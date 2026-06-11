package produto;

import java.util.List;


import observer.Observer;
import observer.Subject;

public class Produto implements Subject {
    private String nome;
    private int quantidade;
    private int ID;
    private int quantidadeMinima;
    private List <Observer> observers;

    public Produto(String nome, int quantidade, int iD, int quantidadeMinima, List <Observer> observers) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.ID = iD;
        this.quantidadeMinima = quantidadeMinima;
        this.observers = observers;
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
    public List<Observer> getObservers() {
        return observers;
    }
    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void adicionarObserver(Observer observer){
        observers.add(observer);
    }

    public void removerObserver(Observer observer){
        for (int i = 0; i < observers.size(); i++){
            if(observers.get(i) == observer){
                observers.remove(i);
            }
        }
    }

    public void notificarObservers(){
        for (int i = 0; i < observers.size(); i++){
            observers.get(i).atualizar(this);
        }
    }
}
