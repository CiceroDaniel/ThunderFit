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
	
	public void cadastroAluno(String nome,String cpf,String email, String senha,double altura,
			double peso,Nivel nivel, Metas metas,String metaPersonalizada,Plano plano ) {
		
		if(usuarioRepository.buscarCpf(cpf)!= null) {
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
		
		if(usuarioRepository.buscarCpf(cpf)!= null) {
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
	
	public List<Usuario> listarUsuarios(Usuario solicitante){
		if(!(solicitante instanceof Administrador)) {
			throw new IllegalArgumentException("Erro: Apenas ADMs podem listar");
		}
		return usuarioRepository.listarTodos();
	}
	
	public List<Aluno> listarAluno(Usuario solicitante){
		if(!(solicitante instanceof Tutor ||solicitante instanceof Administrador)) {
			throw new IllegalArgumentException("Erro: Apenas tutores e ADMs podem listar");
		}
		
		return usuarioRepository.listarAlunos();
	}

	public List<Tutor> listarTutores(Usuario solicitante){
		if(!(solicitante instanceof Administrador)) {
			throw new IllegalArgumentException("Erro: Apenas ADMs podem listar");
		}
		return usuarioRepository.listarTutores();
	}
	
	public void atualizarDados(String cpf, String novoEmail, double novoPeso, Metas novaMeta, Plano novoPlano) {
		Aluno aluno = (Aluno) usuarioRepository.buscarCpf(cpf);
		if(aluno == null) throw new IllegalArgumentException("Erro: Aluno não encontrado!");
		
		 	if (novoEmail != null) aluno.setEmail(novoEmail);
		    if (novoPeso > 0) aluno.setPeso(novoPeso);
		    if (novaMeta != null) aluno.setMetas(novaMeta);
		    if (novoPlano != null) aluno.setPlano(novoPlano);
		    
		    usuarioRepository.atualizarDados(aluno);
	}
	
	
}
