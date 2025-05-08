package model;

public enum Genero {
	
	
  MASCULINO("Masculino"),FEMININO("Feminino"),OUTRO("Outro");
	  private final String descricao;
		
		Genero(String descricao) {
			this.descricao=descricao;
  }
}