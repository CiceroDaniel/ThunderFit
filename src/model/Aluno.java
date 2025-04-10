package model;

public class Aluno extends Usuario {
	//================================================================//
	//============================ATRIBUTOS===========================//
	//================================================================//
	
		private double altura;
		private double peso;
		private String objetivo;
		private Plano plano;
		
		
	//================================================================//
	//================================================================//
	//================================================================//
		
	//================================================================//
	//===========================CONSTRUTOR===========================//
	//================================================================//
	    
	    
	    public Aluno(String nome, String cpf, String email, double altura, double peso, String objetivo, Plano plano) {
		super(nome, cpf, email);
		this.altura = altura;
		this.peso = peso;
		this.objetivo = objetivo;
		this.plano = plano;
	}


		/*
		public Aluno(String nome, String cpf, String email, double altura, double peso, String objetivo,Plano plano) {
			super(nome,cpf,email);
			this.altura = altura;
			this.peso = peso;
			this.objetivo = objetivo;
			this.plano= plano;
		}*/
		
	//================================================================//
	//================================================================//
	//================================================================//
	 
	//================================================================//
	//=======================GETTERS E SETTERS========================//
	//================================================================//
	    
		public double getAltura() {
			return altura;
		}


		public void setAltura(double altura) {
			this.altura = altura;
		}


		public double getPeso() {
			return peso;
		}


		public void setPeso(double peso) {
			this.peso = peso;
		}


		public String getObjetivo() {
			return objetivo;
		}


		public void setObjetivo(String objetivo) {
			this.objetivo = objetivo;
		}


		public Plano getPlano() {
			return plano;
		}


		public void setPlano(Plano plano) {
			this.plano = plano;
		}


	    
	//================================================================//
	//================================================================//
	//================================================================//
	   
		
		
		@Override
		public String gerarCredenciais() {
			return "Nome:" +nome+"\nCPF: "+cpf+"\nEmail: "+email+"\nAltura: "+altura+"\nPeso: "+peso+"\nObjetivo: "+objetivo+"\nInformaçoes do Plano\n"+plano.mostrarDetalhes();
		}
	

		@Override
		public boolean temAcessoAdmin() {
			return false;
		}


		public Object getSenha() {
			// TODO Auto-generated method stub
			return null;
		}
		
		/*
		public double getAltura() {
			return altura;
		}
		public void setAltura(double altura) {
			this.altura = altura;
		}
		public double getPeso() {
			return peso;
		}
		public void setPeso(double peso) {
			this.peso = peso;
		}
		public String getObjetivo() {
			return objetivo;
		}
		public void setObjetivo(String objetivo) {
			this.objetivo = objetivo;
		}
		public Plano getPlano() {
			return plano;
		}
		public void setPlano(Plano plano) {
			this.plano = plano;
		}
		*/
		/*
		// Método para verificar se o email e a senha batem
	    public boolean verificarLogin(String email, String senha) {
	        return this.email.equals(email) && this.senha.equals(senha);
	    }*/
}
