package com.ucol.mesa.ayuda.cgti.dao;
import com.ucol.mesa.ayuda.cgti.model.Ticket;
import com.ucol.mesa.ayuda.cgti.model.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 * @author ASUS
 */
public class TicketDAO {
    private ConexionBD conexionBD;
    private Connection connection;

    public TicketDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        conexionBD = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    //Agregar nombreUsuario
    public boolean insertar(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO TICKETS(titulo, descripcion, tipo_servicio, emisor, fecha, hora, estado_ticket) VALUES (?,?,?,?,?,?,?)";
        System.out.println(ticket.getId_ticket());
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, ticket.getTitulo());
        statement.setString(2, ticket.getDescripcion());
        statement.setInt(3, ticket.getTipoServicio());
        statement.setString(4, ticket.getEmisor());
        statement.setString(5, ticket.getFecha().toString());
        statement.setString(6, ticket.getHora().toString());
        statement.setInt(7, ticket.getEstadoTicket());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowInserted;
    }
    
    // listar todos los productos
    public List<Ticket> listarTickets() throws SQLException {

        List<Ticket> listaTickets = new ArrayList<Ticket>();
        String sql = "SELECT * FROM TICKETS";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int id_ticket = resulSet.getInt("id_ticket");
            String titulo = resulSet.getString("titulo");
            String descripcion = resulSet.getString("descripcion");
            int servicio = resulSet.getInt("servicio");
            int tipo_servicio = resulSet.getInt("tipo_servicio");
            String emisor = resulSet.getString("emisor");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
            LocalDate fecha = LocalDate.parse(resulSet.getString("fecha"), dtf);
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime hora = LocalTime.parse(resulSet.getString("hora"),dtf2);
            String comentarios = resulSet.getString("comentarios");
            int estado_satisfaccion = resulSet.getInt("estado_satisfaccion");
            int estado_ticket = resulSet.getInt("estado_ticket");
            String especialista = resulSet.getString("especialista");

            Ticket ticket = new Ticket(titulo, descripcion, tipo_servicio, emisor, fecha, hora, estado_ticket);
            ticket.setId_ticket(id_ticket);
            ticket.setServicio(servicio);
            ticket.setComentarios(comentarios);
            ticket.setEstadoSatisfaccion(estado_satisfaccion);
            ticket.setEspecialista(especialista);
            listaTickets.add(ticket);
        }
        conexionBD.desconectar();
        return listaTickets;
    }
    
    //Obtener ticket por id
    public Ticket obtenerPorId(int id_ticket) throws SQLException {
        Ticket ticket = null;

        String sql = "SELECT * FROM TICKETS WHERE id_ticket=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_ticket);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
            LocalDate fecha = LocalDate.parse(res.getString("fecha"), dtf);
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime hora = LocalTime.parse(res.getString("hora"),dtf2);
            
            ticket = new Ticket (res.getString("titulo"), res.getString("descripcion"), res.getInt("tipo_servicio"),res.getString("emisor"), fecha, hora, res.getInt("estado_ticket"));
            ticket.setId_ticket(res.getInt("id_ticket"));
            ticket.setServicio(res.getInt("servicio"));
            ticket.setComentarios(res.getString("comentarios"));
            ticket.setEstadoSatisfaccion(res.getInt("estado_satisfaccion"));
            ticket.setEspecialista(res.getString("especialista"));
            
        }
        res.close();
        conexionBD.desconectar();

        return ticket;
    }
    
    //Actualizar
    public boolean actualizar(Ticket ticket) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE TICKETS SET id_ticket=?, titulo=?, descripcion=?, servicio=?,tipo_servicio=?, emisor=?, fecha=?, hora=?, comentarios=?, estado_satisfaccion=?, estado_ticket=?, especialista=? WHERE id_ticket=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ticket.getId_ticket());
        statement.setString(2, ticket.getTitulo());
        statement.setString(3, ticket.getDescripcion());
        statement.setInt(4, ticket.getServicio());
        statement.setInt(5, ticket.getTipoServicio());
        statement.setString(6, ticket.getEmisor());
        statement.setString(7, ticket.getFecha().toString());
        statement.setString(8, ticket.getHora().toString());
        statement.setString(9, ticket.getComentarios());
        statement.setInt(10, ticket.getEstadoSatisfaccion());
        statement.setInt(11, ticket.getEstadoTicket());
        
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowActualizar;
    }
    
    //Eliminar ticket
    public boolean eliminar(Ticket ticket) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM TICKETS WHERE id_ticket=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ticket.getId_ticket());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();

        return rowEliminar;
    }
}