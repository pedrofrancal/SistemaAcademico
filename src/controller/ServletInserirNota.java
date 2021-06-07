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
import model.Avaliacao;
import persistence.AlunosDAO;
import persistence.NotasDAO;

/**
 * Servlet implementation class ServletInserirNota
 */
@WebServlet("/inserirNota")
public class ServletInserirNota extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletInserirNota() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Aluno> alunos = AlunosDAO.listarAlunos();
			ArrayList<Avaliacao> avaliacoes = NotasDAO.listarProvas(request.getParameter("materias"));
			request.setAttribute("aluno", alunos);
			request.setAttribute("materia", avaliacoes);
			request.getRequestDispatcher("notas.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
