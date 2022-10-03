package com.consultoriaBuzo.CertificacionIEMS.dao;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Academia;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Alberto
 */
public class AsesorDAOImplementacion implements AsesorDAO{

    private final ConexionOracle conexion;
    
    /** 
     * Crea un nuevo objeto de la clase ConexionOracle para usarse al conectar
     * en el resto de métodos
     */
    public AsesorDAOImplementacion() {
        conexion = new ConexionOracle();
    }
    
    @Override
    public boolean addAsesor(Profesor asesor) {
        boolean exito = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO asesor (nombre_completo, academia) "
                + "VALUES ('" + asesor.getNombre() + "', '"
                + asesor.getAcademia() + "')";
        
        try {
            con = conexion.getConexionOracle();
            stm = con.createStatement();
            stm.execute(sql);
            exito = true;
                
        }catch (SQLException ex){
            System.out.println("Error en clase AsesorDAOImplementacion método "
                    + "addAsesor.");
        }finally{
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsesorDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsesorDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return exito;
    }

    @Override
    public boolean updateAsesor(Profesor asesor) {
        boolean exito = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE asesor SET nombre_completo = '" + asesor.getNombre() 
                + "', " + "academia = '" + asesor.getAcademia() 
                + "', " + "estado_activo = '";
        char activo;
        
        if (asesor.getActivo()){
            activo = 'Y';
        }else{
            activo = 'N';
        }
        
        sql+= "" + activo + "' WHERE id_asesor = '" + asesor.getId() + "'";
        
        try {
            con = conexion.getConexionOracle();
            stm = con.createStatement();
            stm.execute(sql);
            exito = true;
                
        }catch (SQLException ex){
            System.out.println("Error en clase AsesorDAOImplementacion método "
                    + "updateAsesor.");
        }finally{
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsesorDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsesorDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return exito;
    }

    @Override
    public Profesor getAsesor(String nombre) {
        Profesor profesor = null;
        PreparedStatement querry = null;
        ResultSet set = null;
        String sql = "SELECT * FROM asesor WHERE nombre_completo = '" 
                + nombre + "'";
        
        try{
            profesor = new Profesor();
            querry = conexion.getConexionOracle().prepareStatement(sql);
            set = querry.executeQuery();
            if (set.next()){
                profesor.setId(Integer.parseInt(set.getString("id_asesor")));
                profesor.setNombre(set.getString("nombre_completo"));
                profesor.setAcademia(Academia.getAcademia(set
                        .getString("academia")));
                profesor.setActivo(set.getBoolean("estado_activo"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la clase AsesorDAOImplementacion método "
                    + "getAsesor(String).");
        }finally{
            if (set != null){
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsesorDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            if (querry != null){
                try {
                    querry.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsesorDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        return profesor;
    }

    @Override
    public List<Profesor> getAsesor(Academia academia) {
        Profesor profesor = null;
        List lista = null;
        PreparedStatement querry = null;
        ResultSet set = null;
        String sql = "SELECT * FROM asesor WHERE academia = '" 
                + academia.toString() + "' AND estado_activo = 'Y'";
        
        try{
            profesor = new Profesor();
            lista = new ArrayList<>();
            querry = conexion.getConexionOracle().prepareStatement(sql);
            set = querry.executeQuery();
            while (set.next()){
                profesor.setId(Integer.parseInt(set.getString("id_asesor")));
                profesor.setNombre(set.getString("nombre_completo"));
                profesor.setAcademia(Academia.getAcademia(set
                        .getString("academia")));
                profesor.setActivo(set.getBoolean("estado_activo"));
                
                lista.add(profesor);
                profesor = new Profesor();
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la clase AsesorDAOImplementacion método "
                    + "getAsesor(Asesor).");
        }finally{
            if (set != null){
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsesorDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            if (querry != null){
                try {
                    querry.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsesorDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    @Override
    public List<Profesor> getAll() {
        Profesor profesor = null;
        List lista = null;
        PreparedStatement querry = null;
        ResultSet set = null;
        String sql = "SELECT * FROM asesor";
        
        try{
            profesor = new Profesor();
            lista = new ArrayList<>();
            querry = conexion.getConexionOracle().prepareStatement(sql);
            set = querry.executeQuery();
            while (set.next()){
                profesor.setId(Integer.parseInt(set.getString("id_asesor")));
                profesor.setNombre(set.getString("nombre_completo"));
                profesor.setAcademia(Academia.getAcademia(set
                        .getString("academia")));
                profesor.setActivo(set.getBoolean("estado_activo"));
                
                lista.add(profesor);
                profesor = new Profesor();
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la clase AsesorDAOImplementacion método "
                    + "getAsesor(Asesor).");
        }finally{
            if (set != null){
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsesorDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            if (querry != null){
                try {
                    querry.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsesorDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }
    
}
