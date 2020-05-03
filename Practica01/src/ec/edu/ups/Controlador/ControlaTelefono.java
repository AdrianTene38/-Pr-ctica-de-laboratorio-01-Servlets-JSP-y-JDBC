package ec.edu.ups.Controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
   	ArrayList<Telefono> listaTelefonos;
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
			
			case "mostrar":
				System.out.println("asd");
				mostrar(request, response);
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
		System.out.print("q onda lego aqui,,??");
			Telefono tele = new Telefono (num ,request.getParameter("numero"),request.getParameter("tipo"),request.getParameter("operadora"), sq);
			telefono.insertarTelefono(tele);
		}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("ListaTelefono.jsp");
		TelefonoDAO  telefono=new TelefonoDAO();
		Persona usuarioactual = Persona.getInstance();
		Telefono t = Telefono.getInstance();
		String cedula = usuarioactual.getCedula();
		ArrayList<Telefono>prueba= telefono.listarTelefonos(cedula);
		System.out.println("tama;o"+prueba.size());
		System.out.println();
		request.setAttribute("lista", prueba);
		dispatcher.forward(request, response);
		
		
		}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		//Telefono tele = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		//articuloDAO.eliminar(articulo);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		//dispatcher.forward(request, response);
		
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
