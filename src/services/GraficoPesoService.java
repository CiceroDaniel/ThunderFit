package services;

import model.Aluno;
import model.RegistroPeso;
import java.util.List;

public class GraficoPesoService {

    
    public void exibirGraficoEvolucaoPeso(Aluno aluno) {// Gera um gráfico ASCII simples 
        List<RegistroPeso> historico = aluno.getHistoricoPeso();
        
        if (historico.isEmpty()) {
            System.out.println("Nenhum registro de peso encontrado.");
            return;
        }

        System.out.println("\n📈 Evolução de Peso - " + aluno.getNome());
        System.out.println("(kg) | Data       | Peso | Gráfico");
        System.out.println("----------------------------------");

        double maxPeso = historico.stream().mapToDouble(RegistroPeso::getPeso).max().orElse(1);
        double minPeso = historico.stream().mapToDouble(RegistroPeso::getPeso).min().orElse(0);
        double escala = maxPeso - minPeso;

        for (RegistroPeso registro : historico) {
            double peso = registro.getPeso();
            int barLength = (int) ((peso - minPeso) / escala * 20); // Normaliza para 20 caracteres
            
            System.out.printf(
                "      | %s | %4.1f | %s%s\n",
                registro.getData(),
                peso,
                "█".repeat(barLength),
                barLength == 0 ? "|" : ""
            );
        }
    }
}