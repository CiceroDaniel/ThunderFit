package model;

public class Exercicio {
	private String nome;
	private String grupoMuscular;
	private String equipamento;
	private String variacao;
	
	public Exercicio(String nome, String grupoMuscular, String equipamento, String variacao) {
		this.nome=nome;
		this.grupoMuscular= grupoMuscular;
		this.equipamento= equipamento;
		this.variacao= variacao;
	}
	
	//------------------ Metodos ------------------------
	
	public String getDescricaoCompleta() {
		return String.format("%s (%S) - %s - Variacão: %s", nome, grupoMuscular, equipamento,variacao);
	}
	
	@Override
	public String toString() {
		return getDescricaoCompleta();
		
	}
	
	//------------------------- Getters and Setters ---------------------------
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGrupoMuscular() {
		return grupoMuscular;
	}
	
	public void setGrupoMuscular(String grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}
	
	public String getEquipamento() {
		return equipamento;
	}
	
	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}
	
	public String getVariacao() {
		return variacao;
	}
	
	public void setVariacao(String variacao) {
		this.variacao = variacao;
	}
	
	
	
}
