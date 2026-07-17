package relatorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import estoque.Estoque;
import historico.Historico;
import produto.Produto;

public class Relatorio {
    public static void gerarRelatorioEstoque(Estoque estoque, String nomeArquivo, Historico historico){
        System.out.println(System.getProperty("user.dir"));
        try {

            File arquivo = new File("../relatorios/" + nomeArquivo + ".txt");
            
            int contador = 1;

            while (arquivo.exists()) {
                arquivo = new File("../relatorios/" + nomeArquivo + "(" + contador + ").txt");
                contador++;
            }

            PrintWriter escritor = new PrintWriter(new FileWriter(arquivo));

            int produtosCadastrados = estoque.getProdutos().size();
            int produto = calcularTotalDeProdutos(estoque);
            int produtoAbaixoQuantidadeMinima = calcularTotalDeProdutosQuantidadeMinima(estoque);
            int movimentações = historico.getMovimentaçoes().size();

            escritor.println("RELATORIO DE ESTOQUE");
            escritor.println("---------------------");
            escritor.println("INFORMAÇÕES GERAIS");
            escritor.println("Quantidade de produtos cadastrados: " + produtosCadastrados);
            escritor.println("Quantidade total de itens em estoque: " + produto);
            escritor.println("Quantidade de itens abaixo da quntidade minima: " + produtoAbaixoQuantidadeMinima);
            escritor.println("Total de movimentações realizadas: " + movimentações);
            escritor.println();
            escritor.println("SITUAÇÃO DO ESTOQUE");
            imprimirProdutos(estoque, escritor);
            escritor.print("Total: " + produto + " produtos");
            escritor.println();
            if (produtoAbaixoQuantidadeMinima > 0){
                escritor.println("PRODUTOS ABAIXO DA QUANTIDADE MINIMA");
                imprimirProdutosAbaixoQuantidadeMinima(estoque, escritor);
            }
            escritor.close();
            System.out.println("Relatorio " + nomeArquivo + "gerado com sucesso");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }       
    }

    private static void imprimirProdutos(Estoque estoque, PrintWriter escritor){
        for (int i = 0; i < estoque.getProdutos().size(); i++){
            Produto p = estoque.getProdutos().get(i);
            escritor.print("Produto: " + p.getNome() + "  Quantidade: " + p.getQuantidade() + "  ID: " + p.getID() + "\n");
        }
    }

    private static void imprimirProdutosAbaixoQuantidadeMinima(Estoque estoque, PrintWriter escritor){
        for (int i = 0; i < estoque.getProdutos().size(); i++){
            Produto p = estoque.getProdutos().get(i);
            if (p.getQuantidade() < p.getQuantidadeMinima()){
                escritor.print("Produto: " + p.getNome() + "  Quantidade: " + p.getQuantidade() + "Quantidade minima: " + p.getQuantidadeMinima() +  "\n");
            }
            
        }
    }

    private static int calcularTotalDeProdutos(Estoque estoque){
        List<Produto> produtos = estoque.getProdutos();
        int totalDeProdutos = 0;
        for (int i = 0; i < produtos.size(); i++){
            Produto p = produtos.get(i);
            totalDeProdutos = totalDeProdutos + p.getQuantidade();
        }
        return totalDeProdutos;
    }

    private static int calcularTotalDeProdutosQuantidadeMinima(Estoque estoque){
        List<Produto> produtos = estoque.getProdutos();
        int totalDeProdutos = 0;
        for (int i = 0; i < produtos.size(); i++){
            Produto p = produtos.get(i);
            if (p.getQuantidade() < p.getQuantidadeMinima()){
                totalDeProdutos = totalDeProdutos + p.getQuantidade();
            }
            
        }
        return totalDeProdutos;
    }
}