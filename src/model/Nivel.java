package model;

public enum Nivel {
	INICIANTE("Iniciante"),INTERMEDIARIO("Intermediario"),AVANCADO("Avançado");
	
	private final String descricao;
	
	Nivel(String descricao) {
		this.descricao=descricao;
	}

}
