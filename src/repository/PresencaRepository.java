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
		 throw new UnsupportedOperationException("Funcionalidade não implementada!");//Nao necessaria para esta classe
	}

	@Override
	public List<Presenca> buscarPorNomeLista(String nome) {
		 throw new UnsupportedOperationException("Funcionalidade não implementada!");//Nao necessaria para esta classe
	}

	@Override
	public Presenca buscarPorNome(String nome) {
		 throw new UnsupportedOperationException("Funcionalidade não implementada!");//Nao necessaria para esta classe
	}
	
	
	//OBJETOS TIPO REGISTROPRESENCA
	

	
	
	//=========================================//
	//=================METODOS=================//
	//=========================================//
	
	
	
	
	
	
	
	
	
	
	//ADICIONA PRESENÇA AO LIST
	/*public void registrarEntrada(Aluno aluno) {
		RegistroPresenca registro = new RegistroPresenca(aluno);
		registros.add(registro);
		System.out.println("Nome:"+aluno.getNome()+"\nEmail:"+aluno.getEmail()+"\npresença registrada");
	}
	//CALCULAR FREQUENCIA PARA SABER A PRODUTIVIDADE DO ALUNO
	public void calcularFrequencia(Aluno aluno){
		int totalPresencas = 0;//INCIALIZEI
		
		for(RegistroPresenca r : registros) {
		
			if(r.getAluno().getEmail() == aluno.email) {
				totalPresencas++;		
			}
			//PRECISA SER CONCERTADO
			
			
		}
	}
    //AQUI A PRA RETORNAR A LISTA COMPLETA DE REGISTROS
	public List<RegistroPresenca> getRegistros() {
		return registros;
	}
	
	public void mostrarRegistros(Aluno aluno) {
		for(RegistroPresenca r:registros) {
			System.out.println("Nome:"+r.getAluno().getNome()+"Email:"+r.getAluno().getEmail());
		}
	}*/

	
	
}
