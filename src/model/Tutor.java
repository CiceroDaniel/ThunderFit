package model;


public class Tutor extends Usuario{

	protected float salario;
	private boolean trabalhoAtivo;
	
	public Tutor(String nome, String cpf, String email,String senha,float salario) {
		super(nome, /*cpf*/ email, senha);
		this.setSalario(salario);
		this.trabalhoAtivo= true;
	}

	
	
	//------------------------ Metodos ---------------------------
	
	
	@Override
	public String gerarCredenciais() {
		return String.format("Nome: %s\nCPF: %s\nEmail: %s\nSalario: R$%.2f",
		this.getNome(),/*this.getCpf(),*/this.getEmail(),this.getSalario());
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
