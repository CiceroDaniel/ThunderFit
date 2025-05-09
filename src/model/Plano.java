package model;

public enum Plano {
	
	planoMensal("Plano mensal",100), planoTrimestral("Plano trimestral",280),planoAnual("Plano anual",1000);
	
	private final String nome;
	private double valor;

	//---------------- Construtor-----------------

	Plano(String nome, double valor) {
		this.nome=nome;
		this.valor=valor;
	}

	//---------------METODOS------------------------------
	
	public static String mostrarPlanos() {
        return String.format(
                "\n Informações dos Planos:" +
                "\n %s ------ Valor: R$%.2f" +
                "\n %s ------ Valor: R$%.2f" +
                "\n %s ------ Valor: R$%.2f",
                planoMensal.nome, planoMensal.valor,
                planoTrimestral.nome, planoTrimestral.valor,
                planoAnual.nome, planoAnual.valor
            );
	}
	
	//----------------Getters and Setters-----------------
	public String getNome() {
		return nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor, Usuario usuario) {
	    if(usuario == null || !usuario.temAcessoAdmin()) {
	        throw new SecurityException("Acesso negado: apenas administradores podem alterar valores");
	    }
	    this.valor = valor;
	}
	

}
