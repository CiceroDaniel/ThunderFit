package model;

public class Administrador extends Usuario{
	

	public Administrador(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
	}

	@Override
	public String gerarCredenciais() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean temAcessoAdmin() {
		// TODO Auto-generated method stub
		return true;
	}

}
