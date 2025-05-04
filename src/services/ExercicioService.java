package services;

import model.Exercicio;
import repository.ExercicioRepository;
import java.util.List;


public class ExercicioService {
	private final ExercicioRepository exercicioRepository;
	
	public ExercicioService(ExercicioRepository exercicioRepository) {
		this.exercicioRepository =  exercicioRepository;
		this.inicializarExerciciosPadrao();
	}
	
	private void inicializarExerciciosPadrao() {
		if(exercicioRepository.listarTodos().isEmpty()) {
			cadastrarExerciciosPadrao();
		}
	}
	
	//-------------------------- CADASTRO -----------------------------
	
	public void cadastrarExercicio(Exercicio exercicio) {
		
		if(exercicio == null || exercicio.getNome() == null) {
			throw new IllegalArgumentException("Exercicio invalido!");
		}
		
		if(exercicioRepository.buscarPorNome(exercicio.getNome()) != null) {
			throw new IllegalArgumentException("Exercicio já cadastrado");
		}
		
		exercicioRepository.cadastro(exercicio);
	}
	
	
	private void cadastrarExerciciosPadrao() {
		//-----------PEITORAL-------------
		cadastrarExercicio(new Exercicio("Supino reto", "Peitoral", "Barra / Halteres", "Máquina, Smith"));
		cadastrarExercicio(new Exercicio("Supino inclinado", "Peitoral", "Halteres / Barra", "Máquina, Smith"));
		cadastrarExercicio(new Exercicio("Supino declinado", "Peitoral", "Barra", "Máquina"));
		cadastrarExercicio(new Exercicio("Crossover", "Peitoral", "Polia", "Alto, médio, baixo"));
		cadastrarExercicio(new Exercicio("Crucifixo no banco reto", "Peitoral", "Halteres", "Inclinado, declinado"));
		cadastrarExercicio(new Exercicio("Flexão de braço", "Peitoral", "Peso corporal", "Com palmas, inclinada"));
		cadastrarExercicio(new Exercicio("Peck deck", "Peitoral", "Máquina", "-"));

		//-----------COSTAS-------------
		cadastrarExercicio(new Exercicio("Puxada frontal", "Costas", "Polia", "Aberta, fechada, neutra"));
		cadastrarExercicio(new Exercicio("Remada curvada", "Costas", "Barra / Halteres", "Pegada aberta, neutra"));
		cadastrarExercicio(new Exercicio("Remada unilateral", "Costas", "Halteres", "Banco ou ajoelhado"));
		cadastrarExercicio(new Exercicio("Remada baixa", "Costas", "Máquina / Polia", "Pegada aberta ou neutra"));
		cadastrarExercicio(new Exercicio("Barra fixa (pull-up)", "Costas", "Peso corporal", "Supinada, pronada, neutra"));
		cadastrarExercicio(new Exercicio("Pulldown", "Costas", "Polia", "Frente, por trás da cabeça"));
		cadastrarExercicio(new Exercicio("Remada cavalinho (T-bar row)", "Costas", "Barra + suporte", "Com pegada neutra"));


		//-----------PERNAS-------------
		cadastrarExercicio(new Exercicio("Agachamento livre", "Pernas (completo)", "Barra", "Frontal, sumô, com halteres"));
		cadastrarExercicio(new Exercicio("Leg press", "Pernas", "Máquina", "45°, horizontal"));
		cadastrarExercicio(new Exercicio("Cadeira extensora", "Quadríceps", "Máquina", "-"));
		cadastrarExercicio(new Exercicio("Cadeira flexora", "Posterior de coxa", "Máquina", "Sentado ou deitado"));
		cadastrarExercicio(new Exercicio("Stiff", "Posterior / Glúteos", "Barra / Halteres", "Com halteres ou barra"));
		cadastrarExercicio(new Exercicio("Avanço (lunge)", "Quadríceps / Glúteos", "Halteres", "Estático, andando"));
		cadastrarExercicio(new Exercicio("Glute bridge / Hip thrust", "Glúteos", "Peso corporal / Barra", "Banco ou solo"));
		cadastrarExercicio(new Exercicio("Abdução de quadril", "Glúteos / Abdutores", "Máquina", "Em pé ou sentada"));
		cadastrarExercicio(new Exercicio("Agachamento hack", "Pernas / Glúteos", "Máquina", "-"));

		
		//-----------OMBROS-------------
		cadastrarExercicio(new Exercicio("Desenvolvimento militar", "Ombros", "Barra / Halteres", "Sentado, em pé"));
		cadastrarExercicio(new Exercicio("Elevação lateral", "Ombros", "Halteres / Polia", "Sentado, unilateral"));
		cadastrarExercicio(new Exercicio("Elevação frontal", "Ombros", "Halteres / Polia", "Alternado, simultâneo"));
		cadastrarExercicio(new Exercicio("Remada alta", "Ombros", "Barra / Halteres", "Pegada aberta ou fechada"));
		cadastrarExercicio(new Exercicio("Crucifixo inverso (rear delt)", "Ombros", "Máquina / Halteres", "Banco inclinado ou polia"));
		
		
		//-----------OMBROS-------------
		cadastrarExercicio(new Exercicio("Rosca direta", "Bíceps", "Barra", "EZ, reta"));
		cadastrarExercicio(new Exercicio("Rosca alternada", "Bíceps", "Halteres", "Sentado, em pé"));
		cadastrarExercicio(new Exercicio("Rosca concentrada", "Bíceps", "Halteres", "Apoiado na perna"));
		cadastrarExercicio(new Exercicio("Rosca martelo", "Bíceps", "Halteres", "Alternada, simultânea"));
		cadastrarExercicio(new Exercicio("Tríceps testa", "Tríceps", "Barra / Halteres", "EZ, corda na polia"));
		cadastrarExercicio(new Exercicio("Tríceps pulley", "Tríceps", "Polia", "Corda, barra, V-bar"));
		cadastrarExercicio(new Exercicio("Tríceps banco", "Tríceps", "Peso corporal", "Com apoio"));
		cadastrarExercicio(new Exercicio("Mergulho em paralelas", "Tríceps", "Peso corporal", "-"));
		
		
		//-----------ABDOMEN-------------
		cadastrarExercicio(new Exercicio("Abdominal crunch", "Abdômen", "Solo / Máquina", "Solo, banco declinado"));
		cadastrarExercicio(new Exercicio("Elevação de pernas", "Abdômen", "Solo / Barra", "Paralelas, suspenso"));
		cadastrarExercicio(new Exercicio("Prancha", "Abdômen", "Peso corporal", "Frontal, lateral"));
		cadastrarExercicio(new Exercicio("Abdominal na polia", "Abdômen", "Polia", "De joelhos"));
		cadastrarExercicio(new Exercicio("Abdominal infra no banco", "Abdômen", "Banco", "Com peso ou sem"));
		
		
	}
	
	//--------------------------LISTAR------------------------
	
	public List<Exercicio> listarTodosExercicios(){
		return exercicioRepository.listarTodos();
	}
	
	public List<Exercicio> buscarPorGrupoMuscular(String grupo){
		return exercicioRepository.listarGrupoMuscular(grupo);
	}
	
	//------------------------BUSCAR-----------------------
	
	public Exercicio buscarPorNome(String nome) {
		Exercicio exercicio = exercicioRepository.buscarPorNome(nome);
		if(exercicio == null){
			throw new IllegalArgumentException("Exercicio não encontrado!");
		}
		return exercicio;
	}
	
	//---------------------REMOVER-----------------------
	
	public void removerExercicio(String nome) {
		if(!exercicioRepository.removerPorNome(nome)) {
			throw new IllegalArgumentException("Exercicio não encontrado para remoção!");
		}
	}
	
	
		
}
