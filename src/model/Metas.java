package model;

public enum Metas{
	ganharMassa("Ganhar Massa"),perderPeso("Perder peso"),personalizada("Personalizada");
	
	
	private String descricao;
	
	 Metas(String descricao){
		this.descricao=descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
