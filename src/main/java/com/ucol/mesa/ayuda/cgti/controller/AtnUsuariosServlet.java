package com.ucol.mesa.ayuda.cgti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucol.mesa.ayuda.cgti.dao.AtnUsuariosDAO;
import com.ucol.mesa.ayuda.cgti.model.AtnUsuarios;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * @author cmiranda
 */
public class AtnUsuariosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    AtnUsuariosDAO atnUsuariosDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {

            atnUsuariosDAO = new AtnUsuariosDAO(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public AtnUsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Servlet..");
        String action = request.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
                case "index":
                    index(request, response);
                    break;
                case "nuevo":
                    nuevo(request, response);
                    break;
                case "register":
                    System.out.println("entro");
                    registrar(request, response);
                    break;
                case "mostrar":
                    mostrar(request, response);
                    break;
                case "showedit":
                    showEditar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Servlet..");
        doGet(request, response);
    }
    
    private void index(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //mostrar(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        AtnUsuarios atnUsuario = new AtnUsuarios(request.getParameter("correo"), request.getParameter("primer_nombre"), request.getParameter("segundo_nombre"), request.getParameter("apellido_paterno"), request.getParameter("apellido_materno"), Integer.parseInt(request.getParameter("dependencia")), Integer.parseInt(request.getParameter("num_trabajador")), request.getParameter("contrasenia"));
        atnUsuariosDAO.insertar(atnUsuario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/atn_usuarios/register.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/atn_usuarios/mostrar.jsp");
        List<AtnUsuarios> listaAtnUsuarios = atnUsuariosDAO.listarAtnUsuarios();
        request.setAttribute("lista", listaAtnUsuarios);
        dispatcher.forward(request, response);
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        AtnUsuarios atnUsuarios = atnUsuariosDAO.obtenerPorId(request.getParameter("atnUsuario"));
        request.setAttribute("atnUsuario", atnUsuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/atn_usuarios/editar.jsp");
        dispatcher.forward(request, response);
    }


    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        AtnUsuarios atnUsuarios = new AtnUsuarios(request.getParameter("correo"), request.getParameter("primer_nombre"), request.getParameter("segundo_nombre"), request.getParameter("apellido_paterno"), request.getParameter("apellido_materno"), Integer.parseInt(request.getParameter("dependencia")), Integer.parseInt(request.getParameter("num_trabajador")), request.getParameter("contrasenia"));
        atnUsuariosDAO.actualizar(atnUsuarios);
        index(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        AtnUsuarios atnUsuarios = atnUsuariosDAO.obtenerPorId(request.getParameter("correo"));
        atnUsuariosDAO.eliminar(atnUsuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
}
