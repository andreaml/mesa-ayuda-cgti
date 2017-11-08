package com.ucol.mesa.ayuda.cgti.dao;
import com.ucol.mesa.ayuda.cgti.model.Vehiculo;
import com.ucol.mesa.ayuda.cgti.model.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ASUS
 */

public class VehiculoDAO {
    private ConexionBD conexionBD;
    private Connection connection;

    public VehiculoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        conexionBD = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    //Vehiculo(int id_vehiculo, String modelo, int anio, String estado, int dependencia, String marca, int nivelGasolina)
    
    //Agregar Vehiculo
    public boolean insertar(Vehiculo vehiculo) throws SQLException {
        String sql = "INSERT INTO VEHICULOS(id_vehiculo, modelo, anio, estado, dependencia, marca, nivel_gasolina) VALUES (?,?,?,?,?,?,?)";
        System.out.println(vehiculo.getId_vehiculo());
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, vehiculo.getId_vehiculo());
        statement.setString(2, vehiculo.getModelo());
        statement.setInt(3, vehiculo.getAnio());
        statement.setString(4, vehiculo.getEstado());
        statement.setInt(5, vehiculo.getDependencia());
        statement.setString(6, vehiculo.getMarca());
        statement.setInt(7, vehiculo.getNivelGasolina());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowInserted;
    }
    
    // listar todos los vehículos
    public List<Vehiculo> listarVehiculos() throws SQLException {

        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        String sql = "SELECT * FROM VEHICULOS";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            String id_vehiculo = resulSet.getString("id_vehiculo");
            String modelo = resulSet.getString("modelo");
            int anio = resulSet.getInt("anio");
            String estado = resulSet.getString("estado");
            int dependencia = resulSet.getInt("dependencia");
            String marca = resulSet.getString("marca");
            int nivelGasolina = resulSet.getInt("nivel_gasolina");

            Vehiculo vehiculo = new Vehiculo(id_vehiculo, modelo, anio, estado, dependencia,marca,  nivelGasolina);
            listaVehiculos.add(vehiculo);
        }
        conexionBD.desconectar();
        return listaVehiculos;
    }
    
    //Obtener vehiculo por id
    public Vehiculo obtenerPorId(String id_vehiculo) throws SQLException {
        Vehiculo vehiculo = null;

        String sql = "SELECT * FROM VEHICULOS WHERE correo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id_vehiculo);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            vehiculo = new Vehiculo(res.getString("id_vehiculo"), res.getString("modelo"), res.getInt("anio"), res.getString("estado"), res.getInt("dependencia"), res.getString("marca"), res.getInt("nivel_gasolina"));
        }
        res.close();
        conexionBD.desconectar();

        return vehiculo;
    }
    
    //Actualizar vehiculo
    public boolean actualizar(Vehiculo vehiculo) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE VEHICULOS SET id_vehiculo=?, modelo=?, anio=?, estado=?, dependencia=?, marca=?, nivel_gasolina=? WHERE id_vehiculo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, vehiculo.getId_vehiculo());
        statement.setString(2, vehiculo.getModelo());
        statement.setInt(3, vehiculo.getAnio());
        statement.setString(4, vehiculo.getEstado());
        statement.setInt(5, vehiculo.getDependencia());
        statement.setString(6, vehiculo.getMarca());
        statement.setInt(7, vehiculo.getNivelGasolina());
        statement.setString(8, vehiculo.getId_vehiculo());
        
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowActualizar;
    }
    
    //Eliminar Vehiculo
    public boolean eliminar(Vehiculo vehiculo) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM VEHICULOS WHERE id_vehiculo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, vehiculo.getId_vehiculo());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();

        return rowEliminar;
    }
}
