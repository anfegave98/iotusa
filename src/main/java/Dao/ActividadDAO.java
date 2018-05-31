/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Actividad;
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
public class ActividadDAO {

    private Connection connection;

    public ActividadDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void addActividad(String nombre, int idTema) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into actividad(nombre,idtema,delete) values (?,?,1)");
        preparedStatement.setString(1, nombre);
        preparedStatement.setInt(2, idTema);
        preparedStatement.executeUpdate();
    }

    public ArrayList<Actividad> getAllActividades(int idT) throws SQLException {
        ArrayList<Actividad> actividad = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from actividad where delete=1 and idtema="+idT);
        while (rs.next()) {
            Actividad c = new Actividad();
            c.setIdTema(rs.getInt("idtema"));
            c.setNombre(rs.getString("nombre"));
            c.setId(rs.getInt("id"));
            actividad.add(c);
        }
        return actividad;
    }
    
    public ArrayList<Actividad> getAllActividadesConNota(String id) throws SQLException {
        ArrayList<Actividad> actividad = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select nota.idactividad from cursomateria,tema,actividad,nota where cursomateria.id = tema.idcm and tema.id = actividad.idtema and nota.idactividad = actividad.id and cursomateria.idprofesor = '"+id+"'");
        while (rs.next()) {
            Actividad c = new Actividad();
            c.setId(rs.getInt("idactividad"));
            actividad.add(c);
        }
        return actividad;
    }
    
    public ArrayList<Actividad> getAllActividadesProfesor(String id) throws SQLException {
        ArrayList<Actividad> actividad = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select actividad.id, actividad.nombre from cursomateria,tema,actividad where cursomateria.id = tema.idcm and tema.id = actividad.idtema and cursomateria.idprofesor = '"+id+"'");
        while (rs.next()) {
            Actividad c = new Actividad();
            c.setId(rs.getInt("id"));
            c.setNombre(rs.getString("nombre"));           
            actividad.add(c);
        }
        return actividad;
    }
    
    public void deleteActividad(int idA) throws SQLException{
         PreparedStatement preparedStatement = connection.prepareStatement("update actividad set delete=0 where id="+idA);
        
        preparedStatement.executeUpdate();
    }
    
    public void updateActividad(Actividad e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update actividad set nombre=?,idtema=?" + " where id=?");
        preparedStatement.setString(1, e.getNombre());
        preparedStatement.setInt(2, e.getIdTema());
        preparedStatement.setInt(3, e.getId());   
        preparedStatement.executeUpdate();
    }
    
     public Actividad getActividadByID(int idA) throws SQLException, URISyntaxException {
        Actividad actividad= new Actividad();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from actividad where id=" + idA);
        while (rs.next()) {
            actividad.setId(rs.getInt("id"));
            actividad.setNombre(rs.getString("nombre"));
            actividad.setIdTema(rs.getInt("idtema"));
            
        }
        return actividad;
    }
    
}
