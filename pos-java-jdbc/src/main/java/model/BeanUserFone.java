package model;

public class BeanUserFone {
	/*Classe para ajudar a fazer o inner join (já que o sql é muito grande e dificulta a manipulação
	 *O objeto deve armazenar nome, numero e e-mail
	 **/
	
	private String nome;
	private String numero;
	private String email;
	
	//gets e sets
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//to string
	@Override
	public String toString() {
		return "BeanUserFone [nome: " + nome + ", numero: " + numero + ", email: " + email + "]";
	}
	
	

}
