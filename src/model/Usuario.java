package model;

import java.util.UUID;

/*import java.time.format.DateTimeFormatter;*/

public abstract class Usuario{
	//**----------------VARIÀVEIS-------------------**//
		protected String nome;
		protected String cpf;
		protected String email;
		private String senha;
		
		//protected LocalDate dataDeNascimento;
		//protected Endereco endereco;
		protected boolean status;	
		//protected LocalDate dataDeCadastro;
		
		
		//**--------------CONSTRUTOR----------------------**//
		public Usuario(String nome, String cpf, String email, String senha) {
			this.setNome(nome);
			this.setCpf(cpf);
			this.setEmail(email);
			this.setSenha(senha);
			//this.dataDeCadastro = LocalDate.now();
			this.status = true;
		}
		
		//**---------------METODOS ABSTRATOS--------------**//
		public abstract String gerarCredenciais();
		public abstract boolean temAcessoAdmin();
		
		//**--------------METODOS CONCRETOS-------------------**//
		public void desativarUsuario() {
			if(!this.status) {
				throw new IllegalArgumentException("Usuario ja está desativado");
			}
			this.status = false;
		}
		
		public void ativarUsuario() {
			if(this.status) {
				throw new IllegalArgumentException("Usuario ja está ativo");
			}
			this.status = true;
			
		}
		
		public void atualizarEmail(String novoEmail) {
			if(novoEmail != null && !novoEmail.isBlank()) {
				this.email = novoEmail;
			}
		}
		
		private boolean validarCpf(String cpf){
			return !cpf.matches("(\\d)\\1{10}");
		}
		
		/*public int calcularIdade() {
			if(dataDeNascimento == null) {
				System.out.println("data de nascimento nao foi definida");
			}
			return LocalDate.now().getYear() - dataDeNascimento.getYear();
		}*/
		
		
		//**---------------GETTERS E SETTERS------------------**//
		
		public String getNome() {
			return nome;
		}
		
		public final void setNome(String nome) {
			if(nome == null || nome.trim().isEmpty() || nome.length() < 3) {
				throw new IllegalArgumentException("Erro: Nome invalido!");
			}
			this.nome = nome.trim();
		}

		public String getCpf() {
			return cpf;
		}
		
		public final void setCpf(String cpf) {
			String limpaCpf = cpf.replaceAll("[^0-9]", "");
			if(limpaCpf.length() != 11 || !validarCpf(cpf)) {
				throw new IllegalArgumentException("Erro: CPF invalido!");
			}
			this.cpf = limpaCpf;
		}

		public String getEmail() {
			return email;
		}

		public final void setEmail(String email) {
			if(email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$")) {
				throw new IllegalArgumentException("Erro: Email invalido!");
			}
			this.email = email.toLowerCase();
		}

		
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			if(senha == null || senha.length() < 8) {
				throw new IllegalArgumentException("Erro: Senha deve ter no minimo 8 caracteres!");
			}
			this.senha=senha;
			
		}
		
		
		public boolean getAtivo() {
			return status;
		}

		
	}