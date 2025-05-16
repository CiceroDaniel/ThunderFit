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
	
	
	public List<Exercicio> listarTreinosDoAluno(String cpfAluno, String nomeTreino, Usuario solicitante) {
	    if (!(solicitante instanceof Administrador || 
	          solicitante instanceof Tutor || 
	          solicitante.getCpf().equals(cpfAluno))) {
	        throw new SecurityException("Acesso Negado");
	    }
	    
	    
	    Usuario usuario = usuarioService.buscarPorCpf(cpfAluno);
	    if (!(usuario instanceof Aluno)) {
	        throw new IllegalArgumentException("CPF não pertence a um aluno");
	    }
	    
	    Aluno aluno = (Aluno) usuario;
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

		
		Treino treino = treinoRepository.buscarPorNome(nomeTreino);
		exercicioService.listarTodosExercicios();//Tutor ver tds os exercicios e decidir quais devem selecionar
		Exercicio exercicio = exercicioService.buscarPorNome(nomeExercicio);
		
	    if (treino == null) throw new IllegalArgumentException("Treino não existe");
	    if (exercicio == null) throw new IllegalArgumentException("Exercício não existe");
	    
	    treino.removerExercicio(exercicio);
	    treinoRepository.atualizarTreino(treino);
		
	}
	
	public void atualizarTreino(Treino treinoAtualizado) {
	    // Validaçao
	    if (treinoAtualizado == null) {
	        throw new IllegalArgumentException("Treino não pode ser nulo");
	    }

	  

	    //Verificar se o treino existe 
	    Treino treinoExistente = treinoRepository.buscarPorNome(treinoAtualizado.getNome());
	    if (treinoExistente == null) {
	        throw new IllegalArgumentException("Treino não encontrado para atualização");
	    }

	    // Validar dados do treino
	    if (treinoAtualizado.getNome() == null || treinoAtualizado.getNome().trim().isEmpty()) {
	        throw new IllegalArgumentException("Nome do treino é obrigatório");
	    }

	    if (treinoAtualizado.getNivelDif() == null) {
	        throw new IllegalArgumentException("Nível de dificuldade é obrigatório");
	    }

	    // Atualizar no repository
	    try {
	        treinoRepository.atualizarTreino(treinoAtualizado);
	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao atualizar treino no banco de dados: " + e.getMessage());
	    }
	}
	
	
	//--------------------REMOVER--------------------
	
	public void removerTreino(String nome) {
	    removerAssociacoesTreino(nome);
	    
	    boolean sucesso = treinoRepository.removerPorNome(nome);
	    if (!sucesso) {
	        throw new IllegalArgumentException("Treino não encontrado!");
	    }
	}

	private void removerAssociacoesTreino(String nomeTreino) {
	    // Percorre todos os alunos e remove o treino
	    for (Aluno aluno : usuarioRepository.listarAlunos()) {
	        // Cria uma nova lista sem o treino a ser removido
	        List<Treino> novosTreinos = new ArrayList<>();
	        for (Treino t : aluno.getTreinos()) {
	            if (!t.getNome().equalsIgnoreCase(nomeTreino)) {
	                novosTreinos.add(t);
	            }
	        }
	        // Atualiza a lista de treinos do aluno
	        aluno.setTreinos(novosTreinos);
	        usuarioRepository.atualizarDados(aluno);
	    }
	}
	
	//-------------------------------------------------
	
	
	public void associarTreinoAluno(String cpfAluno, String nomeTre, Usuario solicitante) {
		
		
		Aluno aluno = (Aluno) usuarioService.buscarPorCpf(cpfAluno);
		Treino treino= treinoRepository.buscarPorNome(nomeTre);
		
		 if (aluno == null) throw new IllegalArgumentException("Aluno não encontrado");
		 
		 aluno.adicionarTreino(treino);
		 usuarioRepository.atualizarDados(aluno);
	}
	
	
	

}
