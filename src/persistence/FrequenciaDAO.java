package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Frequencia;

public class FrequenciaDAO {
	
	protected static final String SELECT_NUM_AULA_POR_CODIGO = "SELECT num_aula FROM disciplina WHERE codigo = ?";
	protected static final String CALL_SP_INSERIR_FALTA = "CALL SP_INSERIR_FALTA ?, ?, ?, ?";
	protected static Connection con = ConnectionSingleton.getInstance().getConnection();
	
	public static int quantidadeAulaPorMateria(String materia) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement(SELECT_NUM_AULA_POR_CODIGO);
		int prepPs = 0;
		ps.setString(++prepPs, materia);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			return rs.getInt("num_aula");
		}else {
			return 0;
		}
	}
	
	public static void inserirFalta(Frequencia frequencia) throws SQLException {
		CallableStatement cs = con.prepareCall(CALL_SP_INSERIR_FALTA);
		int prepCs = 0;
		
		cs.setString(++prepCs, frequencia.getRa());
		cs.setString(++prepCs, frequencia.getMateria());
		cs.setString(++prepCs, frequencia.getData());
		cs.setString(++prepCs, frequencia.getFalta());
		cs.execute();
		cs.close();
		
	}
	
}
