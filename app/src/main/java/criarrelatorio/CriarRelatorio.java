package criarrelatorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import estoque.Estoque;
import historico.Historico;
import relatorios.Relatorio;

public class CriarRelatorio {
    public static void gerar(Estoque estoque, Historico historico){
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = hoje.format(formato);

        String nomeRelatorio = "relatio" + data;
        
        Relatorio.gerarRelatorioEstoque(estoque, nomeRelatorio, historico);
    }
}
