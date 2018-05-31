/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Asistencia;
import Modelo.Estudiante;
import Util.ConsultaAsistencia;
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
public class AsistenciaDAO {
    
    private Connection connection;

    public AsistenciaDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }
    
    public ArrayList<ConsultaAsistencia> getAsistenciaFecha(int idCurso,String fecha) throws SQLException{
        ArrayList<ConsultaAsistencia> asis=new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select estudiante.nombre,asistencia.vino from estudiante,estudiantecurso,asistencia where estudiante.documento = estudiantecurso.idestudiante and asistencia.idestudiantecurso = estudiantecurso.id and estudiantecurso.idcurso ="+idCurso+" and  asistencia.fecha ='" + fecha+"'");
        while (rs.next()) {
            ConsultaAsistencia ca= new ConsultaAsistencia();
            ca.setNombre(rs.getString("nombre"));
            ca.setVino(rs.getString("vino"));
            asis.add(ca);
        }
        return asis;
    }
    
    public ArrayList<ConsultaAsistencia> getAsistenciaEstudiante(int idCurso,String nombre) throws SQLException{
        ArrayList<ConsultaAsistencia> asis=new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select estudiante.nombre,asistencia.fecha from  estudiante,asistencia,estudiantecurso where estudiante.documento = estudiantecurso.idestudiante and asistencia.idestudiantecurso = estudiantecurso.id and estudiantecurso.idcurso ="+idCurso+" and estudiante.nombre= '"+ nombre +"' and asistencia.vino = 'Ausente'");
        while (rs.next()) {
            ConsultaAsistencia ca= new ConsultaAsistencia();
            ca.setNombre(rs.getString("nombre"));
            ca.setFecha(rs.getString("fecha"));
            asis.add(ca);
        }
        return asis;
    }
    
    public boolean comprobarAsistencia (int idEstudianteCurso , String fecha) throws SQLException{
        String aaaa = null;
        Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery("select * from asistencia where idestudiantecurso = "+idEstudianteCurso+"and fecha= '" +fecha+ "'");
         boolean aux = true;
         
         if(rs.next()== true){
             aux = true;
         }else{
             aux = false;
         }
         return aux;
       
    }
    
    
    public void addAsistencia(Asistencia asistencia) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into asistencia values (?,?,?,1)");
        preparedStatement.setInt(1, asistencia.getIdEstudianteCurso());
        preparedStatement.setString(2, asistencia.getFecha());
        preparedStatement.setString(3, asistencia.getVino());
       
       
        preparedStatement.executeUpdate();
    }

    public ArrayList<Asistencia> getAsistenciaByEst(int estCur) throws SQLException {
        ArrayList<Asistencia> asistencias=new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from asistencia where idestudiantecurso = "+estCur+" and delete=1");
        while (rs.next()){
            Asistencia a=new Asistencia();
            a.setFecha(rs.getString("fecha"));
            a.setVino(rs.getString("vino"));
            asistencias.add(a);
        }
        return asistencias;
    }
     public ArrayList<Estudiante> getAsistenciaTomada(String id, String fecha) throws SQLException {
        ArrayList<Estudiante> asistencias=new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select estudiantecurso.idestudiante from estudiantecurso,asistencia,directorcurso where estudiantecurso.id = asistencia.idestudiantecurso and directorcurso.idcurso = estudiantecurso.idcurso and directorcurso.cedula = '"+id+"' and asistencia.fecha = '"+fecha+"'");
        while (rs.next()){
            Estudiante a=new Estudiante();
            a.setIdEstudiante(rs.getString("idestudiante"));
            asistencias.add(a);
        }
        return asistencias;
    }
    
}
