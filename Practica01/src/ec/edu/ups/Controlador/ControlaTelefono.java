package ec.edu.ups.Controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.TelefonoDAO;
import ec.edu.ups.DAO.UsuarioDao;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.Telefono;

/**
 * Servlet implementation class ControlaTelefono
 */
@WebServlet("/ControlaTelefono")
public class ControlaTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       TelefonoDAO telefono;
       UsuarioDao usuario;
       /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlaTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "RegistrarTelefono":
				System.out.println("holaaaaaaaaaaaaaaaa");
				registrartelefono(request, response);
				break;
			

			default:
				break;
			} 
		}
		catch (SQLException e) {
			e.getStackTrace();
			System.out.println("QUE ONDA");
		}
	}

	
	

	private void registrartelefono(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String s =request.getParameter("codigo");
		int num = Integer.
				parseInt(s);
		
		Persona usuarioactual = Persona.getInstance();
		telefono=new TelefonoDAO();
		usuario= new UsuarioDao();
		String sq=usuarioactual.getCedula();
		Persona p = new Persona();
		System.out.print("q onda lego aqui,,??");
			Telefono tele = new Telefono (num ,request.getParameter("numero"),request.getParameter("tipo"),request.getParameter("operadora"), sq);
			telefono.insertarTelefono(tele);
		}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	
}
