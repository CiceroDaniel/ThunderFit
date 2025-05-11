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
		private List<RegistroPeso> historicoPeso = new ArrayList<>();
		
		private String datanascimento;
		private String datainicio;
		
		private Genero genero;//genero do tipo Genero
		

		private double imc;
		
		
		//**--------------CONSTRUTOR----------------------**//                                                                                                                                                                                                                                                                                                                                  
			
	   //TELA DE CADASTRO ALUNO
		public Aluno(String nome,String email,String senha,String cpf) {
			super(nome, email, senha,cpf);
			
			
		}

		public Aluno(String nome,String email, String senha,String cpf,LocalDate dataDeNascimento, double altura, double peso,Nivel nivel, Metas metas,String metaPersonalizada,Plano plano,Genero genero) {
		super(nome,email,senha,cpf,dataDeNascimento);
			this.setAltura(altura);
			this.setPeso(peso);
			this.setNivel(nivel);
			this.setMetas(metas);
			this.setMetaPersonalizada(metaPersonalizada); 
			this.setPlano(plano);
			this.treinos = new ArrayList<>();
			this.genero = genero;
			this.imc= peso/(altura * altura);
			}
		

		@Override
		public String gerarCredenciaisCadastro() {
			return String.format("Nome:%s\nEmail:%s\nSenha:%s\nCPF:%s\n",
					this.getNome(),this.getEmail(),this.getSenha(),this.getCpf());
			}
		
		//@Override
		public String gerarCredenciaisLogin() {
			return String.format("\nAltura: %.2f \nPeso: %.2f\nGenero:%s\nMetas:%s\nPlano:%s\nData de inicio:%s\nData de Nascimento:%s\nIMC: %.f",
					this.getAltura(),this.getPeso(),this.getGenero(),this.getMetas(),this.getPlano(),this.getDatainicio(),this.getDatanascimento(),this.getImc());
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
		/*protected void adicionarTreino(Treino treino) { // sera usado pelo tutor
			Objects.requireNonNull(treino,"Erro: Treino não pode ser nulo");

		}*/
		
		public void adicionarTreino(Treino treino) { // sera usado pelo tutor
			Objects.requireNonNull(treino," Treino não pode ser nulo");
			 for (Treino t : treinos) {
			        if (t.getNome().equalsIgnoreCase(treino.getNome())) {
			            throw new IllegalArgumentException("Já existe um treino com o nome!");
			        }
			    }

			this.treinos.add(treino);
		}
		
		public void registrarPeso(double peso, LocalDate data) {
			if (peso <= 0) {
		        throw new IllegalArgumentException("Peso inválido: " + peso);
		    }
		    if (data.isAfter(LocalDate.now())) { // Não permitir datas futuras
		        throw new IllegalArgumentException("Data não pode ser futura: " + data);
		    }
	        this.historicoPeso.add(new RegistroPeso(data, peso));
	        this.peso = peso; // Atualiza o peso atual do aluno
	        this.imc = peso / (altura * altura); // Atualiza o IMC
	    }
		
		
		//*-----------------------GETTERS AND SETTERS--------------------
		
		public double getAltura() {
			return altura;
		}
		public void setAltura(double altura) {
			if(altura<=0) {
				throw new IllegalArgumentException("Erro: Altura invalido! "+altura);
				}
			this.altura = altura;
			}
			
		public double getPeso() {
			return peso;
		}
		public void setPeso(double peso) {
			if(peso<=0) {
				throw new IllegalArgumentException("Erro: Peso invalido! "+peso);
			}
			this.peso = peso;
		}
		public Plano getPlano() {
			return plano;
		}
		public void setPlano(Plano plano) {
			if(plano == null) {
				throw new IllegalArgumentException("Erro: Plano não pode ficar vazio! "+plano);
			}
			this.plano = plano;
			}
		
		public Metas getMetas() {
			return metas;
		}
		public void setMetas(Metas metas) {
			if(metas == null) {
				throw new IllegalArgumentException("Erro: Metas não pode ficar vazio! "+metas);
			}
			this.metas = metas;
			}

		public String getMetaPersonalizada() {
			return metaPersonalizada;
		}

		public void setMetaPersonalizada(String metaPersonalizada) {
			if(metas == metas.personalizada) {
				if(metaPersonalizada == null || metaPersonalizada.isBlank()) {
					throw new IllegalArgumentException("Erro: Descrição invalida! "+metaPersonalizada);
				}
			}
			this.metaPersonalizada=metaPersonalizada;
		}
		
		public void setNivel(Nivel nivel) {
		//NÃO CONSIGO IMPLEMENTAR ISSO
			/*
			if(nivel == null) {
				throw new IllegalArgumentException("Erro: Nível invalido! "+nivel);
			}*/
		 this.nivel=nivel;
		}

		
       //TESTE DE ENUM PARA VALORES DEFINIDOS E IMUTAVEIS
		public Genero getGenero() {
			return genero;
		}

		public void setGenero(Genero genero) {
			if(genero == null) {
				throw new IllegalArgumentException("Erro:Genero invalido"+genero);
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
		
		
		public Nivel getNivel() {
			return nivel;
		}
		
		public List<Treino> getTreinos(){
			return new ArrayList<>(treinos);
		}
		public List<RegistroPeso> getHistoricoPeso() {
		    List<RegistroPeso> copia = new ArrayList<>(historicoPeso);
		    copia.sort((r1, r2) -> r1.getData().compareTo(r2.getData())); // Ordena por data
		    return copia;
		}

}
