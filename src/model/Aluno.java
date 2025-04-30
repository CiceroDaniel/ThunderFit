package model;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Aluno extends Usuario {
	//**----------------VARIÀVEIS-------------------**//
		private double altura;
		private double peso;
		private Metas metas;
		
		private String metaPersonalizada;
		
		private Plano plano;
		private Nivel nivel;
		private List<Treino> treinos;
		
		private String datanascimento;
		private String datainicio;
		
		private Genero genero;//genero do tipo Genero
		
		
		//**--------------CONSTRUTOR----------------------**//
		
		
		
		public Aluno(String nome,String email,String senha) {
			super(nome, email, senha, null);
			this.altura=0;
			this.peso=0;
			this.metas=metas.personalizada;
			this.metaPersonalizada="";
			this.nivel=nivel.INICIANTE;
			this.genero=genero.OUTRO;
			this.plano=plano.planoMensal;
			
			/*FOI NESCESSARIO INICIALIZADOS,VERIFIQUE A INTERFACE CADASTRAR*/
			/*OS SETTERS DO ALUNO ESTÃO SENDO VERIFICADOS NO SWING,PREENCHAM TUDO E TESTEM POR SOMENTE UM DIGITO NA SENHA OU NOME E VERIFIQUEM NO CONSOLE*/
			
			
		}
		


		public Aluno(String nome, String cpf, String email,String senha, double altura, double peso,Nivel nivel, Metas metas,String metaPersonalizada,Plano plano,String datanascimento,String datainicio,Genero genero) {
			super(nome,cpf,email,senha);
			this.setAltura(altura);
			this.setPeso(peso);
			this.setNivel(nivel);
			this.setMetas(metas);
			this.setMetaPersonalizada(metaPersonalizada); 
			this.setPlano(plano);
			this.treinos = new ArrayList<>();
			this.datanascimento=datanascimento;
			this.datainicio=datainicio;
			this.genero = genero;
			}
		
		//*----------------METODOS--------------



		@Override
		public String gerarCredenciaisCadastro() {
			return String.format("Nome: %s\nEmail: %s\nSenha:%s",
					this.getNome(),/*this.getCpf()*/this.getEmail(),this.getSenha());
			}
		
		@Override
		public String gerarCredenciaisLogin() {
			return String.format("Nome: %s\nEmail: %s\nAltura: %.2fm \nPeso: %.2fkg\nNivel: %s\nMetas:  %s, Descrição: %s\nInformaçoes do Plano\n%s \nValor: R$%.2f ",
					this.getNome(),/*this.getCpf()*/this.getEmail(),this.getAltura(),this.getPeso(),this.nivel.name(),this.metas.name(),this.metaPersonalizada,this.plano.getNome(),this.plano.getValor());
			}
		
		@Override
		public boolean temAcessoAdmin() {
			return false;
		}
		//REVER
		protected void adicionarTreino(Treino treino) { // sera usado pelo tutor
			Objects.requireNonNull(treino,"Erro: Treino não pode ser nulo");
			this.treinos.add(treino);
		}
		
		public void calcularImc() {
			
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
			if(metas == metas.personalizada) {
				if(metaPersonalizada == null || metaPersonalizada.isBlank()) {
					throw new IllegalArgumentException("Erro: Descrição invalida!");
				}
			}
			this.metaPersonalizada=metaPersonalizada;
		}
		
		public void setNivel(Nivel nivel) {
			if(nivel == null) {
				throw new IllegalArgumentException("Erro: Nível invalido!");
			}
			this.nivel=nivel;
		}
		
       //TESTE DE ENUM PARA VALORES DEFINIDOS E IMUTAVEIS
		public enum Genero {
		  MASCULINO,FEMININO,OUTRO	
		}
		
		public Genero getGenero() {
			return genero;
		}

		public void setGenero(Genero genero) {
			if(genero == null) {
				throw new IllegalArgumentException("Erro");
			}
			this.genero=genero;
		}
		
		
		
}
