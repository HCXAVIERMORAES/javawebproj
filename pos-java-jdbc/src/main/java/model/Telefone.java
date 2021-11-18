package model;

public class Telefone {
	//classe modelo de telefone, os atributos são os mesmos da tabela telefoneuser do BD
	private long id;
	private String numero;
	private String tipo;
	private Long usuariopessoa;
	
	//get set
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getUsuariopessoa() {
		return usuariopessoa;
	}
	public void setUsuariopessoa(Long usuariopessoa) {
		this.usuariopessoa = usuariopessoa;
	}
	
	//tostring
	@Override
	public String toString() {
		return "Telefone [id = " + id + ", numero= " + numero + ", tipo= " + tipo + ", usuariopessoa= " + usuariopessoa
				+ "]";
	}
	
}
