package model;

import java.util.List;
import java.util.Objects;
import java.time.LocalDate;
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
		
		
		//**--------------CONSTRUTOR----------------------**//
		
		public Aluno(String nome, String cpf, String email,String senha,LocalDate dataDeNascimento ,double altura, double peso,Nivel nivel, Metas metas,String metaPersonalizada,Plano plano) {
			super(nome,cpf,email,senha,dataDeNascimento);
			this.setAltura(altura);
			this.setPeso(peso);
			this.setNivel(nivel);
			this.setMetas(metas);
			this.setMetaPersonalizada(metaPersonalizada); 
			this.setPlano(plano);
			this.treinos = new ArrayList<>();
		}
		
		//*----------------METODOS--------------
		
		@Override
		public String gerarCredenciais() {
			return String.format("Nome: %s\nCPF: %s\nEmail: %s\nAltura: %.2fm \nPeso: %.2fkg\nNivel: %s\nMetas:  %s, Descrição: %s\nInformaçoes do Plano\n%s \nValor: R$%.2f ",
					this.getNome(),this.getCpf(),this.getEmail(),this.getAltura(),this.getPeso(),this.nivel.name(),this.metas.name(),this.metaPersonalizada,this.plano.getNome(),this.plano.getValor());
			}
		
		@Override
		public boolean temAcessoAdmin() {
			return false;
		}
		
		public void adicionarTreino(Treino treino) { // sera usado pelo tutor
			Objects.requireNonNull(treino," Treino não pode ser nulo");
			 for (Treino t : treinos) {
			        if (t.getNome().equalsIgnoreCase(treino.getNome())) {
			            throw new IllegalArgumentException("Já existe um treino com o nome!");
			        }
			    }
			
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
		public Nivel getNivel() {
			return nivel;
		}
		
		public List<Treino> getTreinos(){
			return new ArrayList<>(treinos);
		}
}
