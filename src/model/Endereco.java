package model;

public class Endereco {
	
	//**----------------VARIÀVEIS-------------------**//
		private String rua;
		private String numero;
		private String cidade;
	//**--------------CONSTRUTOR----------------------**//
		public Endereco(String rua, String numero, String cep, String cidade, String estado) {
			this.rua = rua;
			this.numero = numero;
			this.cidade = cidade;
		}
	
		public String getRua() {
			return rua;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		
}
