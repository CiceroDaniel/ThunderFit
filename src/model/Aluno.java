package model;

import java.util.List;
import java.util.Objects;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
			return String.format("Nome: %s\nEmail: %s\nSenha: %s\nCPF: %s",
					this.getNome(),this.getEmail(),this.getSenha(),this.getCpf());
			}
		
		//@Override
		public String gerarCredenciaisLogin() {
			
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    String dataCadastroFormatada = this.getDataDeCadastro().format(dateFormatter);
		    String dataNascimentoFormatada = this.getDataDeNascimento().format(dateFormatter);
			
			
			return String.format("Altura: %.2fm \nPeso: %.2fKg\nGenero: %s\nMetas: %s\nPlano: %s\nData de inicio: %s\nData de Nascimento: %s\nIMC: %.2f",
					this.getAltura(),this.getPeso(),this.getGenero(),this.getMetas().name(),this.getPlano().getNome(),dataCadastroFormatada,dataNascimentoFormatada,this.getImc());
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
		
		public void registrarPeso(double peso) {
			if (peso <= 0) {
		        throw new IllegalArgumentException("Peso inválido: " + peso);
		    }
			LocalDate data = LocalDate.now();
	        this.historicoPeso.add(new RegistroPeso(data, peso));
	        this.peso = peso; // Atualiza o peso atual do aluno
	        this.imc = peso / (altura * altura); // Atualiza o IMC
	    }
		
		public boolean removerTreino(String nomeTreino) {
		    return treinos.removeIf(t -> t.getNome().equalsIgnoreCase(nomeTreino));
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
			registrarPeso(peso);
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
		 this.nivel=nivel;
		}

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
		
		
		public Nivel getNivel() {
			return nivel;
		}
		
		public List<Treino> getTreinos(){
			return new ArrayList<>(treinos);
		}
		public void setTreinos(List<Treino> treinos) {
		    this.treinos = new ArrayList<>(treinos);
		}
		public List<RegistroPeso> getHistoricoPeso() {
		    List<RegistroPeso> copia = new ArrayList<>(historicoPeso);
		    copia.sort((r1, r2) -> r1.getData().compareTo(r2.getData())); // Ordena por data
		    return copia;
		}

}
