package com.ucol.mesa.ayuda.cgti.dao;
import com.ucol.mesa.ayuda.cgti.model.TipoServicio;
import com.ucol.mesa.ayuda.cgti.model.ConexionBD;

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
public class TipoServicioDAO {
    private ConexionBD conexionBD;
    private Connection connection;

    public TipoServicioDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        conexionBD = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
    }

    //Agregar Tipo de servicio
    public boolean insertar(TipoServicio tiposervicio) throws SQLException {
        String sql = "INSERT INTO TIPO_SERVICIO(id_tipo_servicio, nombre_tipo_servicio, area) VALUES (?,?,?)";
        System.out.println(tiposervicio.getId_tipo_servicio());
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, tiposervicio.getId_tipo_servicio());
        statement.setString(2, tiposervicio.getNombreTipoServicio());
        statement.setInt(3, tiposervicio.getArea());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowInserted;
    }
    
    // listar todos los tipos de servicios
    public List<TipoServicio> listarTipoServicio() throws SQLException {

        List<TipoServicio> listaTipoServicio = new ArrayList<TipoServicio>();
        String sql = "SELECT * FROM TIPO_SERVICIO";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int id_tipo_servicio = resulSet.getInt("id_tipo_servicio");
            String nombreTipoServicio = resulSet.getString("nombreTipoServicio");
            int area = resulSet.getInt("area");

            TipoServicio tiposervicio = new TipoServicio(id_tipo_servicio, nombreTipoServicio, area);
            listaTipoServicio.add(tiposervicio);
        }
        conexionBD.desconectar();
        return listaTipoServicio;
    }
    
    //Obtener por id
    public TipoServicio obtenerPorId(int id_tipo_servicio) throws SQLException {
        TipoServicio tiposervicio = null;

        String sql = "SELECT * FROM TIPO_SERVICIO WHERE id_tipo_servicio=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_tipo_servicio);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            tiposervicio = new TipoServicio(res.getInt("id_tipo_servicio"), res.getString("nombre_tipo_servicio"), res.getInt("area"));
        }
        res.close();
        conexionBD.desconectar();

        return tiposervicio;
    }
    
    //Actualizar
    public boolean actualizar(TipoServicio tiposervicio) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE TIPO_SERVICIO SET id_tipo_servicio=?, nombre_tipo_servicio=?, area=? WHERE id_tipo_servicio=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, tiposervicio.getId_tipo_servicio());
        statement.setString(2, tiposervicio.getNombreTipoServicio());
        statement.setInt(3, tiposervicio.getArea());
        statement.setInt(4, tiposervicio.getId_tipo_servicio());
        
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowActualizar;
    }
    
    //eliminar
    public boolean eliminar(TipoServicio tiposervicio) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM TIPO_SERVICIO WHERE id_tipo_servicio=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, tiposervicio.getId_tipo_servicio());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();

        return rowEliminar;
    }
}