/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author FiJus
 */
public class CambioDAO {
    
    private Connection connection;

    public CambioDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }
    
    public void updateActividad() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update actividad set delete = 0");
        preparedStatement.executeUpdate();
    }
    
    public void updateAsistencia() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update asistencia set delete = 0");
        preparedStatement.executeUpdate();
    }
    public void updateDirector() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update directorcurso set delete = 0");
        preparedStatement.executeUpdate();
    }
    public void updateEstudiante() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update estudiantecurso set delete = 0");
        preparedStatement.executeUpdate();
    }
    public void updateNota() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update nota set delete = 0");
        preparedStatement.executeUpdate();
    }
    public void updateEstudianteCurso() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update estudiante set idcurso = 3");
        preparedStatement.executeUpdate();
    }
    
    
    
    
    
    
    
   

    
    
}
