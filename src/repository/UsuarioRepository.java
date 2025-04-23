package repository;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;


public class UsuarioRepository {
	private List<Usuario> usuarios = new ArrayList<>();
	
	public void cadastro(Usuario usuario) {
		if(usuario == null) {
			System.out.println("Erro: Usuario não pode ser nulo!");
			return;
		}
		if(usuario.getNome()==null || usuario.getNome().isBlank()) {
			System.out.println("Erro: Nome invalido!");
			return;
		}
		if(buscarCpf(usuario.getCpf()) != null) {
			System.out.println("Erro: CPF já cadastrado!");
			return;
		}
		
		
		usuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
	}
	
	public Usuario buscarCpf( String cpf) {
		for(Usuario u : usuarios) {
			if(u.getCpf().equals(cpf)) {
				return u;
			}
		}
		return null;
	}
	
	public void atualizarDados(Usuario usuario) {
		int indice= usuarios.indexOf(buscarCpf(usuario.getCpf()));
		if(indice != -1) {
			usuarios.set(indice, usuario);
		}
	}
	
	public List<Usuario> listarTodos(){
		return new ArrayList<>(usuarios);
	}

	
	
	public boolean remover(Usuario usuario) {
		if(usuario == null) {
			System.out.println("Erro: Usuario não pode ser nulo!");
			return false;
		}
		return usuarios.remove(usuario);
		
	}
	
	
	
}
