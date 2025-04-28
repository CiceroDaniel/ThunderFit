package model;

public class Aluno extends Usuario {
	//private static String ;
	//================================================================//
	//============================ATRIBUTOS===========================//
	//================================================================//
	
		private double altura;
		private double peso;
		private String objetivo;
		private String datanascimento;
		private String datainicio;
		private Plano plano;
		
	
		
	//================================================================//
	//================================================================//
	//================================================================//
		
	//================================================================//
	//===========================CONSTRUTOR===========================//
	//================================================================//
		
		//CONSTRUTOR QUE SERA CHAMADO NO CAD
		public Aluno(String nome,String email,String senha) {
			super(nome,email,senha,null);
			this.altura=0;
			this.peso=0;
			this.objetivo="não definido";
			//this.plano = new Plano();
		}
  
		


	public Aluno(String nome, String email, String senha, String cpf, double altura, double peso, String datanascimento,
		String datainicio) {
		super(nome, email, senha, cpf);
		this.altura = altura;
		this.peso = peso;
		this.datanascimento = datanascimento;
		this.datainicio = datainicio;
	}




	public Aluno(String nome, String email, String senha, String cpf, double altura, double peso, String objetivo,
		String datanascimento, String datainicio, Plano plano) {
		super(nome, email, senha, cpf);
		this.altura = altura;
		this.peso = peso;
		this.objetivo = objetivo;
		this.datanascimento = datanascimento;
		this.datainicio = datainicio;
		this.plano = plano;
	}

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
	   
		
		/*
		@Override
		public String gerarCredenciais() {
			return "Nome:" +nome+"\nCPF: "+cpf+"\nEmail: "+email+"\nAltura: "+altura+"\nPeso: "+peso+"\nObjetivo: "+objetivo+"\nInformaçoes do Plano\n"+plano.mostrarDetalhes();
		}
	

		@Override
		public boolean temAcessoAdmin() {
			return false;
		}
*/

		
		/*
		// Método para verificar se o email e a senha batem
	    public boolean verificarLogin(String email, String senha) {
	        return this.email.equals(email) && this.senha.equals(senha);
	    }*/
}
