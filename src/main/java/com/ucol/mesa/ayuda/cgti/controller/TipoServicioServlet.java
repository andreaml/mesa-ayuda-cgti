/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.mesa.ayuda.cgti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucol.mesa.ayuda.cgti.dao.TipoServicioDAO;
import com.ucol.mesa.ayuda.cgti.model.TipoServicio;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author andreaml
 */
public class TipoServicioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    TipoServicioDAO tipoServicioDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {

            tipoServicioDAO = new TipoServicioDAO(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public TipoServicioServlet() {
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
        TipoServicio tipoServicio = new TipoServicio(request.getParameter("nombre_tipo_servicio"), Integer.parseInt(request.getParameter("area")));
        tipoServicioDAO.insertar(tipoServicio);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tipoServicio/register.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tipoServicio/mostrar.jsp");
        List<TipoServicio> listaTipoServicio = tipoServicioDAO.listarTipoServicio();
        request.setAttribute("lista", listaTipoServicio);
        dispatcher.forward(request, response);
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        TipoServicio tipoServicio = tipoServicioDAO.obtenerPorId(Integer.parseInt(request.getParameter("tipoServicio")));
        request.setAttribute("tipoServicio", tipoServicio);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/tipoServicio/editar.jsp");
        dispatcher.forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    TipoServicio tipoServicio = new TipoServicio(request.getParameter("nombre_tipo_servicio"), Integer.parseInt(request.getParameter("area")));
        tipoServicioDAO.actualizar(tipoServicio);
        index(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        TipoServicio tipoServicio = tipoServicioDAO.obtenerPorId(Integer.parseInt(request.getParameter("id_tipo_servicio")));
        tipoServicioDAO.eliminar(tipoServicio);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
