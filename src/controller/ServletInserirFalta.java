package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Frequencia;
import persistence.FrequenciaDAO;

/**
 * Servlet implementation class ServletInserirFalta
 */
@WebServlet("/inserirFalta")
public class ServletInserirFalta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInserirFalta() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tamanho = Integer.parseInt(request.getParameter("tamanho"));
		String materia = request.getParameter("aula");
		String data = request.getParameter("dt");
		System.out.println(materia);
		for(int i = 1; i<tamanho; i++) {
			String ra = request.getParameter(Integer.toString(i));
			String falta = request.getParameter(ra);
			Frequencia fr = new Frequencia(ra, falta, materia, data);
			try {
				FrequenciaDAO.inserirFalta(fr);
			} catch (SQLException e) {
				System.out.println("ERRO INSERIR FALTA "+e.getMessage());
				break;
			}
		}
		request.getRequestDispatcher("faltas.jsp").forward(request, response);
	}

}
