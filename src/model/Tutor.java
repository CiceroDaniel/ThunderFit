package model;

public class Tutor extends Usuario{

	protected float salario;
	
	public Tutor(String nome, String cpf, String email,float salario) {
		super(nome, cpf, email);
		this.salario=salario;
	}

	@Override
	public String gerarCredenciais() {
		return "Nome: "+nome+"\nCPF: "+cpf+"\nEmail: "+email+"\nSalario: "+salario;
	}

	@Override
	public boolean temAcessoAdmin() {
		return true;
	}
	
	
	
}
