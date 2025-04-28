package model;

public class Administrador extends Usuario{
	

	public Administrador(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
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
