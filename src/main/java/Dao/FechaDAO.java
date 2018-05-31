/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Fecha;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author FiJus
 */
public class FechaDAO {
    private Connection connection;

    public FechaDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }
    
    public ArrayList<Fecha> allFechas() throws SQLException{
        ArrayList<Fecha> fechas=new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from fecha");
        while (rs.next()) {
            Fecha f=new Fecha();
            f.setIdFecha(rs.getInt("id"));
            f.setFecha(rs.getString("fecha"));
            fechas.add(f);
        }
        return fechas;
    }
}
