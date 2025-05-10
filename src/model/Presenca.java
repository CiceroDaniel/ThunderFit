package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Presenca {

	private Aluno aluno;//COMPOSIÇÃO/ASSOCIAÇÃO DE OBJETO
	private LocalDateTime dataHora;
	
	public Presenca(Aluno aluno) {
		this.aluno = Objects.requireNonNull(aluno,"Aluno não pode ser nulo");
		
		//REGISTRA DATA E HORA ATUAL
		this.dataHora = LocalDateTime.now();
		
	}
	public Aluno getAluno() {
		return aluno;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	

	}

