package model;

public class Plano {
	
	
	private String nome;
	private double valorMensal;
	public static final Plano Mensal = new Plano("Plano Mensal",100);
	public static final Plano Trimestral =	new Plano("Plano Trimestral",259);
	public static final Plano Anual =new Plano("Plano Anual",1000);
	
	public Plano(String nome, double valorMensal) {
		this.nome = nome;
		this.valorMensal = valorMensal;
	}
	
	
	
	public String mostrarDetalhes() {
		return "Nome: "+nome+"\nValor Mensal: "+valorMensal;
	}	
	
	public String planosDisponiveis() {
		return "PLANOS DISPONIVEIS\n\n1-- "+Mensal.mostrarDetalhes()+"\n2-- "+Trimestral.mostrarDetalhes()+"\n3-- "+Anual.mostrarDetalhes();
	}

	
	
	//----------------------Getters and Setters----------------------------------
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nomePlano) {
		if(nomePlano != null && !nomePlano.isBlank()) {
			this.nome = nomePlano;
		}
	}
	
	public double getValorMensal() {
		return valorMensal;
	}
	
	public void setValorMensal(double valor) {
		if(valor > 0) {
			this.valorMensal = valor;
		}else {
			System.out.println("VALOR INVALIDO");
		}
	}
}
