package model;

public class Aluno extends Usuario {
	//**----------------VARIÀVEIS-------------------**//
		private double altura;
		private double peso;
		private Metas metas;
		private String metaPersonalizada;
		private Plano plano;
		
		//**--------------CONSTRUTOR----------------------**//
		
		public Aluno(String nome, String cpf, String email,String senha, double altura, double peso, Metas metas,String metaPersonalizada,Plano plano) {
			super(nome,cpf,email,senha);
			this.setAltura(altura);
			this.setPeso(peso);
			this.setMetas(metas);
			this.setMetaPersonalizada((metas == Metas.personalizada) ? metaPersonalizada : null); //operador ternario(simplifica o if)
			this.setPlano(plano);
		}
		
		//*----------------METODOS--------------
		
		@Override
		public String gerarCredenciais() {
			return "Nome:" +nome+"\nCPF: "+cpf+"\nEmail: "+email+"\nAltura: "+altura+"\nPeso: "+peso+"\nMetas: "+metas+" , Descrição: "+metas.getDescricao()+"\nInformaçoes do Plano\n"+plano.getNome()+" , Valor: "+plano.getValor();
		}
		
		@Override
		public boolean temAcessoAdmin() {
			return false;
		}
		
		
		
		//*----------------------ENUM'S---------------------------
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
		
		public enum Plano{
			planoMensal("Plano mensal",100), planoTrimestral("Plano trimestral",280),planoAnual("Plano anual",1000);
			
			private final String nome;
			private double valor;

			Plano(String nome, double valor) {
				this.nome=nome;
				this.valor=valor;
			}
			
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
		
		
		
		
		//*-----------------------GETTERS AND SETTERS--------------------
		
		public double getAltura() {
			return altura;
		}
		public void setAltura(double altura) {
			if(altura<=0) {
				throw new IllegalArgumentException("Erro: Altura invalido!");
				}
			this.altura = altura;
			}
			
		public double getPeso() {
			return peso;
		}
		public void setPeso(double peso) {
			if(peso<=0) {
				throw new IllegalArgumentException("Erro: Peso invalido!");
			}
			this.peso = peso;
		}
		public Plano getPlano() {
			return plano;
		}
		public void setPlano(Plano plano) {
			if(plano == null) {
				throw new IllegalArgumentException("Erro: Plano não pode ficar vazio!");
			}
			this.plano = plano;
			}
		
		public Metas getMetas() {
			return metas;
		}
		public void setMetas(Metas metas) {
			if(metas == null) {
				throw new IllegalArgumentException("Erro: Metas não pode ficar vazio!");
			}
			this.metas = metas;
			}

		public String getMetaPersonalizada() {
			return metaPersonalizada;
		}

		public void setMetaPersonalizada(String metaPersonalizada) {
			this.metaPersonalizada = metaPersonalizada;
		}
}
