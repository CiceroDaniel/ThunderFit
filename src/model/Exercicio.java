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
	
	public String getDescricaoCompleta() {
		return String.format("%s (%S) - %s - Variacão: %s", nome, grupoMuscular, equipamento,variacao);
	}
	

}
