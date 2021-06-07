package model;

public class Frequencia extends Aluno {

	protected String falta;
	protected String materia;
	protected String data;
	
	public Frequencia(String ra) {
		super(ra);
	}
	
	public Frequencia(String ra, String falta, String materia, String data) {
		super(ra);
		this.falta = falta;
		this.materia = materia;
		this.data = data;
	}

	public String getFalta() {
		return falta;
	}

	public String getMateria() {
		return materia;
	}

	public String getData() {
		return data;
	}

}
