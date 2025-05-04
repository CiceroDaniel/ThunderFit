package repository;


import model.Tutor;
import model.Aluno;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UsuarioRepository implements InterfaceRepository<Usuario>{
	private final List<Usuario> usuarios = new ArrayList<>();
	
	//--------------------CRIAR--------------------
	
	@Override
	public void cadastro(Usuario usuario) {
		Objects.requireNonNull(usuario,"Erro: Usuario não pode ser nulo!");
		
		if(usuario.getNome()==null || usuario.getNome().isBlank()) {
			throw new IllegalArgumentException("Erro: Nome invalido!");
		}
		if(buscarPorCpf(usuario.getCpf()) != null) {
			throw new IllegalArgumentException("Erro: CPF já cadastrado!");
		}
		if(buscarPorEmail(usuario.getEmail()) != null) {
			throw new IllegalArgumentException("Erro: Email já cadastrado!");
		}
		
		
		usuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
	}
	
	//--------------------BUSCAR--------------------
	
	public Usuario buscarPorCpf( String cpf) {
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
	
	
	@Override
	public List<Usuario> buscarPorNomeLista(String nome){
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
	
	@Override
	public Usuario buscarPorNome(String nome) {
		 throw new UnsupportedOperationException("Funcionalidade não implementada!");//Nao necessaria para esta classe
	}
	
	public Usuario buscarPorEmail(String email){
		if(email == null || email.isBlank()) {
			return null;
		}
		for(Usuario u : usuarios) {
			if(u.getEmail()!= null && u.getEmail().equalsIgnoreCase(email.trim())) {
				return u;
			}
		}
		return null;
		
	}
	
	 //--------------------ATUALIZAR--------------------
	
	public void atualizarDados(Usuario usuario) {
		int indice= usuarios.indexOf(buscarPorCpf(usuario.getCpf()));
		if(indice != -1) {
			usuarios.set(indice, usuario);
		}
	}
	
	//--------------------LISTAR--------------------
	
	@Override
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
	
	//--------------------REMOVER--------------------
	
	public boolean removerPorCpf(String cpf) {
		Usuario usuario = buscarPorCpf(cpf);
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
