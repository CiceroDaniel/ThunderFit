package services;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import model.Presenca;
import repository.PresencaRepository;

public class RelatorioPresencaService {
	   private final PresencaRepository presencaRepository;

	   public RelatorioPresencaService(PresencaRepository presencaRepository) {
	        this.presencaRepository = presencaRepository;
	   }
	   
	   public List<Presenca> gerarRelatorioPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
	        return presencaRepository.listarTodos().stream()
	            .filter(p -> !p.getDataHora().isBefore(dataInicio) 
	                      && !p.getDataHora().isAfter(dataFim))
	            .collect(Collectors.toList());
	    }
	   
	   // ------ RELATORIO DE FREQUENCIA MENSAL ------
	    public String gerarFrequenciaMensal(String cpfAluno, int mes, int ano) {
	        List<Presenca> presencas = presencaRepository.listarTodosPorAluno(cpfAluno);
	        
	        long presencasNoMes = presencas.stream()
	            .filter(p -> p.getDataHora().getMonthValue() == mes 
	                      && p.getDataHora().getYear() == ano)
	            .count();

	        int diasNoMes = java.time.YearMonth.of(ano, mes).lengthOfMonth();
	        double frequencia = (presencasNoMes * 100.0) / diasNoMes;

	        String nomeAluno = presencas.isEmpty() ? "Indisponivel" : presencas.get(0).getAluno().getNome();
	        return String.format(
	            "Aluno %s: %.2f%% de frequência (%d dias de %d)",
	            nomeAluno, frequencia, presencasNoMes, diasNoMes
	        );
	    }

}
