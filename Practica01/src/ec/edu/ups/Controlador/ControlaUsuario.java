package ec.edu.ups.Controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ControlaUsuario
 */
@WebServlet("/ControlaUsuario")
public class ControlaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDao usuario;
	TelefonoDAO telefono;
	/**
	 * @see HttpServlet#HttpServlet()
	 */



	public ControlaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "Registrarse":
				System.out.println("entro");
				registrar(request, response);
				break;
			case "Login":
				System.out.println("logear");
				logear(request, response);
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



	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Persona per = new Persona(request.getParameter("cedula"),request.getParameter("nombre"),request.getParameter("apellido"),request.getParameter("correo"),request.getParameter("contra") );
		usuario= new UsuarioDao();

		
		usuario.insertarPersona(per);
	}




	private void logear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		java.io.PrintWriter out = response.getWriter(); 

		String user = request.getParameter("correo");
		String pass = request.getParameter("contra");
		usuario= new UsuarioDao();
		
		if(usuario.login(user, pass)!="") {
			out.println("<hl>gracias por acceder al servidor</hl>") ; 
			out.println("<a href='Telefono.jsp'>RegistrarTelefono</a>");	
			out.println("<a href='ControlaTelefono?action=mostrar'>ListaTelefono</a>");	
			out.println("<a href='Lista_Informacion.jsp'>ListaTelefono-Usuario</a>");	
			Persona usuarioactual = Persona.getInstance();
			System.out.println("la webada que hiciste adrian:  "+ usuarioactual.getCedula());
					
		}else {
			out.println("<hl>LOCAAAAr</hl>") ; 
		}
		//adas asdas	

	}
	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
