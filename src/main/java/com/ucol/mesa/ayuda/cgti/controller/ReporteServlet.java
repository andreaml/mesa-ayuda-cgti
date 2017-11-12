/*
corregido
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

import com.ucol.mesa.ayuda.cgti.dao.ReporteDAO;
import com.ucol.mesa.ayuda.cgti.model.Reporte;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author andreaml
 */
public class ReporteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ReporteDAO reporteDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {

            reporteDAO = new ReporteDAO(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public ReporteServlet() {
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
        Reporte reporte = new Reporte(request.getParameter("id_reporte"), Integer.parseInt(request.getParameter("fecha")), Integer.parseInt(request.getParameter("hora")), request.getParameter("num_usuarios"), request.getParameter("num_especialistas"), request.getParameter("num_tickets_asignados"), request.getParameter("num_tickets_sin_asignar"), request.getParameter("num_tickets_atendiendo"), request.getParameter("num_tickets_cerrados"), request.getParameter("num_tickets_calendarizados"), request.getParameter("num_tickets_solucionados"), request.getParameter("num_casos_satisfechos"), request.getParameter("num_casos_insatisfechos"));
        reporteDAO.insertar(reporte);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/reportes/register.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/reportes/mostrar.jsp");
        List<Reporte> listaReporte = reporteDAO.listarReporte();
        request.setAttribute("lista", listaReporte);
        dispatcher.forward(request, response);
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Reporte reporte = reporteDAO.obtenerPorId(request.getParameter("reporte"));
        request.setAttribute("reporte", reporte);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/reportes/editar.jsp");
        dispatcher.forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Reporte reporte = new Reporte(request.getParameter("id_reporte"), Integer.parseInt(request.getParameter("fecha")), Integer.parseInt(request.getParameter("hora")), request.getParameter("num_usuarios"), request.getParameter("num_especialistas"), request.getParameter("num_tickets_asignados"), request.getParameter("num_tickets_sin_asignar"), request.getParameter("num_tickets_atendiendo"), request.getParameter("num_tickets_cerrados"), request.getParameter("num_tickets_calendarizados"), request.getParameter("num_tickets_solucionados"), request.getParameter("num_casos_satisfechos"), request.getParameter("num_casos_insatisfechos"));
        reporteDAO.actualizar(reporte);
        index(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Reporte reporte = reporteDAO.obtenerPorId(request.getParameter("id_reporte"));
        reporteDAO.eliminar(reporte);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}