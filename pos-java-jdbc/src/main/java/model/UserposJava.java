package model;

public class UserposJava {
	/*Crando a classe de modelo, ela possui os mesmos atriburos da tabela userposjava*/
	private long id;
	private String nome;
	private String email;
		
	//get e set
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//toString
	@Override
	public String toString() {
		return "UserposJava [id = " + id + ", nome = " + nome + ", email  = " + email + "]";
	}
	
	
}
