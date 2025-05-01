package model;

import java.util.ArrayList;
import java.util.List;

public class SistemadePresença {
    //LISTA DE PRESENÇA
	private List<RegistroPresenca> registros;//(nome da lista);
	
	//OBJETOS TIPO REGISTROPRESENCA
	
	public SistemadePresença() {
		this.registros = new ArrayList<>();
	}
	
	
	//=========================================//
	//=================METODOS=================//
	//=========================================//
	
	//ADICIONA PRESENÇA AO LIST
	public void registrarEntrada(Aluno aluno) {
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
	}

	
	
}
