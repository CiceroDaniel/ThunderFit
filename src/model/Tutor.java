package model;

import java.util.Objects;

public class Tutor extends Usuario{

	protected float salario;
	private boolean trabalhoAtivo;
	
	public Tutor(String nome, String cpf, String email,String senha,float salario) {
		super(nome, cpf, email, senha);
		this.setSalario(salario);
	}

	
	
	//------------------------ Metodos ---------------------------
	
	public void criarTreino(Aluno aluno, String nome) {
		Objects.requireNonNull(aluno,"Erro: Aluno não pode ser nulo!");
		if(nome== null || nome.isBlank()) {
			
		}
		
	}
	
	public void avaliarAluno(Aluno aluno) {
		
	}
	
	
	@Override
	public String gerarCredenciais() {
		return "Nome: "+nome+"\nCPF: "+cpf+"\nEmail: "+email+"\nSalario: "+salario;
	}

	@Override
	public boolean temAcessoAdmin() {
		return true;
	}

	
	
	
	//----------------------Getters and Setters------------------
	public boolean getTrabalhoAtivo() {
		return trabalhoAtivo;
	}

	public void setTrabalhoAtivo(boolean trabalhoAtivo) {
		this.trabalhoAtivo = trabalhoAtivo;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		if(salario<=0) {
			throw new IllegalArgumentException("Erro: Salario invalido!");
		}
		this.salario=salario;
	}
	
	
	
}
