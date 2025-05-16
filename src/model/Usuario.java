package model;

//CLASSE PAI


import java.time.LocalDate;
import java.time.Period;

public abstract class Usuario{
	//**----------------VARIÀVEIS-------------------**//
		protected String nome;
		protected String email;
		private String senha;
		protected String cpf;
		
		
		protected boolean status;
        protected boolean online;
		protected LocalDate dataDeNascimento;
		protected LocalDate dataDeCadastro;
		
		//**--------------CONSTRUTOR----------------------**//
		
		public Usuario(String nome, String email, String senha,String cpf) {
			
		this.nome=nome;
		this.email=email;
		this.senha=senha;
		this.cpf=cpf;
		
		
		
		LocalDate dataDeNascimento;//protected
		boolean online;//protected	
		LocalDate dataDeCadastro;//protected
		
		}
		//**--------------CONSTRUTOR----------------------**//
		public Usuario(String nome, String email, String senha,String cpf, LocalDate dataDeNascimento) {

			this.setNome(nome);
			this.setEmail(email);
			this.setSenha(senha);
			this.setCpf(cpf);
			

			this.status = true;
			this.setDataDeNascimento(dataDeNascimento);
			this.dataDeCadastro = LocalDate.now();
			this.online = false;

		}
		
		//**---------------METODOS ABSTRATOS--------------**//
		public abstract String gerarCredenciaisCadastro();
		public abstract String gerarCredenciaisLogin();
		public abstract boolean temAcessoAdmin();
		
		//**--------------METODOS CONCRETOS-------------------**//
		public void desativarUsuario() {
			if (!this.online) {
				throw new IllegalArgumentException("Usuario ja está desativado");
			}
			this.online = false;
		}
		
		public void ativarUsuario() {
			if(this.online) {
				throw new IllegalArgumentException("Usuario ja está ativo");
			}
			this.online = true;
			
		}
		
		public void atualizarEmail(String novoEmail) {
			if(novoEmail != null && !novoEmail.isBlank()) {
				this.email = novoEmail;
			}
		}
		
		private boolean validarCpf(String cpf){
			return !cpf.matches("(\\d)\\1{10}");
		}
		
		public Period calcularIdade() {
			if(dataDeNascimento == null ) {
			throw new IllegalStateException("data de nascimento nao foi definida");
			}
			return Period.between(dataDeNascimento, LocalDate.now());
		}
		
		
		//**---------------GETTERS E SETTERS------------------**//
		
		public String getNome() {
			return nome;
		}
		
		public final void setNome(String nome) {
			if(nome == null || nome.trim().isEmpty() || nome.length() < 3) {
				throw new IllegalArgumentException("Erro: Nome invalido! "+nome);
			}
			this.nome = nome.trim();
		}

		public String getEmail() {
			return email;
		}

		public final void setEmail(String email) {
			if(email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$")) {
				throw new IllegalArgumentException("Erro: Email invalido! "+email);
			}
			this.email = email.toLowerCase();
		}

		
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			if(senha == null || senha.length() < 8) {
				throw new IllegalArgumentException("Erro: Senha deve ter no minimo 8 caracteres! "+senha);
			}
			this.senha=senha;
			
		}
		
		public String getCpf() {
			return cpf;
		}
		
		public final void setCpf(String cpf) {
			String limpaCpf = cpf.replaceAll("[^0-9]", "");
			if(limpaCpf.length() != 11 || !validarCpf(cpf)) {
				throw new IllegalArgumentException("Erro: CPF invalido! "+cpf);
			}
			this.cpf = limpaCpf;
		}
		
		
		public boolean getOnline() {
			return online;
		}


		public String gerarCredenciais() {
			// TODO Auto-generated method stub
			return null;
		}


		public void setOnline(boolean online) {
			this.online= online;
		}
		
		public LocalDate getDataDeCadastro() {
			return dataDeCadastro;
		}
		public void setDataDeCadastro(LocalDate dataDeCadastro) {
			this.dataDeCadastro=dataDeCadastro;
		}
		
		
		public LocalDate getDataDeNascimento() {
			return dataDeNascimento;
		}
		public void setDataDeNascimento(LocalDate dataDeNascimento) {
	        if (dataDeNascimento != null && dataDeNascimento.isAfter(LocalDate.now())) {
	            throw new IllegalArgumentException("Data de nascimento não pode ser no futuro");
	        }
	        this.dataDeNascimento = dataDeNascimento;
		}
		

		
	}