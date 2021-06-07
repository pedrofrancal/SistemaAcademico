package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Nota;
import persistence.NotasDAO;

/**
 * Servlet implementation class ServletRegistraNota
 */
@WebServlet("/registraNota")
public class ServletRegistraNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistraNota() {
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
		int countA = Integer.parseInt(request.getParameter("tamanho"));
		int countB = Integer.parseInt(request.getParameter("jTamanho"));

		int k = 4000;
		int j = 2000;

		for (int i = 1; i < countA; i++) {
			Nota n = new Nota(request.getParameter(Integer.toString(i)));
			for (int x = 1; x <= countB; x++) {
				String codigo = request.getParameter(Integer.toString(j));
				String nota = request.getParameter(Integer.toString(k));
				if (request.getParameter(Integer.toString(i)) != "" && codigo != "" && nota != "") {
					String ra = n.getRa();
					n = new Nota(ra, Integer.parseInt(codigo), Double.parseDouble(nota));
					try {
						NotasDAO.inserirNota(n);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			j++;
			k++;
		}
		request.getRequestDispatcher("notas.jsp").forward(request, response);
	}

}
