package model;

public class Administrador extends Usuario{
	
	

	public Administrador(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
	}

	@Override
	public boolean temAcessoAdmin() {
		return true;
	}

	@Override
	public String gerarCredenciaisCadastro() {
		return String.format("Nome: %s\nCPF: %s\nEmail: %s",
				this.getNome(),/*this.getCpf(),*/this.getEmail());
	}

	@Override
	public String gerarCredenciaisLogin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public void Acessaralunos(SistemadePresença sistema,Aluno aluno) {
		sistema.mostrarRegistros(aluno);
	}
	
	public void ExcluirAluno(SistemadePresença sistema,Aluno aluno) {
		
	}

}
