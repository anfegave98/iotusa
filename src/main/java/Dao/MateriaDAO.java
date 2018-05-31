/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Materia;
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
public class MateriaDAO {

    private Connection connection;

    public MateriaDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    

    public Materia getMateriaById(int idMateria) throws SQLException {
        Materia m = new Materia();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from materia where id=" + idMateria);
        while (rs.next()) {
            m.setIdMateria(idMateria);
            m.setNombre(rs.getString("nombre"));
        }
        return m;
    }

    public ArrayList<Materia> getAllMaterias() throws SQLException {
        ArrayList<Materia> materias = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from materia where delete=1");
        while (rs.next()) {
            Materia m = new Materia();
            m.setIdMateria(rs.getInt("id"));
            m.setNombre(rs.getString("nombre"));
            materias.add(m);
        }
        return materias;
    }
    
    public void addMateria(String nombreM) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("insert into materia(nombre,delete) values (?,1)");
        preparedStatement.setString(1, nombreM);
        preparedStatement.executeUpdate();
    }
    public void eliminarMateria(int idM) throws SQLException{
         PreparedStatement preparedStatement = connection.prepareStatement("update materia set delete=0 where id="+idM);
        
        preparedStatement.executeUpdate();
    }
    
    public void updateMateria(Materia e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update materia set nombre=? " + " where id=?");
        preparedStatement.setString(1, e.getNombre());
        preparedStatement.setInt(2, e.getIdMateria());
        preparedStatement.executeUpdate();
    }

}
