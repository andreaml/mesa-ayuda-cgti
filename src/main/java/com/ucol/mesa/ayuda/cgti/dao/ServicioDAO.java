package com.ucol.mesa.ayuda.cgti.dao;
import com.ucol.mesa.ayuda.cgti.model.Servicio;
import com.ucol.mesa.ayuda.cgti.model.ConexionBD;
import com.ucol.mesa.ayuda.cgti.model.Especialista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreaml
 */
public class ServicioDAO {
    private ConexionBD conexionBD;
    private Connection connection;
    private EspecialistaDAO especialistaDAO;

    public ServicioDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        conexionBD = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
        especialistaDAO = new EspecialistaDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    //Agregar servicio
    public boolean insertar(Servicio servicio) throws SQLException {
        String sql = "INSERT INTO SERVICIO(nombre_servicio, especialista, id_vehiculo, nivel_gas_inicio, nivel_gas_fin) VALUES (?,?,?,?,?)";
        System.out.println(servicio.getId_servicio());
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, servicio.getNombreServicio());
        statement.setString(2, servicio.getEspecialistaString());
        statement.setString(3, servicio.getId_vehiculo());
        statement.setInt(4, servicio.getNivelGasolinaInicio());
        statement.setInt(5, servicio.getNivelGasolinaFin());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowInserted;
    }
    
    // listar todos los servicios
    public List<Servicio> listarServicio() throws SQLException {

        List<Servicio> listaServicio = new ArrayList<Servicio>();
        String sql = "SELECT * FROM SERVICIO";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int id_servicio = resulSet.getInt("id_servicio");
            String nombreServicio = resulSet.getString("nombre_servicio");
            //int dependencia = resulSet.getInt("dependencia");
            Especialista especialista= especialistaDAO.obtenerPorId(resulSet.getString("especialista"));
            String id_vehiculo = resulSet.getString("id_vehiculo");
            int nivelGasolinaInicio = resulSet.getInt("nivel_gas_inicio");
            int nivelGasolinaFin = resulSet.getInt("nivel_gas_fin");
            String fecha = resulSet.getString("fecha");
            String hora = resulSet.getString("hora");

            Servicio servicio = new Servicio(id_servicio, nombreServicio, especialista, id_vehiculo, nivelGasolinaInicio, fecha, hora);
            listaServicio.add(servicio);
        }
        conexionBD.desconectar();
        return listaServicio;
    }
    
    // listar todos los servicios que tengan idEspecialista en común
    public List<Servicio> listarServicioPorEspecialista(String id_especialista) throws SQLException {

        List<Servicio> listaServicioPorEspecialista = new ArrayList<Servicio>();
        String sql = "SELECT * FROM SERVICIO WHERE especialista = ?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id_especialista);
        ResultSet resulSet = statement.executeQuery();
        
        while (resulSet.next()) {
            int id_servicio = resulSet.getInt("id_servicio");
            String nombreServicio = resulSet.getString("nombre_servicio");
            //String especialista = resulSet.getString("especialista");
            Especialista especialista= especialistaDAO.obtenerPorId(resulSet.getString("especialista"));
            String id_vehiculo = resulSet.getString("id_vehiculo");
            int nivelGasolinaInicio = resulSet.getInt("nivel_gas_inicio");
            int nivelGasolinaFin = resulSet.getInt("nivel_gas_fin");
            String fecha = resulSet.getString("fecha");
            String hora = resulSet.getString("hora");

            Servicio servicio = new Servicio(id_servicio, nombreServicio, especialista, id_vehiculo, nivelGasolinaInicio,fecha, hora);
            listaServicioPorEspecialista.add(servicio);
        }
        conexionBD.desconectar();
        return listaServicioPorEspecialista;
    }
    
    //Obtener por id
    public Servicio obtenerPorId(Integer id_servicio) throws SQLException {
        Servicio servicio = null;

        String sql = "SELECT * FROM SERVICIO WHERE id_servicio=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_servicio);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            Especialista especialista=especialistaDAO.obtenerPorId(res.getString("especialista"));
            servicio = new Servicio(res.getInt("id_servicio"), res.getString("nombreServicio"), especialista, res.getString("id_vehiculo"), res.getInt("nivel_gasolina_inicio"), res.getInt("nivel_gasolina_fin"), res.getString("fecha"), res.getString("hora"));
        }
        res.close();
        conexionBD.desconectar();

        return servicio;
    }
    
    //Actualizar
    public boolean actualizar(Servicio servicio) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE SERVICIO SET id_servicio=?, nombreServicio=?, especialista=?, id_vehiculo=?, nivelGasolinaInicio=?, nivelGasolinaFinenia=? WHERE id_servicio=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, servicio.getId_servicio());
        statement.setString(2, servicio.getNombreServicio());
        statement.setString(3, servicio.getEspecialistaString());
        statement.setString(4, servicio.getId_vehiculo());
        statement.setInt(5, servicio.getNivelGasolinaInicio());
        statement.setInt(6, servicio.getNivelGasolinaFin());
        statement.setInt(7, servicio.getId_servicio());
        
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowActualizar;
    }
    
    //eliminar
    public boolean eliminar(Servicio servicio) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM SERVICIO WHERE id_servicio=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, servicio.getId_servicio());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();

        return rowEliminar;
    }
}