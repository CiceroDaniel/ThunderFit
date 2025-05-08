package model;
//PROVAVELMENTE ESSA CLASSE TAMBEM SERA USADA PARA OS TUTORES
public class Catraca {
	
	private boolean liberada;
	
	//AQUI A CATRACA ESTÁ BLOQUEADA
	public Catraca() {
		this.liberada = false;
	}
	
	public void liberar() {
		this.liberada = true;
		System.out.println("Catraca foi liberada");
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
	public boolean passar(Aluno aluno,SistemadePresença sistema) {

	if(liberada) {
        //ADICIONA A PRESENÇA DO ALUNO
		sistema.registrarEntrada(aluno);
		
		//DEPOIS QUE O ALUNO PASSAR,A CATRACA É BLOQUEADA
		bloquear();
		return true;
		
	}else {
		System.out.println("");
		return false;
	}
		
		
	}

}
