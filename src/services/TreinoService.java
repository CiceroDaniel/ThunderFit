package services;

import model.*;
import repository.*;
import java.util.List;
import java.util.ArrayList;


public class TreinoService {
	private final TreinoRepository treinoRepository;
	private final ExercicioService exercicioService;
	private final UsuarioRepository usuarioRepository;
	private final UsuarioService usuarioService;
	
	public TreinoService(TreinoRepository treinoRepository, ExercicioService exercicioService,
			UsuarioRepository usuarioRepository,UsuarioService usuarioService) {
		this.treinoRepository = treinoRepository;
		this.exercicioService = exercicioService;
		this.usuarioRepository = usuarioRepository;
		this.usuarioService = usuarioService;
	}
	
	//------------------------ CRIAR -----------------
	
	public void criarTreino(String nome,Nivel nivel) {
		
		Treino treinoNovo = new Treino(nome,nivel);
		treinoRepository.cadastro(treinoNovo);
		
	}
	
	//--------------------READ--------------------
	
	public boolean alunoPossuiTreino(String cpfAluno, String nomeTreino, Usuario solicitante) {
	    Aluno aluno = (Aluno) usuarioService.buscarPorCpf(cpfAluno);
	    
	    for (Treino treino : aluno.getTreinos()) {
	        if (treino.getNome().equalsIgnoreCase(nomeTreino)) {
	            return true;
	        }
	    }
	    
	    return false;
	}
	
	public List<Treino> listarTreinosDoAluno(String cpfAluno, Usuario solicitante) {
		if(!(solicitante instanceof Administrador || solicitante instanceof Tutor|| solicitante.getCpf().equals(cpfAluno))) {
			throw new SecurityException("Acesso Negado");
		}
	    Aluno aluno = (Aluno) usuarioService.buscarPorCpf(cpfAluno);
	    return new ArrayList<>(aluno.getTreinos()); 
	}
	
	
	public List<Exercicio> listarTreinosDoAluno(String cpfAluno,String nomeTreino, Usuario solicitante){
		if(!(solicitante instanceof Administrador || solicitante instanceof Tutor|| solicitante.getCpf().equals(cpfAluno))) {
			throw new SecurityException("Acesso Negado");
		}
		 Aluno aluno = (Aluno) usuarioService.buscarPorCpf(cpfAluno);
		
		
		Treino treino = buscarTreinoDoAluno(aluno, nomeTreino);
		
		return treino.getExercicios();
		
	}
	
	//------------------BUSCAR----------------
	private Treino buscarTreinoDoAluno(Aluno aluno, String nomeTreino) {
	    for (Treino treino : aluno.getTreinos()) {
	        if (treino.getNome().equalsIgnoreCase(nomeTreino)) {
	            return treino;
	        }
	    }
	    throw new IllegalArgumentException("Treino não encontrado para o aluno");
	}
	
	
	
	//--------------------ATUALIZAR--------------------
	public void adicionarExercicios(String nomeTreino, String nomeExercicio, Usuario solicitante, int quantidade) {
		/*if(!solicitante.temAcessoAdmin()) {
			throw new SecurityException("Acesso apenas para ADMs e Tutores");
		}*/
		
		Treino treino = treinoRepository.buscarPorNome(nomeTreino);
		exercicioService.listarTodosExercicios();//Tutor ver tds os exercicios e decidir quais devem selecionar
		Exercicio exercicio = exercicioService.buscarPorNome(nomeExercicio);
		
		if (treino == null) throw new IllegalArgumentException("Treino não existe");
		if (exercicio == null) throw new IllegalArgumentException("Exercício não existe");
		exercicio.setQuantidade(quantidade);
		treino.adicionarExercicio(exercicio);
		treinoRepository.atualizarTreino(treino);
		
	}
	
	public void removerExercicios(String nomeTreino, String nomeExercicio, Usuario solicitante) {
		/*if(!solicitante.temAcessoAdmin()) {
			throw new SecurityException("Acesso apenas para ADMs e Tutores");
		}*/
		
		Treino treino = treinoRepository.buscarPorNome(nomeTreino);
		exercicioService.listarTodosExercicios();//Tutor ver tds os exercicios e decidir quais devem selecionar
		Exercicio exercicio = exercicioService.buscarPorNome(nomeExercicio);
		
	    if (treino == null) throw new IllegalArgumentException("Treino não existe");
	    if (exercicio == null) throw new IllegalArgumentException("Exercício não existe");
	    
	    treino.removerExercicio(exercicio);
	    treinoRepository.atualizarTreino(treino);
		
	}
	
	
	//--------------------REMOVER--------------------
	
	public void removerTreino(String nome, Usuario solicitante) {
		/*if(!solicitante.temAcessoAdmin()) {
			throw new SecurityException("Acesso apenas para ADMs e Tutores");
		}*/
		
		if(!treinoRepository.removerPorNome(nome)) {
			throw new IllegalArgumentException("Treino não encontrado!");
		}
		
		treinoRepository.removerPorNome(nome);
	}
	
	//-------------------------------------------------
	
	
	public void associarTreinoAluno(String cpfAluno, String nomeTre, Usuario solicitante) {
		/*if(!solicitante.temAcessoAdmin()) {
			throw new SecurityException("Acesso apenas para ADMs e Tutores");
		}*/
		
		Aluno aluno = (Aluno) usuarioService.buscarPorCpf(cpfAluno);
		Treino treino= treinoRepository.buscarPorNome(nomeTre);
		
		 if (aluno == null) throw new IllegalArgumentException("Aluno não encontrado");
		 
		 aluno.adicionarTreino(treino);
		 usuarioRepository.atualizarDados(aluno);
	}
	
	
	

}
