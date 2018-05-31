/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Profesor;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author FiJus
 */
public class ProfesorDAO {

    private Connection connection;

    public ProfesorDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public Profesor getProfesorById(String idPro) throws SQLException, URISyntaxException {
        Profesor pro = new Profesor();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from profesor where delete=1 and cedula='" + idPro+"'");
        while (rs.next()) {
            pro.setIdProfesor(rs.getString("cedula"));
            pro.setNombre(rs.getString("nombre"));
            pro.setTipoU(rs.getInt("tipou"));
            pro.setPassword(rs.getString("password"));
            pro.setCorreo(rs.getString("correo"));
            pro.setCelular(rs.getString("celular"));
            pro.setDireccion(rs.getString("direccion"));
            pro.setExperiencia(rs.getString("experiencia"));
            pro.setFechaNacimiento(rs.getString("fechanacimiento"));
            pro.setTipoSangre(rs.getString("tiposangre"));
            pro.setUsuario(rs.getString("usuario"));
        }
        return pro;
    }
    public ArrayList<Profesor> getallProfesoresLogin() throws SQLException {
        ArrayList<Profesor> profesores = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from profesor where delete=1");
        while (rs.next()) {
            Profesor pro = new Profesor();
            pro.setIdProfesor(rs.getString("cedula"));
            pro.setNombre(rs.getString("nombre"));
            pro.setTipoU(rs.getInt("tipou"));
            pro.setCorreo(rs.getString("correo"));
            pro.setCelular(rs.getString("celular"));
            pro.setDireccion(rs.getString("direccion"));
            pro.setExperiencia(rs.getString("experiencia"));
            pro.setFechaNacimiento(rs.getString("fechanacimiento"));
            pro.setTipoSangre(rs.getString("tiposangre"));
            pro.setUsuario(rs.getString("usuario"));
            pro.setPassword(rs.getString("password"));
            profesores.add(pro);
        }
        return profesores;
    }
    
    
    public ArrayList<Profesor> getallProfesores() throws SQLException {
        ArrayList<Profesor> profesores = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from profesor where delete=1 and tipou=1");
        while (rs.next()) {
            Profesor pro = new Profesor();
            pro.setIdProfesor(rs.getString("cedula"));
            pro.setNombre(rs.getString("nombre"));
            pro.setTipoU(rs.getInt("tipou"));
            pro.setCorreo(rs.getString("correo"));
            pro.setCelular(rs.getString("celular"));
            pro.setDireccion(rs.getString("direccion"));
            pro.setExperiencia(rs.getString("experiencia"));
            pro.setFechaNacimiento(rs.getString("fechanacimiento"));
            pro.setTipoSangre(rs.getString("tiposangre"));
            pro.setUsuario(rs.getString("usuario"));
            pro.setPassword(rs.getString("password"));
            profesores.add(pro);
        }
        return profesores;
    }
    
    public ArrayList<Profesor> getallProfesoresConMateria() throws SQLException {
        ArrayList<Profesor> profesores = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select profesor.nombre,profesor.cedula from profesor,cursomateria where profesor.cedula = cursomateria.idprofesor and cursomateria.\"delete\"=1 group by profesor.nombre,profesor.cedula");
        while (rs.next()) {
            Profesor pro = new Profesor();          
            pro.setNombre(rs.getString("nombre"));    
            pro.setIdProfesor(rs.getString("cedula"));
            profesores.add(pro);
        }
        return profesores;
    }
     public ArrayList<Profesor> getallProfesoresTodos() throws SQLException {
        ArrayList<Profesor> profesores = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select profesor.nombre, profesor.cedula from profesor where profesor.\"delete\"=1 and profesor.tipou = 1");
        while (rs.next()) {
            Profesor pro = new Profesor();          
            pro.setNombre(rs.getString("nombre")); 
            pro.setIdProfesor(rs.getString("cedula"));
            profesores.add(pro);
        }
        return profesores;
    }

    public void addProfesor(Profesor profe) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into profesor values (?,?,?,?,?,?,?,?,?,?,?,1)");
        preparedStatement.setString(1, profe.getIdProfesor());
        preparedStatement.setString(2, profe.getNombre());
        preparedStatement.setInt(3, profe.getTipoU());
        preparedStatement.setString(4, profe.getCorreo());
        preparedStatement.setString(5, profe.getCelular());
        preparedStatement.setString(6, profe.getDireccion());
        preparedStatement.setString(7, profe.getExperiencia());
        preparedStatement.setString(8, profe.getFechaNacimiento());
        preparedStatement.setString(9, profe.getTipoSangre());
        preparedStatement.setString(10, profe.getUsuario());
        preparedStatement.setString(11, profe.getPassword());
        preparedStatement.executeUpdate();
    }

    public void eliminarProfesor(String cedula) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update profesor set delete=0 where cedula='" + cedula+"'");

        preparedStatement.executeUpdate();
    }

    public void updateProfesor(Profesor e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update profesor set nombre=?,correo=?,celular=?,direccion=?,experiencia=?,fechanacimiento=?,tiposangre=?,usuario=?" + " where cedula=?");
        preparedStatement.setString(1, e.getNombre());
        preparedStatement.setString(2, e.getCorreo());
        preparedStatement.setString(3, e.getCelular());
        preparedStatement.setString(4, e.getDireccion());
        preparedStatement.setString(5, e.getExperiencia());
        preparedStatement.setString(6, e.getFechaNacimiento());
        preparedStatement.setString(7, e.getTipoSangre());
        preparedStatement.setString(8, e.getUsuario());
        preparedStatement.setString(9, e.getIdProfesor());
        preparedStatement.executeUpdate();
    }
}
