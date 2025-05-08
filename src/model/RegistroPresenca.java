package model;

import java.time.LocalDateTime;

public class RegistroPresenca {

	private Aluno aluno;//COMPOSIÇÃO/ASSOCIAÇÃO DE OBJETO
	private LocalDateTime dataHora;
	
	public RegistroPresenca(Aluno aluno) {
		this.aluno = aluno;
		
		//REGISTRA DATA E HORA ATUAL
		this.dataHora = LocalDateTime.now();
		System.out.println("Data de hoje"+getDataHora());
		
	}
	public Aluno getAluno() {
		return aluno;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	

	}

