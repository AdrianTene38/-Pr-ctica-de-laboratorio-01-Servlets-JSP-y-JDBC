package ec.edu.ups.Controlador;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

			case "Eliminar":
				System.out.println("elimina");
				try {
					eliminar(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "Editar":
				System.out.println("asd");
				editar(request, response);
				break;
			case "editapr":
				System.out.println("ksjdfsjkdfkjsdfjkds");
				editarp(request, response);
				break;
			case "Buscar":
				System.out.println("asd");
				mostrar1(request, response);
				break;
				
			case "BuscaCedula":
				System.out.println("asd");
				mostrar2(request, response);
				break;
			default:
				break;
			}


		}
		catch (SQLException e) {
			e.getStackTrace();
			System.out.println("QUE ONDA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		System.out.println("codigo del telefono:"+ t.getCodigo());
	}

	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Telefono te= Telefono.getInstance();
		TelefonoDAO  telefono=new TelefonoDAO();
		String numero=request.getParameter("id");
		int numEntero = Integer.parseInt(numero);
		System.out.println("ven aquii"+numEntero);
		te.setCodigo(numEntero);
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("ListaTelefono.jsp");
		telefono.eliminar(numEntero);
		
		dispatcher.forward(request, response);
	}
	private void editarp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String numero=request.getParameter("id");
		TelefonoDAO  telefono=new TelefonoDAO();
		int numEntero = Integer.parseInt(numero);
		//request.setAttribute("telefono", numEntero);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Editar.jsp");
		//dispatcher.forward(request, response);
		System.out.println("sosaaa"+numEntero);
		Telefono tele = telefono.obtenerPorId(numEntero);
		Telefono t= Telefono.getInstance();
		t.setCodigo(numEntero);
		request.setAttribute("telefono", tele);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Editar.jsp");
		dispatcher.forward(request, response);
	
	}
	private void editar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Telefono te= Telefono.getInstance();
		
		String s=request.getParameter("codigom");
		int numEntero = Integer.parseInt(s);
		System.out.println("mira cabeza   "+ te.getCodigo());//te.setCodigo(numEntero);
		
		
		TelefonoDAO  telefono=new TelefonoDAO();
		Persona usuarioactual = Persona.getInstance();
		
		//telefono.actualizar(tele);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Editar.jsp");
		//dispatcher.forward(request, response);
		Telefono articulo = new Telefono( numEntero, request.getParameter("numero"), request.getParameter("tipo"), request.getParameter("operadora"));
		telefono.actualizar(articulo, te.getCodigo());
		RequestDispatcher dispatcher = request.getRequestDispatcher("Editar.jsp");
		dispatcher.forward(request,
				response);
	}
	
	private void mostrar1(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("Buscar.jsp");
		TelefonoDAO  telefono=new TelefonoDAO();
		Telefono t = Telefono.getInstance();
		String n=request.getParameter("codiguito");
		int numEntero = Integer.parseInt(n);
		System.out.println("mira mmvrga"+numEntero);
		ArrayList<Telefono>prueba= telefono.Busca(numEntero);
		System.out.println("tama;o222"+ prueba.size());
		System.out.println();
		request.setAttribute("lista", prueba);
		dispatcher.forward(request, response);

	}
	
	
	
	
	private void mostrar2(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("Lista_Informacion.jsp");
		TelefonoDAO  telefono=new TelefonoDAO();
		Telefono t = Telefono.getInstance();
		String n=request.getParameter("cedulita");
		String d =request.getParameter("numero");
		System.out.println("mmvrga el gabriel"+d);
		ArrayList<Telefono>prueba= telefono.BuscaTel(n);
		ArrayList<Persona>prueba1= telefono.BuscaUsu(n);
		System.out.println("tama;o222"+ prueba.size());
		System.out.println();
		request.setAttribute("lista1", prueba1);
		request.setAttribute("lista", prueba);
		
		dispatcher.forward(request, response);

	}
	
	
	
	
	
	
	/**
	 * 
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
