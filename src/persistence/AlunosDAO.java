package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Aluno;

public class AlunosDAO {

	protected static final String SELECT_TODOS_ALUNOS = "SELECT ra, nome FROM aluno";
	protected static Connection con = ConnectionSingleton.getInstance().getConnection();
	
	public static ArrayList<Aluno> listarAlunos() throws SQLException {
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		PreparedStatement ps = con.prepareStatement(SELECT_TODOS_ALUNOS);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Aluno a = new Aluno(rs.getString("ra"), rs.getString("nome"));
			alunos.add(a);
		}
		rs.close();
		ps.close();
		
		return alunos;
	}
	
}
