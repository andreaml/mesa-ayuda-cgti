package com.ucol.mesa.ayuda.cgti.dao;
import com.ucol.mesa.ayuda.cgti.model.Area;
import com.ucol.mesa.ayuda.cgti.model.ConexionBD;
import com.ucol.mesa.ayuda.cgti.model.Dependencia;

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
public class AreaDAO {
    private ConexionBD conexionBD;
    private Connection connection;
    private DependenciaDAO dependenciaDAO;
    
    public AreaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        conexionBD = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
        dependenciaDAO = new DependenciaDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    //Agregar Area
    public boolean insertar(Area area) throws SQLException {
        String sql = "INSERT INTO AREA(id_area, nombre_area, dependencia) VALUES (?,?,?)";
        System.out.println(area.getId_area());
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, area.getId_area());
        statement.setString(2, area.getNombreArea());
        statement.setInt(3, area.getDependenciaInt());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowInserted;
    }
    
    // listar todas las areas
    public List<Area> listarArea() throws SQLException {

        List<Area> listaArea = new ArrayList<Area>();
        String sql = "SELECT * FROM AREA";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int id_area = resulSet.getInt("id_area");
            String nombreArea = resulSet.getString("nombre_area");
            //int dependencia = resulSet.getInt("dependencia");
            Dependencia dependencia = dependenciaDAO.obtenerPorId(resulSet.getInt("dependencia"));
            
            Area area = new Area(id_area, nombreArea, dependencia);
            listaArea.add(area);
        }
        conexionBD.desconectar();
        return listaArea;
    }
    
    //Obtener por id
    public Area obtenerPorId(int id_area) throws SQLException {
        Area area = null;

        String sql = "SELECT * FROM AREA WHERE id_area=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_area);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            Dependencia dependencia = dependenciaDAO.obtenerPorId(res.getInt("dependencia"));
            area = new Area(res.getInt("id_area"), res.getString("nombre_area"), res.getInt("dependencia"));
        }
        res.close();
        conexionBD.desconectar();

        return area;
    }
    
    //Actualizar
    public boolean actualizar(Area area, int id_areaVieja) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE AREA SET id_area=?, nombre_area=?, dependencia=? WHERE id_area=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, area.getId_area());
        statement.setString(2, area.getNombreArea());
        statement.setInt(3, area.getDependenciaInt());
        statement.setInt(8, id_areaVieja);
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowActualizar;
    }
    
    //eliminar
    public boolean eliminar(Area area) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM AREA WHERE id_area=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, area.getId_area());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();

        return rowEliminar;
    }
}