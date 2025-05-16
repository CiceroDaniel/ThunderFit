package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.Presenca;
import model.Aluno;


public class PresencaRepository implements InterfaceRepository<Presenca>{
    //LISTA DE PRESENÇA
	private final List<Presenca> presencas = new ArrayList<>();

	@Override
	public void cadastro(Presenca presenca) {//registra entrada
	Objects.requireNonNull(presenca,"Presença não pode ser nulo");
	presencas.add(presenca);
	
	}

	public List<Presenca> listarTodosPorAluno(String cpfAluno){
		return presencas.stream().filter(p->p.getAluno().getCpf().equals(cpfAluno)).toList();
		
	}
	public int contarPresencas(String cpfAluno) {
        return (int) presencas.stream().filter(p -> p.getAluno().getCpf().equals(cpfAluno)).count();
    }
	
	
	
	@Override
	public List<Presenca> listarTodos() {
		return new ArrayList<>(presencas);
	}

	@Override
	public List<Presenca> buscarPorNomeLista(String nome) {
		 throw new UnsupportedOperationException("Funcionalidade não implementada!");//Nao necessaria para esta classe
	}

	@Override
	public Presenca buscarPorNome(String nome) {
		 throw new UnsupportedOperationException("Funcionalidade não implementada!");//Nao necessaria para esta classe
	}
	
	
	
}
