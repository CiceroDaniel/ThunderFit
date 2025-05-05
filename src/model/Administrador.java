package model;

import java.time.LocalDate;

public class Administrador extends Usuario{
	
	

	public Administrador(String nome, String cpf, String email, String senha, LocalDate dataDeNascimento) {
		super(nome, cpf, email, senha,dataDeNascimento);
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
