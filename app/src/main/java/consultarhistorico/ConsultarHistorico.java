package consultarhistorico;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import historico.Historico;
import historico.Movimentação;

public class ConsultarHistorico {
    public static void consultar(Scanner scanner, Historico historico){
        boolean continuar = true;
        while (continuar == true){
            String escolha = scanner.next();
            if (escolha.equals("Buscar por produto")){
                int ID = scanner.nextInt();
                List<Movimentação> m = historico.buscarMovimentaçãoProduto(ID);   // Tentar fazer direto por ID
                System.out.println(m);
            }

            if (escolha.equals("Buscar por data")){
                try {
                    LocalDate data = LocalDate.parse(scanner.nextLine());
                    List<Movimentação> m =historico.buscarMovimentaçãoData(data);
                    System.out.println(m);

                } catch (Exception DateTimeParseException) {
                    System.out.println("Data escrita no formato errado");
                }

            }
            if(escolha.equals("Buscar por quantidade")){
                int quantidade = scanner.nextInt();
                List<Movimentação> m = historico.buscarMovimentaçãoQuantidade(quantidade);
                System.out.println(m);

            }
            if (escolha.equals("Buscar por usuario")){
                String login = scanner.next();
                List<Movimentação> m = historico.buscarMovimentaçãoUsuario(login);
                System.out.println(m);
            }

            if (escolha.equals("sair")){
                continuar = false;
            }

            else{
                System.out.println("Escolha invalida");
            }
        }
    }
}
