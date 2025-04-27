package model;

import java.util.ArrayList;
import java.util.List;

public class Treino {
	//----------------------Atributos---------------------
	private String nome;
	private List<Exercicio> exercicios;
	private String nivelDif;

	//----------------------Construtor---------------------
	
	public Treino(String nome, String nivel) {
		this.nome=nome;
		this.nivelDif=nivel;
		this.exercicios = new ArrayList<>();
	}

	//----------------------Getters and Setters---------------------
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}

	public List<Exercicio> getExercicios() {
		return new ArrayList<>(exercicios);
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public String getNivelDif() {
		return nivelDif;
	}

	public void setNivelDif(String nivelDif) {
		this.nivelDif = nivelDif;
	}

	

}
