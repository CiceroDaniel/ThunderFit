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
		
		
		usuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
		
	}
	

	
	
	
}
