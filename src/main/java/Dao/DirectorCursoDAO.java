/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.DirectorCurso;
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
public class DirectorCursoDAO {

    private Connection connection;

    public DirectorCursoDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    /**
     * @param idPro= documento profesor
     * @return retorna la lista de cursos a los que pertenece un profesor
     * @throws SQLException
     * @throws URISyntaxException
     */
    public ArrayList<DirectorCurso> getAllProCur(String idPro) throws SQLException, URISyntaxException {
        ArrayList<DirectorCurso> procur = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from directorcurso where delete=1 and cedula='" + idPro+"'");
        while (rs.next()) {
            DirectorCurso c = new DirectorCurso();
            c.setIdCurso(rs.getInt("idcurso"));
            c.setIdDirector(idPro);
            procur.add(c);
        }
        return procur;
    }
    
    public DirectorCurso getDirector(String idPro) throws SQLException, URISyntaxException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select profesor.nombre,directorcurso.cedula,directorcurso.id,directorcurso.idcurso,directorcurso.fechainicio, curso.nombre as nombrecurso from profesor,directorcurso,curso where profesor.cedula = directorcurso.cedula and curso.id = directorcurso.idcurso and directorcurso.cedula = '" + idPro+"'");
        DirectorCurso c = new DirectorCurso();
        while (rs.next()) {      
            c.setCedula(rs.getString("cedula"));
            c.setIdCurso(rs.getInt("idcurso"));
            c.setNombre(rs.getString("nombre"));
            c.setFechainicio(rs.getString("fechainicio"));
            c.setIdDirector(rs.getString("id"));
            c.setNombreCurso(rs.getString("nombrecurso"));
        }
        return c;
    }
    
    
    public ArrayList<DirectorCurso> getAllDirectoresCur() throws SQLException, URISyntaxException {
        ArrayList<DirectorCurso> procur = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select profesor.nombre,directorcurso.cedula, directorcurso.fechainicio,directorcurso.idcurso from profesor,directorcurso where profesor.cedula = directorcurso.cedula and directorcurso.delete = 1");
        while (rs.next()) {
            DirectorCurso c = new DirectorCurso();
            c.setNombre(rs.getString("nombre"));
            c.setCedula(rs.getString("cedula"));
            c.setFechainicio(rs.getString("fechainicio"));
            c.setIdCurso(rs.getInt("idcurso"));
            procur.add(c);
        }
        return procur;
    }
    

    public void addDirectorCurso(String cedula, int idcurso, String fechainicio, String fechafinal) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into directorcurso(cedula,idcurso,fechainicio,fechafinal,delete) values (?,?,?,?,1)");
        preparedStatement.setString(1, cedula);
        preparedStatement.setInt(2, idcurso);
        preparedStatement.setString(3, fechainicio);
        preparedStatement.setString(4, fechafinal);
        preparedStatement.executeUpdate();

    }
    
//    public DirectorCurso getDirector(String idPro) throws SQLException, URISyntaxException {
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("select profesor.nombre,directorcurso.cedula,directorcurso.id,directorcurso.idcurso,directorcurso.fechainicio, curso.nombre as nombrecurso from profesor,directorcurso,curso where profesor.cedula = directorcurso.cedula and curso.id = directorcurso.idcurso and directorcurso.cedula = '" + idPro+"'");
//        DirectorCurso c = new DirectorCurso();
//        while (rs.next()) {      
//            
//            c.setIdCurso(rs.getInt("idcurso"));
//            c.setFechainicio(rs.getString("fechainicio"));
//            c.setIdDirector(rs.getString("id"));
//            
//        }
//        return c;
//    }

    public void deleteDirectorCurso(String idD) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update directorcurso set delete=0 where id=" + idD);
        preparedStatement.executeUpdate();
    }

    public void updateDirectorCurso(DirectorCurso e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update directorcurso set cedula=?,idcurso=?,fechainicio=?,fechafinal=?" + " where id=?");
        preparedStatement.setString(1, e.getCedula());
        preparedStatement.setInt(2, e.getIdCurso());
        preparedStatement.setString(3, e.getFechainicio());
        preparedStatement.setString(4, e.getFechafinal());
        preparedStatement.setString(5, e.getIdDirector());

        preparedStatement.executeUpdate();
    }
    
    public void updateCursoDelDirector(String cedula,int cursoNuevo) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update directorcurso set idcurso=? where cedula= '"+ cedula+"'");
        preparedStatement.setInt(1, cursoNuevo);
        preparedStatement.executeUpdate();
    }
    
   
    public boolean knowCedula(String cedula) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from directorcurso where delete=1 and cedula='" + cedula+"'");
        while(rs.next()){
            return false;
        }      
        return true;
    }

    public boolean knowCurso(int idCurso) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from directorcurso where delete=1 and idcurso=" + idCurso);
        while(rs.next()){
            return false;
        }      
        return true;
    }
    
}
