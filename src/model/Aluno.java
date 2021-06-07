package model;

public class Aluno {
	
	protected String ra;
	protected String nome;
	
	
	public Aluno(String ra) {
		this.ra = ra;
	}
	
	public Aluno(String ra, String nome) {
		this.ra = ra;
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public String getNome() {
		return nome;
	}	
	
}
