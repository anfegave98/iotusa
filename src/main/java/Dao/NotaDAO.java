/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Util.RetroalimentacionNota;
import Util.BoletinEstudiante;
import Modelo.Nota;
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
 * @author JulDa
 */
public class NotaDAO {

    private Connection connection;

    public NotaDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public ArrayList<Nota> getNotaByIdEstudiante(int id_estudiante) throws SQLException, URISyntaxException {
        ArrayList<Nota> notas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from nota where idestudiante=?" + id_estudiante);
        while (rs.next()) {
            Nota n = new Nota();
            n.setIdEstudianteCurso(rs.getInt("id_Est"));
            n.setNota(rs.getFloat("nota"));
            notas.add(n);
        }
        return notas;
    }
    
    public ArrayList<Nota> getNotaByIdActividad(int idActividad) throws SQLException, URISyntaxException {
        ArrayList<Nota> notas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select estudiante.nombre, nota.nota from estudiante,nota,estudiantecurso,actividad where nota.idestudiantecurso = estudiantecurso.id and estudiantecurso.idestudiante=estudiante.documento and nota.idactividad=actividad.id  and actividad.id=" + idActividad);
        while (rs.next()) {
            Nota nota = new Nota();
            nota.setNombre(rs.getString("nombre"));
            nota.setNota(rs.getFloat("nota"));
            notas.add(nota);
            ;
            
        }
        return notas;
    }
    
    public ArrayList<Nota> getAllNotas() throws SQLException {
        ArrayList<Nota> notas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from nota where delete=1");
        while (rs.next()) {
            Nota n = new Nota();
            n.setIdEstudianteCurso(rs.getInt("idEstudianteCurso"));
            n.setIdActividad(rs.getInt("idActividad"));
            n.setNota(rs.getFloat("nota"));
            n.setDetallesExtra("detallesExtra");
            notas.add(n);
        }
        return notas;
    }
    
    public ArrayList<BoletinEstudiante> getNotasBoletin(String idEst) throws SQLException {
        ArrayList<BoletinEstudiante> notas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select materia.nombre as materia,AVG(nota.nota) as nota from tema,nota,actividad,estudiantecurso,cursomateria,materia,estudiante where tema.id=actividad.idtema and actividad.id=nota.idactividad and cursomateria.idmateria=materia.id and tema.idcm=cursomateria.id and estudiantecurso.id = nota.idestudiantecurso and estudiantecurso.idestudiante='"+idEst+"' GROUP BY materia.nombre");
        
        while(rs.next()){
            BoletinEstudiante n= new BoletinEstudiante();
            n.setMateria(rs.getString("materia"));
            n.setNota(rs.getFloat("nota"));
            notas.add(n);
        }
        return notas;
    }
    
    public ArrayList<BoletinEstudiante> getTemasBoletin(String idEst) throws SQLException {
       ArrayList<BoletinEstudiante> notas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select materia.nombre as materia,tema.idcm,tema.nombre as tema,AVG(nota.nota) as notaPromedio"
                + " from tema,nota,actividad,estudiantecurso,cursomateria,materia where tema.id=actividad.idtema and "
                + "actividad.id=nota.idactividad and cursomateria.idmateria=materia.id and tema.idcm=cursomateria.id and "
                + "estudiantecurso.id = nota.idestudiantecurso and estudiantecurso.idestudiante='"+idEst+"' "
                + "GROUP BY tema.idcm,tema.nombre,materia.nombre"); 
        while(rs.next()){
            BoletinEstudiante n=new BoletinEstudiante();
            n.setIdcm(rs.getInt("idcm"));
            n.setMateria(rs.getString("materia"));
            n.setTema(rs.getString("tema"));
            n.setNota(rs.getFloat("notapromedio"));
            notas.add(n);
        }
        return notas;
    }

    public void addNota(float nota, int IdEstudianteCurso, int IdActividad, String DetallesExtra) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into nota (nota,idestudiantecurso,idactividad,detallesextra,delete) values (?,?,?,?,1)");
        preparedStatement.setFloat(1, nota);
        preparedStatement.setInt(2, IdEstudianteCurso);
        preparedStatement.setInt(3, IdActividad);
        preparedStatement.setString(4, DetallesExtra);
        preparedStatement.executeUpdate();
    }
    
    public void eliminarNota(int idA) throws SQLException{
         PreparedStatement preparedStatement = connection.prepareStatement("update nota set delete=0 where idActividad="+idA);
        
        preparedStatement.executeUpdate();
    }
    
    public void updateNota(Nota e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update nota set nota=?,idestudiantecurso=?, idactividad=?,detallesextra=?" + " where id=?");
        preparedStatement.setFloat(1, e.getNota());
        preparedStatement.setInt(2, e.getIdEstudianteCurso());
        preparedStatement.setInt(3, e.getIdActividad());
        preparedStatement.setString(4, e.getDetallesExtra());
        preparedStatement.executeUpdate();
    }
    
}
