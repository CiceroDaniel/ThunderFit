package model;

public class Aluno extends Usuario {
	//**----------------VARIÀVEIS-------------------**//
		private double altura;
		private double peso;
		private Metas metas;
		private String metaPersonalizada;
		private Plano plano;
		
		//**--------------CONSTRUTOR----------------------**//
		public Aluno(String nome, String cpf, String email, double altura, double peso, Metas metas,Plano plano) {
			super(nome,cpf,email);
			this.altura = altura;
			this.peso = peso;
			this.metas = metas;
			this.plano= plano;
		}
		
		public Aluno(String nome, String cpf, String email, double altura, double peso, Metas metas,String metaPersonalizada,Plano plano) {
			super(nome,cpf,email);
			this.altura = altura;
			this.peso = peso;
			this.metas = metas;
			this.metaPersonalizada= (metas == Metas.personalizada) ? metaPersonalizada : null; //operador ternario(simplifica o if)
			this.plano= plano;
		}
		
		@Override
		public String gerarCredenciais() {
			return "Nome:" +nome+"\nCPF: "+cpf+"\nEmail: "+email+"\nAltura: "+altura+"\nPeso: "+peso+"\nMetas: "+metas+" , Descrição: "+metas.descricao+"\nInformaçoes do Plano\n"+plano.mostrarDetalhes();
		}
		
		@Override
		public boolean temAcessoAdmin() {
			return false;
		}
		
		
		
		
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
		public Plano getPlano() {
			return plano;
		}
		public void setPlano(Plano plano) {
			this.plano = plano;
		}
}
