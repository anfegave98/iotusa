/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Tema;
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
public class TemaDAO {

    private Connection connection;

    public TemaDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void addTema(int idCM, String nombre) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into tema(nombre,idcm,delete) values (?,?,1)");
        preparedStatement.setString(1, nombre);
        preparedStatement.setInt(2, idCM);
        preparedStatement.executeUpdate();
    }

    public ArrayList<Tema> getAllTemas(int idCM) throws SQLException {
        ArrayList<Tema> temas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from tema where delete=1 and idcm=" + idCM);
        while (rs.next()) {
            Tema c = new Tema();
            c.setIdCM(rs.getInt("idcm"));
            c.setIdTema(rs.getInt("id"));
            c.setNombre(rs.getString("nombre"));
            temas.add(c);
        }
        return temas;
    }

    public void eliminarTema(int idT) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update tema set delete=0 where id=" + idT);
        preparedStatement.executeUpdate();
    }

    public void updateTema(Tema e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update tema set nombre=?" + " where id=?");
        preparedStatement.setString(1, e.getNombre());
        preparedStatement.setInt(2, e.getIdTema());
        preparedStatement.executeUpdate();
    }

    public Tema getTemaById(int idTema) throws SQLException {
        Tema c=new Tema();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from tema where delete=1 and id=" + idTema);
        while (rs.next()) {
            c.setIdCM(rs.getInt("idcm"));
            c.setIdTema(rs.getInt("id"));
            c.setNombre(rs.getString("nombre"));
        }
        return c;
    }
}
