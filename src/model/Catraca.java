package model;


public class Catraca {
	
	private boolean liberada;
	
	//AQUI A CATRACA ESTÁ BLOQUEADA
	public Catraca() {
		this.liberada = false;
	}
	
	public boolean liberar(Aluno aluno) {
		if(aluno == null) {
			return false;
		}
		
		this.liberada = true;
		return true;
	}
	
	public void bloquear() {
		this.liberada = false;
		System.out.println("Catraca está bloqueada");
	}
	
	public boolean estaLiberada() {
		return liberada;
	}
	
	//=========================================//
	//=================METODOS=================//
	//=========================================//
	
	
	//NESSA PARTE O ALUNO ESTÁ PASSANDO PELA CATRACA
	/*public boolean passar(Aluno aluno,PresencaRepository presencaRepo) {// responsabilidade do service,devo APAGAR ~VICTOR

	if(liberada) {
        //ADICIONA A PRESENÇA DO ALUNO
		//sistema.registrarEntrada(aluno);
		
		//DEPOIS QUE O ALUNO PASSAR,A CATRACA É BLOQUEADA
		bloquear();
		return true;
		
	}else {
		System.out.println("");
		return false;
	}
		
		
	}*/

}
