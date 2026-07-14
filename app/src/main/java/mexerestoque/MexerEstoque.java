package mexerestoque;

import java.util.Scanner;

import comandos.CriarProduto;
import comandos.EntradaProduto;
import comandos.SaidaProduto;
import estoque.Estoque;
import historico.Historico;
import produto.Produto;
import usuarios.Usuarios;

public class MexerEstoque {
    public static void alterarEstoque(Scanner scanner, Estoque estoque, Historico historico, Usuarios usuario){
        boolean continuar = true;
        while ( continuar == true) {
            String escolha = scanner.next();
            if(escolha == "Entrada produto"){
                int ID = scanner.nextInt();
                int quantidade = scanner.nextInt();
                try {
                    Produto produto = estoque.buscarProduto(ID);
                    EntradaProduto entradaProduto = new EntradaProduto(estoque, quantidade, produto, usuario, historico);
                    entradaProduto.executar();
                }
                catch (Exception ProdutoNaoEncontradoException) {
                    System.out.println("Produto não encotrado");
                }
                continuar = false;
            }

            if(escolha == "Saida produto"){
                int ID = scanner.nextInt();
                int quantidade = scanner.nextInt();
                try {
                    Produto produto = estoque.buscarProduto(ID);
                    SaidaProduto saidaProduto = new SaidaProduto(estoque, quantidade, produto, usuario, historico);
                    saidaProduto.executar();
                }
                catch (Exception ProdutoNaoEncontradoException) {
                    System.out.println("Produto não encotrado");
                }
                continuar = false;
            }

            if (escolha == "Criar produto"){
                String nome = scanner.next();
                int quantidade = scanner.nextInt();
                int ID = 0;
                int quantidadeMinima = scanner.nextInt();

                Produto produto = new Produto(nome, quantidade, ID, quantidadeMinima);
                CriarProduto criarProduto = new CriarProduto(estoque, produto, usuario, historico);
                criarProduto.executar();
                continuar = false;
            }
            if (escolha  == "terminar"){
                continuar = true;
            }
            else{
                System.out.println("Escolha invalida");
            }
        }
    }
}
