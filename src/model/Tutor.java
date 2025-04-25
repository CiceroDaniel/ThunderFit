package model;

public class Tutor extends Usuario{

	protected float salario;
	private boolean trabalhoAtivo;
	
	public Tutor(String nome, String cpf, String email,String senha,float salario) {
		super(nome, cpf, email, senha);
		this.salario=salario;
	}

	
	
	//------------------------ Metodos ---------------------------
	
	public void criarTreino(Aluno aluno, String nome) {
		
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
	public boolean isTrabalhoAtivo() {
		return trabalhoAtivo;
	}

	public void setTrabalhoAtivo(boolean trabalhoAtivo) {
		this.trabalhoAtivo = trabalhoAtivo;
	}
	
	
	
}
