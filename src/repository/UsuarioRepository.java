package repository;


import model.Tutor;
import model.Aluno;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UsuarioRepository {
	private final List<Usuario> usuarios = new ArrayList<>();
	
	public void cadastro(Usuario usuario) {
		Objects.requireNonNull(usuario,"Erro: Usuario não pode ser nulo!");
		
		if(usuario.getNome()==null || usuario.getNome().isBlank()) {
			throw new IllegalArgumentException("Erro: Nome invalido!");
		}
		if(buscarCpf(usuario.getCpf()) != null) {
			throw new IllegalArgumentException("Erro: CPF já cadastrado!");
		}
		
		
		usuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
	}
	
	public Usuario buscarCpf( String cpf) {
		if(cpf == null || cpf.isBlank()) {
			return null;
		}
		String cpfLimpo= cpf.replaceAll("[^0-9]", "");
		for(Usuario u : usuarios) {
			if(u.getCpf().equals(cpfLimpo)) {
				return u;
			}
		}
		return null;
	}
	
	public List<Usuario> buscarPorNome(String nome){
		List<Usuario> encontrados = new ArrayList<>();
		
		if(nome == null || nome.isBlank()) {
			return encontrados;
		}
		
		for(Usuario u: usuarios) {
			if(u.getNome() != null && u.getNome().equalsIgnoreCase(nome)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public List<Usuario> buscarPorEmail(String email){
		List<Usuario> encontrados = new ArrayList<>();
		
		if(email == null || email.isBlank()) {
			return encontrados;
		}
		
		for(Usuario u: usuarios) {
			if(u.getNome() != null && u.getNome().equalsIgnoreCase(email)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
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
	
	public List<Aluno> listarAlunos(){
		List<Aluno> alunos = new ArrayList<>();
		for(Usuario usuario : usuarios) {
			if(usuario instanceof Aluno) {
				alunos.add((Aluno) usuario);
				
			}
		}
		return alunos;
		
	}

	
	public List<Tutor> listarTutores(){
		List<Tutor> tutores = new ArrayList<>();
		for(Usuario usuario : usuarios) {
			if(usuario instanceof Tutor) {
				tutores.add((Tutor) usuario);
				
			}
		}
		return tutores;
		
	}
	
	
	public boolean removerPorCpf(String cpf) {
		Usuario usuario = buscarCpf(cpf);
		if(usuario != null) {
			usuarios.remove(usuario);
			System.out.println("Usuario removido com sucesso!");
			return true;
		} else {
			System.out.println("Usuario não encontrado!");
			return false;
		}
		
	}
	
	
	
}
