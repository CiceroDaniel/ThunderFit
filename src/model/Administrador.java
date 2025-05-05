package model;

import java.time.LocalDate;

public class Administrador extends Usuario{
	

	public Administrador(String nome, String cpf, String email, String senha, LocalDate dataDeNascimento) {
		super(nome, cpf, email, senha,dataDeNascimento);
	}

	@Override
	public String gerarCredenciais() {
		return String.format("Nome: %s\nCPF: %s\nEmail: %s",
		this.getNome(),this.getCpf(),this.getEmail());
	}

	@Override
	public boolean temAcessoAdmin() {
		return true;
	}

}
