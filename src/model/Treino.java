package model;

import java.util.ArrayList;
import java.util.List;

public class Treino {
	//----------------------Atributos---------------------
	private String nome;
	private List<Exercicio> exercicios;
	private Nivel nivel;

	//----------------------Construtor---------------------
	
	public Treino(String nome, Nivel nivel) {
		this.nome=nome;
		this.nivel=nivel;
		this.exercicios = new ArrayList<>();
	}
	
	//------------------- Metodos ---------------------------
	
	public void adicionarExercicio(Exercicio exercicio) {
		this.exercicios.add(exercicio);
	}
	
	public void removerExercicio(Exercicio exercicio) {
		this.exercicios.remove(exercicio);
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

	public Nivel getNivelDif() {
		return nivel;
	}

	public void setNivelDif(Nivel nivel) {
		this.nivel = nivel;
	}

	

}
