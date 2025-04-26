package model;

import java.util.ArrayList;
import java.util.List;

public class Treino {
	private String nome;
	private List<Exercicio> exercicios;
	private String nivelDif;
	
	public Treino(String nome, String nivel) {
		this.nome=nome;
		this.nivelDif=nivel;
	}

}
