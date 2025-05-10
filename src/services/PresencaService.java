package services;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Objects;
import model.Aluno;
import model.Presenca;
import repository.PresencaRepository;


public class PresencaService {
	private final PresencaRepository presencaRepository;
	
	public PresencaService(PresencaRepository presencaRepository) {
	this.presencaRepository = presencaRepository;
	}
	
	
	//----------------CADASTRO-------------------
	public void registrarPresenca(Aluno aluno) {
		Objects.requireNonNull(aluno, "Aluno não pode ser nulo!!");
		
		Presenca presenca = new Presenca(aluno);
		presencaRepository.cadastro(presenca);
	}
	
	//---------------LISTAR------------------
	
	public List<Presenca> listarPresencasAluno(String cpfAluno){
		if(cpfAluno == null || cpfAluno.isBlank()) {
			throw new IllegalArgumentException("CPF aluno nulo em listar presenças!!");
		}
		return presencaRepository.listarTodosPorAluno(cpfAluno);
	}
	
	public List<Presenca> listarTodasPresencas(){
		return presencaRepository.listarTodos();
	}
	
	public double calcularFrequenciaMensal(String cpfAluno, int mes, int ano) {
		  if (mes < 1 || mes > 12) {
		        throw new IllegalArgumentException("Mês inválido. Use valores entre 1 e 12.");
		    }
		
		List<Presenca> presencas = presencaRepository.listarTodosPorAluno(cpfAluno);
		
		int diasNoMes= LocalDateTime.now().withMonth(mes).withYear(ano).getMonth().length(false);
		
		long presencasNoMes = presencas.stream().filter(p->p.getDataHora().getYear()==ano&&p.getDataHora().getMonthValue()==mes).count();
		
		return (double) (100.0 * presencasNoMes) / diasNoMes;
	}
	
	

}

