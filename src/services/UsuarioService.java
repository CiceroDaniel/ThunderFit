package services;

import model.*;
import repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private boolean admCadastrado = false;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	
	//--------------------------- CADASTRO ---------------------------------
	
	public void cadastroAluno(String nome,String cpf,String email, String senha,double altura,
			double peso,Nivel nivel, Metas metas,String metaPersonalizada,Plano plano ) {
		
		if(usuarioRepository.buscarPorCpf(cpf)!= null) {
			throw new IllegalArgumentException(" Erro: CPF já cadastrado!");
		}
		if(usuarioRepository.buscarPorEmail(email)!= null) {
			throw new IllegalArgumentException(" Erro: Email já cadastrado!");
		}
		
		Aluno aluno = new Aluno(nome, cpf, email, senha, altura, peso, 
                nivel, metas, metaPersonalizada, plano);
		
		usuarioRepository.cadastro(aluno);
	}
	
	public void cadastroTutor(String nome,String cpf,String email, String senha, float salario ) {
		
		if(usuarioRepository.buscarPorCpf(cpf)!= null) {
			throw new IllegalArgumentException(" Erro: CPF já cadastrado!");
		}
		if(usuarioRepository.buscarPorEmail(email)!= null) {
			throw new IllegalArgumentException(" Erro: Email já cadastrado!");
		}
		
		Tutor tutor = new Tutor(nome, cpf, email, senha, salario);
		
		usuarioRepository.cadastro(tutor);
	}
	
	public void cadastroAdministrador(String nome, String cpf, String email, String senha) {
        
		if (admCadastrado) {
            throw new IllegalStateException("Apenas um administrador pode ser cadastrado!");
        }
        
        Administrador adm = new Administrador(nome, cpf, email, senha);
        
        usuarioRepository.cadastro(adm);
        admCadastrado = true;
    }
	
	//--------------------------- LISTAR ---------------------------------
	
	public List<Usuario> listarUsuarios(Usuario solicitante){
		if(!(solicitante instanceof Administrador)) {
			throw new SecurityException("Apenas ADMs podem listar");
		}
		return usuarioRepository.listarTodos();
	}
	
	public List<Aluno> listarAluno(Usuario solicitante){
		if(!(solicitante instanceof Tutor ||solicitante instanceof Administrador)) {
			throw new SecurityException("Apenas tutores e ADMs podem listar");
		}
		
		return usuarioRepository.listarAlunos();
	}

	public List<Tutor> listarTutores(Usuario solicitante){
		if(!(solicitante instanceof Administrador)) {
			throw new SecurityException(" Apenas ADMs podem listar");
		}
		return usuarioRepository.listarTutores();
	}
	
	//--------------------------- ATUALIZAR ---------------------------------
	
	public void atualizarDados(String cpf, String novoEmail, double novoPeso, Metas novaMeta, Plano novoPlano) {
		Aluno aluno = (Aluno) usuarioRepository.buscarPorCpf(cpf);
		if(aluno == null) throw new IllegalArgumentException("Erro: Aluno não encontrado!");
		
		 	if (novoEmail != null) aluno.setEmail(novoEmail);
		    if (novoPeso > 0) aluno.setPeso(novoPeso);
		    if (novaMeta != null) aluno.setMetas(novaMeta);
		    if (novoPlano != null) aluno.setPlano(novoPlano);
		    
		    usuarioRepository.atualizarDados(aluno);
	}
	
	public void atualizarStatusOnline(String cpf, boolean online) {
		Usuario usuario = usuarioRepository.buscarPorCpf(cpf);
		if(usuario != null) {			
			usuario.setAtivo(online);
		}
	}
	
	//--------------------------- BUSCAR ---------------------------------
	
	public Usuario buscarPorCpf(String cpf, Usuario solicitante) {
		if(!(solicitante instanceof Tutor ||solicitante instanceof Administrador)) {
			throw new SecurityException("Apenas tutores e ADMs podem buscar Usuarios");
		}
		Usuario usuario = usuarioRepository.buscarPorCpf(cpf);
		if(usuario == null) {
			throw new IllegalArgumentException("Usuario não encontrado!");
		}
		return usuario;
	}
	
	public List<Usuario> buscarPorNome(String nome, Usuario solicitante){
		if(!(solicitante instanceof Tutor ||solicitante instanceof Administrador)) {
			throw new SecurityException("Apenas tutores e ADMs podem buscar Usuarios");
		}
		
		  if (nome == null || nome.trim().isEmpty()) {
		        throw new IllegalArgumentException("Erro: Nome não pode ser vazio!");
		    }
		  
		  return usuarioRepository.buscarPorNome(nome);
		
	}
	
	public Usuario buscarPorEmail(String email) {
		return usuarioRepository.buscarPorEmail(email);
	}
	
	//---------------------- REMOVER -------------------------
	
	public boolean removerUsuario(String cpf, Usuario solicitante) {
		if(!(solicitante instanceof Administrador)) {
			throw new SecurityException("Apenas ADMs podem buscar Usuarios");
		}
		return usuarioRepository.removerPorCpf(cpf);
	}
	
	//---------------------------------------------------------------------
	
	public boolean verificarOnline(String cpf) {
		Usuario usuario = usuarioRepository.buscarPorCpf(cpf);
		return usuario != null && usuario.getAtivo();
		}
	
}
