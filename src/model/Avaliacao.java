package model;

public class Avaliacao {

	protected String codigo;
	protected String tipo;
	
	public Avaliacao(String codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
