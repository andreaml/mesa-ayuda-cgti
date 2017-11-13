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

import com.ucol.mesa.ayuda.cgti.dao.TicketDAO;
import com.ucol.mesa.ayuda.cgti.model.Ticket;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author andreaml
 */
public class TicketServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    TicketDAO ticketDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {

            ticketDAO = new TicketDAO(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public TicketServlet() {
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"), dtf);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime hora = LocalTime.parse(request.getParameter("hora"),dtf2);
        Ticket ticket = new Ticket(request.getParameter("titulo"), request.getParameter("descripcion"), Integer.parseInt(request.getParameter("tipo_servicio")), request.getParameter("emisor"), fecha, hora, Integer.parseInt(request.getParameter("estado_ticket")));
        ticketDAO.insertar(ticket);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ticket/register.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ticket/mostrar.jsp");
        List<Ticket> listaTicket = ticketDAO.listarTickets();
        request.setAttribute("lista", listaTicket);
        dispatcher.forward(request, response);
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Ticket ticket = ticketDAO.obtenerPorId(Integer.parseInt(request.getParameter("ticket")));
        request.setAttribute("ticket", ticket);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ticket/editar.jsp");
        dispatcher.forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"), dtf);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime hora = LocalTime.parse(request.getParameter("hora"),dtf2);
        Ticket ticket = new Ticket(request.getParameter("titulo"), request.getParameter("descripcion"), Integer.parseInt(request.getParameter("tipo_servicio")), request.getParameter("emisor"), fecha, hora, Integer.parseInt(request.getParameter("estado_ticket")));
        ticket.setId_ticket(Integer.parseInt(request.getParameter("id_ticket")));
        ticketDAO.actualizar(ticket);
        index(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Ticket ticket = ticketDAO.obtenerPorId(Integer.parseInt(request.getParameter("id_ticket")));
        ticketDAO.eliminar(ticket);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}