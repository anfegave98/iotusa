/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Curso;
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
public class CursoDAO {

    private Connection connection;

    public CursoDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void addCurso(Curso curso) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into curso(nombre,numeroestudiantes,delete) values (?,?,1)");
        preparedStatement.setString(1, curso.getNombre());
        preparedStatement.setInt(2, 0);
        preparedStatement.executeUpdate();
    }
    
    public void deleteCurso(int idCurso) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("update curso set delete=0 where id=?");
        preparedStatement.setInt(1, idCurso);
        preparedStatement.executeUpdate();
    }
    
    public void updateCurso(Curso curso) throws SQLException{
        PreparedStatement preparedStatement= connection.prepareStatement("update curso set nombre=? where id=?");
        preparedStatement.setString(1, curso.getNombre());
        preparedStatement.setInt(2, curso.getIdCurso());
        preparedStatement.executeUpdate();
    }

    public Curso getCursoById(int idCurso) throws SQLException {
        Curso c = new Curso();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from curso where delete=1 and id=" + idCurso);
        while (rs.next()) {
            c.setIdCurso(idCurso);
            c.setNombre(rs.getString("nombre"));
            c.setNumeroEstudiantes(rs.getInt("numeroestudiantes"));
        }
        return c;
    }

    public ArrayList<Curso> getAllCursos() throws SQLException, URISyntaxException {
        ArrayList<Curso> cursos = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from curso where delete=1");
        while (rs.next()) {
            Curso c = new Curso();
            c.setIdCurso(rs.getInt("id"));
            c.setNombre(rs.getString("nombre"));
            c.setNumeroEstudiantes(rs.getInt("numeroestudiantes"));

            cursos.add(c);
        }
        return cursos;
    }
    
    public void updateNumeroEstudiantesCurso(int idCurso) throws SQLException, URISyntaxException, ClassNotFoundException, IOException{
        CursoDAO dao = new CursoDAO();
        Curso c = dao.getCursoById(idCurso);
        int numeroEstudiantes = c.getNumeroEstudiantes()+1;
        PreparedStatement preparedStatement= connection.prepareStatement("update curso set numeroestudiantes="+ numeroEstudiantes+ " where id=" + idCurso);
       
        preparedStatement.executeUpdate();
    }

}
