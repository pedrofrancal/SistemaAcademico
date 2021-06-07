package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import persistence.AlunosDAO;
import persistence.FrequenciaDAO;

/**
 * Servlet implementation class ServletVerificarFaltas
 */
@WebServlet("/verificarFaltas")
public class ServletVerificarFaltas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVerificarFaltas() {
        super();
        // TODO Auto-generated constructor stub
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
		try {
			ArrayList<Aluno> alunos = AlunosDAO.listarAlunos();
			int numAula = FrequenciaDAO.quantidadeAulaPorMateria(request.getParameter("materias"));
			request.setAttribute("aluno", alunos);
			//voltar a data que foi selecionada anteriormente
			request.setAttribute("data", request.getParameter("data"));
			request.setAttribute("materia", request.getParameter("materia"));
			request.setAttribute("aulas", (numAula/20));
			request.getRequestDispatcher("faltas.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
