package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Nota;
import model.Avaliacao;

public class NotasDAO {

	protected static final String SELECT_AVALIACAO_POR_COD_DISCIPLINA = "SELECT codigo, tipo FROM avaliacao WHERE codigo_disciplina = ?";
	protected static final String CALL_SP_INSERIR_NOTA = "CALL SP_INSERIR_NOTA ?, ?, ?";
	
	protected static Connection con = ConnectionSingleton.getInstance().getConnection();
	
	public static ArrayList<Avaliacao> listarProvas(String materia) throws SQLException{
		ArrayList<Avaliacao> avaliacaos = new ArrayList<Avaliacao>();
		
		PreparedStatement ps = con.prepareStatement(SELECT_AVALIACAO_POR_COD_DISCIPLINA);
		
		int posPs = 0;
		ps.setString(++posPs, materia);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Avaliacao n = new Avaliacao(rs.getString("codigo"), rs.getString("tipo"));
			avaliacaos.add(n);
		}
		rs.close();
		ps.close();
		
		return avaliacaos;
	}
	
	public static void inserirNota(Nota nota) throws SQLException {
		CallableStatement cs = con.prepareCall(CALL_SP_INSERIR_NOTA);
		
		int posPc = 0;
		cs.setString(++posPc, nota.getRa());
		cs.setInt(++posPc, nota.getCodigoAvaliacao());
		cs.setDouble(++posPc, nota.getNota());
		cs.execute();
		cs.close();
	}
	
}
