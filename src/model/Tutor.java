package model;

import java.time.LocalDate;

public class Tutor extends Usuario{

	protected float salario;
	private boolean trabalhoAtivo;
	
	
	public Tutor(String nome,String email,String senha,String cpf,LocalDate dataDeNascimento,float salario) {
		super(nome,email,senha ,cpf,null);// nao adianta a data nao pode ser nula  
		this.salario=0;
		this.trabalhoAtivo= true;
	}




	//------------------------ Metodos ---------------------------
	
	


	@Override
	public String gerarCredenciais() {
		return String.format("Nome: %s\nEmail: %s\nSenha: %s\nCPF:%s\n",
		this.getNome(),this.getEmail(),this.getSenha(),this.getCpf());
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
	
	//PRECISA CRIAR UM PAGAMENTO
	public void setSalario(float salario) {
		if(salario<=0.0) {
			throw new IllegalArgumentException("Erro: Salario invalido!"+salario);
		}
		this.salario=salario;
		
	}



	@Override
	public String gerarCredenciaisCadastro() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String gerarCredenciaisLogin() {
		// TODO Auto-generated method stub
		return null;
	}



	
	
	
}
