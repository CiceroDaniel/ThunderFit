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

}
