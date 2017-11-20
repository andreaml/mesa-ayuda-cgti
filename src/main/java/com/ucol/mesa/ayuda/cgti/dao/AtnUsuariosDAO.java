package com.ucol.mesa.ayuda.cgti.dao;
import com.ucol.mesa.ayuda.cgti.model.AtnUsuarios;
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
public class AtnUsuariosDAO {
    private ConexionBD conexionBD;
    private Connection connection;

    public AtnUsuariosDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        conexionBD = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
    }

    //Agregar nombreUsuario
    public boolean insertar(AtnUsuarios atnusuarios) throws SQLException {
        String sql = "INSERT INTO ATN_USUARIOS(correo, primer_nombre, segundo_nombre, apellido_paterno, apellido_materno, dependencia, num_trabajador, contrasenia) VALUES (?,?,?,?,?,?,?,?)";
        System.out.println(atnusuarios.getCorreo());
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, atnusuarios.getCorreo());
        statement.setString(2, atnusuarios.getNombre1());
        statement.setString(3, atnusuarios.getNombre2());
        statement.setString(4, atnusuarios.getApellidoP());
        statement.setString(5, atnusuarios.getApellidoM());
        statement.setInt(6, atnusuarios.getDependencia());
        statement.setInt(7, atnusuarios.getNumTrabajador());
        statement.setString(8, atnusuarios.getContrasenia());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowInserted;
    }
    
    // listar todos los usuarios
    public List<AtnUsuarios> listarAtnUsuarios() throws SQLException {

        List<AtnUsuarios> listaAtnUsuarios = new ArrayList<AtnUsuarios>();
        String sql = "SELECT * FROM ATN_USUARIOS";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            String correo = resulSet.getString("correo");
            String primer_nombre = resulSet.getString("primer_nombre");
            String segundo_nombre = resulSet.getString("segundo_nombre");
            String apellido_paterno = resulSet.getString("apellido_paterno");
            String apellido_materno = resulSet.getString("apellido_materno");
            int dependencia = resulSet.getInt("dependencia");
            int num_trabajador = resulSet.getInt("num_trabajador");
            String contrasenia = resulSet.getString("contrasenia");

            AtnUsuarios atnusuarios = new AtnUsuarios(correo, primer_nombre, segundo_nombre, apellido_paterno, apellido_materno, dependencia, num_trabajador);
            listaAtnUsuarios.add(atnusuarios);
        }
        conexionBD.desconectar();
        return listaAtnUsuarios;
    }
    
    //Obtener por id
    public AtnUsuarios obtenerPorId(String correo) throws SQLException {
        AtnUsuarios atnusuarios = null;

        String sql = "SELECT * FROM ATN_USUARIOS WHERE correo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, correo);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            atnusuarios = new AtnUsuarios(res.getString("correo"), res.getString("primer_nombre"), res.getString("segundo_nombre"), res.getString("apellido_paterno"), res.getString("apellido_materno"), res.getInt("dependencia"), res.getInt("num_trabajador"));
        }
        res.close();
        conexionBD.desconectar();

        return atnusuarios;
    }
    
    //Actualizar
    public boolean actualizar(AtnUsuarios atnusuarios) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE ATN_USUARIOS SET correo=?, primer_nombre=?, segundo_nombre=?, apellido_paterno=?, apellido_materno=?, dependencia=?, num_trabajador=?, contrasenia=? WHERE correo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, atnusuarios.getCorreo());
        statement.setString(2, atnusuarios.getNombre1());
        statement.setString(3, atnusuarios.getNombre2());
        statement.setString(4, atnusuarios.getApellidoP());
        statement.setString(5, atnusuarios.getApellidoM());
        statement.setInt(6, atnusuarios.getDependencia());
        statement.setInt(7, atnusuarios.getNumTrabajador());
        statement.setString(8, atnusuarios.getContrasenia());
        statement.setString(9, atnusuarios.getCorreo());
        
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowActualizar;
    }
    
    //eliminar
    public boolean eliminar(AtnUsuarios atnusuarios) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM ATN_USUARIOS WHERE correo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, atnusuarios.getCorreo());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();

        return rowEliminar;
    }
}