package model;

public class Nota extends Aluno {

	protected int codigoAvaliacao;
	protected Double nota;
	
	public Nota(String ra) {
		super(ra);
	}

	public Nota(String ra, int codigoAvaliacao, Double nota) {
		super(ra);
		this.codigoAvaliacao = codigoAvaliacao;
		this.nota = nota;
	}

	public int getCodigoAvaliacao() {
		return codigoAvaliacao;
	}

	public Double getNota() {
		return nota;
	}
		
}
