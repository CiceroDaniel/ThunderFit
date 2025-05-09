package model;

import java.time.LocalDate;

public class Administrador extends Usuario{
	
	
	public Administrador(String nome, String email,String senha,String cpf) {
		super(nome,email,senha,cpf);
	}
	
	public Administrador(String nome, String email,String senha, String cpf, LocalDate dataDeNascimento) {
		super(nome,email,senha,cpf);
	}

	@Override
	public boolean temAcessoAdmin() {
		return true;
	}

	@Override
	public String gerarCredenciaisCadastro() {
		return String.format("Nome: %s\nEmail: %s\nSenha:%s\nCPF:%s",
				this.getNome(),this.getEmail(),this.getSenha(),this.getCpf());
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
