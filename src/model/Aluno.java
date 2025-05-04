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
		
		private double imc;
		
		
		//**--------------CONSTRUTOR----------------------**//                                                                                                                                                                                                                                                                                                                                  
			
		public Aluno(String nome,String email,String senha,String cpf) {
			super(nome, email, senha,cpf);
			this.altura=0;
			this.peso=0;
			this.metas=metas;
			this.metaPersonalizada=metaPersonalizada;
			this.nivel=nivel;
			this.genero=genero;
			this.plano=plano;
			this.imc=imc;
		
			
		}



		public Aluno(String nome,String cpf, String email,String senha, double altura, double peso,Nivel nivel, Metas metas,String metaPersonalizada,Plano plano,String datanascimento,String datainicio,Genero genero,double imc) {
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
			this.imc=imc;
			}
		
		//*----------------METODOS--------------
		/*
		 * 
		 * 
		 *METODOS QUE PRECISAM SER IMPLEMENTADOS 
		 * 
		 * 
		public double calcularImc() {
		return imc;
		}
		
		public boolean alunoPresente() {
			return false;
		}
		
		public int alunoFrequenecia(){
		
		}
		
		*/
		

		@Override
		public String gerarCredenciaisCadastro() {
			return String.format("Nome:%s\nEmail:%s\nSenha:%s\nCPF: %s",
					this.getNome(),this.getEmail(),this.getSenha(),this.getCpf());
			}
		
		//@Override
		public String gerarCredenciaisLogin() {
			return String.format("\nAltura: %.2f \nPeso: %.2f\nGenero:%s\nMetas:%s\nPlano:%s\nData de inicio:%s\nData de Nascimento:%s",
					this.getAltura(),this.getPeso(),this.getGenero(),this.getMetas(),this.getPlano(),this.getDatainicio(),this.getDatanascimento());
			}
		
		//@Override
		//public String gerarCredenciaisLogin() {
			//return String.format("%s\nAltura: %.2fm \nPeso: %.2fkg\nNivel: %s\nMetas:  %s, Descrição: %s\nInformaçoes do Plano:%s \nValor: R$%.2f ",
				//	this.getNome(),/*this.getCpf()*/this.getEmail(),this.getAltura(),this.getPeso(),this.nivel.name(),this.metas.name(),this.metaPersonalizada,this.plano.getNome(),this.plano.getValor());
			//}
		
		
		@Override
		public boolean temAcessoAdmin() {
			return false;
		}
		//REVER
		protected void adicionarTreino(Treino treino) { // sera usado pelo tutor
			Objects.requireNonNull(treino,"Erro: Treino não pode ser nulo");
			this.treinos.add(treino);
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
		
		

		//TESTE

		public double getImc() {
			return imc;
		}

		public void setImc(double imc) {
			this.imc = imc;
		}

		public String getDatanascimento() {
			return datanascimento;
		}

		public void setDatanascimento(String datanascimento) {
			this.datanascimento = datanascimento;
		}



		public String getDatainicio() {
			return datainicio;
		}



		public void setDatainicio(String datainicio) {
			this.datainicio = datainicio;
		}
		
		
		
}
