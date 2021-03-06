package com.ucol.mesa.ayuda.cgti.dao;
import com.ucol.mesa.ayuda.cgti.model.ConexionBD;
import com.ucol.mesa.ayuda.cgti.model.Especialista;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ASUS
 */
public class EspecialistaDAO {
    private ConexionBD conexionBD;
    private Connection connection;

    public EspecialistaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        conexionBD = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    //Insertar especialista
    public boolean insertar(Especialista especialista)throws SQLException{
        String sql="INSERT INTO ESPECIALISTA (correo, primer_nombre, segundo_nombre, apellido_paterno, apellido_materno, area, num_trabajador, contrasenia, profesion)VALUES (?,?,?,?,?,?,?,?,?)";
        System.out.println(especialista.getCorreo());
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, especialista.getCorreo());
        statement.setString(2, especialista.getNombre1());
        statement.setString(3, especialista.getNombre2());
        statement.setString(4, especialista.getApellidoP());
        statement.setString(5, especialista.getApellidoM());
        statement.setInt(6, especialista.getArea());
        statement.setInt(7, especialista.getNumTrabajador());
        statement.setString(8, especialista.getContrasenia());
        statement.setString(9, especialista.getProfesion());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowInserted;
    }
    
    // listar todos los especialistas
    public List<Especialista> listarEspecialistas() throws SQLException {

        List<Especialista> listaEspecialistas = new ArrayList<Especialista>();
        String sql = "SELECT * FROM ESPECIALISTA";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);
        
        while (resulSet.next()) {
            String correo = resulSet.getString("correo");
            String nombre1 = resulSet.getString("primer_nombre");
            String nombre2 = resulSet.getString("segundo_nombre");
            String apellidoP = resulSet.getString("apellido_paterno");
            String apellidoM = resulSet.getString("apellido_materno");
            int area = resulSet.getInt("area");
            int numTrabajador = resulSet.getInt("num_trabajador");
            String contrasenia = resulSet.getString("contrasenia");
            String profesion = resulSet.getString("profesion");

            Especialista especialista = new Especialista(correo, nombre1, nombre2, apellidoP, apellidoM,area, numTrabajador, contrasenia, profesion);
            listaEspecialistas.add(especialista);
        }
        conexionBD.desconectar();
        return listaEspecialistas;
    }
    
    //Obtener especialista por id
    public Especialista obtenerPorId(String correo) throws SQLException {
        Especialista especialista = null;

        String sql = "SELECT * FROM ESPECIALISTA WHERE correo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, correo);
       
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            especialista = new Especialista(res.getString("correo"), res.getString("primer_nombre"), res.getString("segundo_nombre"), res.getString("apellido_paterno"), res.getString("apellido_materno"), res.getInt("area"), res.getInt("num_trabajador"), res.getString("contrasenia"), res.getString("profesion"));
        }
        res.close();
        conexionBD.desconectar();

        return especialista;
    }
    
    //Actualizar especialista
    public boolean actualizar(Especialista especialista) throws SQLException {
        boolean rowActualizar = false;
        //primer_nombre, segundo_nombre, apellido_paterno, apellido_materno, num_trabajador
        String sql = "UPDATE ESPECIALISTA SET correo=?, primer_nombre=?, segundo_nombre=?, apellido_paterno=?, apellido_materno=?, area=?, num_trabajador=?, contrasenia=?, profesion=? WHERE correo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, especialista.getCorreo());
        statement.setString(2, especialista.getNombre1());
        statement.setString(3, especialista.getNombre2());
        statement.setString(4, especialista.getApellidoP());
        statement.setString(5, especialista.getApellidoM());
        statement.setInt(6, especialista.getArea());
        statement.setInt(7, especialista.getNumTrabajador());
        statement.setString(8, especialista.getContrasenia());
        statement.setString(9, especialista.getProfesion());
        statement.setString(10, especialista.getCorreo());
        
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();
        return rowActualizar;
    }
    
    //Eliminar especialista
    public boolean eliminar(Especialista especialista) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM ESPECIALISTA WHERE correo=?";
        conexionBD.conectar();
        connection = conexionBD.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, especialista.getCorreo());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        conexionBD.desconectar();

        return rowEliminar;
    }
}
