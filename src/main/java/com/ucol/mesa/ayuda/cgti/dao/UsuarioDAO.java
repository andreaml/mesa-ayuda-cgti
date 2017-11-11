/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ucol.mesa.ayuda.cgti.dao;
import com.ucol.mesa.ayuda.cgti.model.Usuario;
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
public class UsuarioDAO {
    private ConexionBD conexionBD;
    private Connection connection;

    public UsuarioDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        conexionBD = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
    }

    //Agregar nombreUsuario
    public boolean insertar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios(correo, primer_nombre, segundo_nombre, apellido_paterno, apellido_materno, dependencia, num_cuenta, tipo) VALUES (?,?,?,?,?,?,?,?)";
        System.out.println(usuario.getCorreo());
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getCorreo());
        statement.setString(2, usuario.getNombre1());
        statement.setString(3, usuario.getNombre2());
        statement.setString(4, usuario.getApellidoP());
        statement.setString(5, usuario.getApellidoM());
        statement.setInt(6, usuario.getDependencia());
        statement.setInt(7, usuario.getNumCuenta());
        statement.setString(8, usuario.getTipo());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowInserted;
    }
    
    // listar todos los productos
    public List<Usuario> listarUsuarios() throws SQLException {

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        String sql = "SELECT * FROM usuarios";
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
            int num_cuenta = resulSet.getInt("num_cuenta");
            String tipo = resulSet.getString("tipo");

            Usuario usuario = new Usuario(correo, primer_nombre, segundo_nombre, apellido_paterno, apellido_materno, dependencia, num_cuenta, tipo);
            listaUsuarios.add(usuario);
        }
        conexionBD.desconectar();
        return listaUsuarios;
    }
    
    //Obtener por id
    public Usuario obtenerPorId(String correo) throws SQLException {
        Usuario usuario = null;

        String sql = "SELECT * FROM usuarios WHERE correo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, correo);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            usuario = new Usuario(res.getString("correo"), res.getString("primer_nombre"), res.getString("segundo_nombre"), res.getString("apellido_paterno"), res.getString("apellido_materno"), res.getInt("dependencia"), res.getInt("num_cuenta"), res.getString("tipo"));
        }
        res.close();
        conexionBD.desconectar();

        return usuario;
    }
    
    //Actualizar
    public boolean actualizar(Usuario usuario) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE usuarios SET correo=?, primer_nombre=?, segundo_nombre=?, apellido_paterno=?, apellido_materno=?, dependencia=?, num_cuenta=?, tipo=? WHERE correo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getCorreo());
        statement.setString(2, usuario.getNombre1());
        statement.setString(3, usuario.getNombre2());
        statement.setString(4, usuario.getApellidoP());
        statement.setString(5, usuario.getApellidoM());
        statement.setInt(6, usuario.getDependencia());
        statement.setInt(7, usuario.getNumCuenta());
        statement.setString(8, usuario.getTipo());
        statement.setString(9, usuario.getCorreo());
        
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowActualizar;
    }
    
    //eliminar
    public boolean eliminar(Usuario usuario) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM usuarios WHERE correo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getCorreo());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();

        return rowEliminar;
    }
}
