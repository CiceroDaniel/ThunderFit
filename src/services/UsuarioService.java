package services;

import model.*;
import repository.PagamentoRepository;
import repository.UsuarioRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private final PagamentoRepository pagamentoRepository;
	private boolean admCadastrado = false;
	
	public UsuarioService(UsuarioRepository usuarioRepository, PagamentoRepository pagamentoRepository) {
		this.usuarioRepository = usuarioRepository;
		this.pagamentoRepository = pagamentoRepository;
	}
	
	
	//--------------------------- CADASTRO ---------------------------------
	
	public void cadastroAluno(String nome,String email, String senha,String cpf,LocalDate dataDeNascimento,double altura,
			double peso,Nivel nivel, Metas metas,String metaPersonalizada,Plano plano, Genero genero, LocalDate dataCadastro) {
		
		if(usuarioRepository.buscarPorCpf(cpf)!= null) {
			throw new IllegalArgumentException(" Erro: CPF já cadastrado!");
		}
		if(usuarioRepository.buscarPorEmail(email)!= null) {
			throw new IllegalArgumentException(" Erro: Email já cadastrado!");
		}
		
		
		Aluno aluno = new Aluno(nome, email,senha,cpf,dataDeNascimento,altura, peso,nivel,metas,metaPersonalizada, plano, genero);			
		aluno.setDataDeCadastro(dataCadastro);
		
		usuarioRepository.cadastro(aluno);
		Pagamento pagamentoInicial = new Pagamento(aluno,plano.getValor(), dataCadastro,true);
	    pagamentoRepository.cadastro(pagamentoInicial);
		
	}
	
	public void cadastroTutor(String nome,String email,String senha, String cpf,LocalDate dataDeNascimento ,float salario ) {
		
		if(usuarioRepository.buscarPorCpf(cpf)!= null) {
			throw new IllegalArgumentException(" Erro: CPF já cadastrado!");
		}
		if(usuarioRepository.buscarPorEmail(email)!= null) {
			throw new IllegalArgumentException(" Erro: Email já cadastrado!");
		}
		
		Tutor tutor = new Tutor(nome, email, senha,cpf, dataDeNascimento, salario);
		
		usuarioRepository.cadastro(tutor);
		tutor.setTrabalhoAtivo(true);
		usuarioRepository.atualizarDados(tutor);
	
	}
	
	public void cadastroAdministrador(String nome, String email, String senha, String cpf,LocalDate dataDeNascimento) {
        
		if (admCadastrado) {
            throw new IllegalStateException("Apenas um administrador pode ser cadastrado!");
        }
        
        Administrador adm = new Administrador(nome, email, senha,cpf, dataDeNascimento);
        
        usuarioRepository.cadastro(adm);
        admCadastrado = true;
        //System.out.println(adm.gerarCredenciais());
    }
	
	
	//--------------------------- LISTAR ---------------------------------
	
	
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.listarTodos();
	}
	
	
	
	public List<Aluno> listarAlunos(Usuario solicitante){
		
		
		return usuarioRepository.listarAlunos();
	}

	public List<Tutor> listarTutores(){
		
		/*if(!(solicitante instanceof Administrador)) { alunos vao poder ver os tutores agr
			throw new SecurityException("Apenas ADMs podem listar");
		}*/
		
		return usuarioRepository.listarTutores();
	}
	
	//--------------------------- ATUALIZAR ---------------------------------
	
	public void atualizarDados(String cpf, String novoEmail, double novoPeso,double novaAltura, Metas novaMeta) {
		Aluno aluno = (Aluno) usuarioRepository.buscarPorCpf(cpf);
		if(aluno == null) throw new IllegalArgumentException("Erro: Aluno não encontrado!");
		
		 	if (novoEmail != null && !novoEmail.isBlank()) aluno.setEmail(novoEmail);
		    if (novaAltura > 0) aluno.setAltura(novaAltura);
		    if (novoPeso > 0) aluno.setPeso(novoPeso);
		    if (novaMeta != null) aluno.setMetas(novaMeta);
		    
		    usuarioRepository.atualizarDados(aluno);
	}
	public void alterarSenha(String cpf, String senhaNova) {
		Usuario usuario = usuarioRepository.buscarPorCpf(cpf);
		if(usuario == null) throw new IllegalArgumentException("Erro: Aluno não encontrado!");
		
		if(senhaNova != null) usuario.setSenha(senhaNova);
		usuarioRepository.atualizarDados(usuario);
	}
	
	public void atualizarStatusOnline(String cpf, boolean online) {
		Usuario usuario = usuarioRepository.buscarPorCpf(cpf);
		if(usuario != null) {			
			usuario.setOnline(online);
		}
	}
	
	public void atualizarPlanoAluno(String cpf, Plano novoPlano, Usuario solicitante) throws SecurityException {
		if(!solicitante.temAcessoAdmin()) {//talvez erro
			throw new SecurityException("Apenas tutores e ADMs podem buscar Usuarios");
		}
		Aluno aluno = (Aluno) usuarioRepository.buscarPorCpf(cpf);
		aluno.setPlano(novoPlano);
		usuarioRepository.atualizarDados(aluno);
	}
	
	public void atualizaDataDeCadastro(String cpf, LocalDate novaDataCadastro) {// nao disponivel para os menus apenas para ter registros de pesos e mudar data de matricula
		Usuario usuario = usuarioRepository.buscarPorCpf(cpf);
		usuario.setDataDeCadastro(novaDataCadastro);
		usuarioRepository.atualizarDados(usuario);
	}
	//--------------------------- BUSCAR ---------------------------------
	
	public Usuario buscarPorCpf(String cpf) {
		/*if(!(solicitante instanceof Tutor ||solicitante instanceof Administrador)) {
			throw new SecurityException("Apenas tutores e ADMs podem buscar Usuarios");
		}*/
		Usuario usuario = usuarioRepository.buscarPorCpf(cpf);
		if(usuario == null) {
			throw new IllegalArgumentException("Usuario não encontrado!");
		}
		return usuario;
	}
	
	public List<Usuario> buscarPorNome(String nome){
	/*	if(!solicitante.temAcessoAdmin()) {// talvez erro
			throw new SecurityException("Apenas tutores e ADMs podem buscar Usuarios");
		}*/
		
		  if (nome == null || nome.trim().isEmpty()) {
		        throw new IllegalArgumentException("Erro: Nome não pode ser vazio!");
		    }
		  
		  return usuarioRepository.buscarPorNomeLista(nome);
		
	}
	
	public Usuario buscarPorEmail(String email) {
		return usuarioRepository.buscarPorEmail(email);
	}
	
	//---------------------- REMOVER -------------------------
	
	public boolean removerUsuario(String cpf, Usuario solicitante) {
		if(!(solicitante instanceof Administrador)) {
			throw new SecurityException("Apenas ADMs podem remover Usuarios");
		}
		return usuarioRepository.removerPorCpf(cpf);
	}
	
	//---------------------------------------------------------------------
	
	public boolean verificarOnline(String cpf) {
		Usuario usuario = usuarioRepository.buscarPorCpf(cpf);
		return usuario != null && usuario.getOnline();
		}
	
}
