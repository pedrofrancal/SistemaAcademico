package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import persistence.ConnectionSingleton;

/**
 * Servlet implementation class ServletRelatorioFalta
 */
@WebServlet("/relatorioFalta")
public class ServletRelatorioFalta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRelatorioFalta() {
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
		String erro = "";
		String materia = request.getParameter("materias");
		String Jasper = "WEB-INF/report/RelatorioFaltas.jasper";
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("disciplina", materia);
		
		byte[] bytes = null;
		ServletContext contexto = getServletContext();
		
		try {
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile(contexto.getRealPath(Jasper));
			bytes = JasperRunManager.runReportToPdf(relatorio, param, ConnectionSingleton.getInstance().getConnection());
			
		} catch (JRException e) {
			erro = e.getMessage();
			
		} finally {
			if(bytes != null) {
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream sos = response.getOutputStream();
				sos.write(bytes);
				sos.flush();
				sos.close();
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("erro", erro);
				rd.forward(request, response);
			}
			
		}
	}
	
}
