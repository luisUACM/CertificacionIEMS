package com.consultoriaBuzo.CertificacionIEMS.dao;

import com.consultoriaBuzo.CertificacionIEMS.persistencia.ConexionOracle;
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
public class DTIDAOImplementacion implements DTIDAO{
    private final ConexionOracle conexion;

    /** 
     * Crea un nuevo objeto de la clase ConexionOracle para usarse al conectar
     * en el resto de métodos
     */
    public DTIDAOImplementacion() {
        conexion = new ConexionOracle();
    }
    
    @Override
    public boolean addDTI(Profesor dti) {
        boolean exito = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO dti (nombre_completo, academia, turno) "
                + "VALUES ('" + dti.getNombre() + "', '"
                + dti.getAcademia() + "', '"
                + dti.getTurno() + "')";
        
        try {
            con = conexion.getConexionOracle();
            stm = con.createStatement();
            stm.execute(sql);
            exito = true;
                
        }catch (SQLException ex){
            System.out.println("Error en clase DTIDAOImplementacion método "
                    + "addDTI.");
        }finally{
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return exito;
    }

    @Override
    public boolean updateDTI(Profesor dti) {
        boolean exito = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE dti SET nombre_completo = '" + dti.getNombre() 
                + "', " + "academia = '" + dti.getAcademia() + "', "
                + "turno = '" + dti.getTurno() + "', "
                + "estado_activo = ";
        char activo;
        
        if (dti.getActivo()){
            activo = 'Y';
        }else{
            activo = 'N';
        }
        
        sql = sql + "'" + activo + "' WHERE id_dti = '" + dti.getId() + "'";
        
        try {
            con = conexion.getConexionOracle();
            stm = con.createStatement();
            stm.execute(sql);
            exito = true;
                
        }catch (SQLException ex){
            System.out.println("Error en clase DTIDAOImplementacion método "
                    + "updateDTI.");
        }finally{
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return exito;
    }

    @Override
    public Profesor getDTI(String nombre) {
        Profesor profesor = null;
        PreparedStatement querry = null;
        ResultSet set = null;
        String sql = "SELECT * FROM dti WHERE nombre_completo = '" 
                + nombre + "'";
        
        try{
            profesor = new Profesor();
            querry = conexion.getConexionOracle().prepareStatement(sql);
            set = querry.executeQuery();
            if (set.next()){
                profesor.setId(Integer.parseInt(set.getString("id_dti")));
                profesor.setNombre(set.getString("nombre_completo"));
                profesor.setAcademia(Academia.getAcademia(set
                        .getString("academia")));
                profesor.setTurno(set.getString("turno").charAt(0));
                profesor.setActivo(set.getBoolean("estado_activo"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la clase DTIDAOImplementacion método"
                    + " getDTI(String).");
        }finally{
            if (set != null){
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            if (querry != null){
                try {
                    querry.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        return profesor;
    }

    @Override
    public List<Profesor> getDTI(Academia academia) {
        Profesor profesor;
        List lista = null;
        PreparedStatement querry = null;
        ResultSet set;
        Connection con = null;
        String sql = "SELECT * FROM dti WHERE academia = '" 
                + academia + "' AND estado_activo = 'Y'";
        
        try{
            profesor = new Profesor();
            lista = new ArrayList<>();
            con = conexion.getConexionOracle();
            querry = con.prepareStatement(sql);
            set = querry.executeQuery();
            set.getMetaData();
            while (set.next()){
                profesor.setId(Integer.parseInt(set.getString("id_dti")));
                profesor.setNombre(set.getString("nombre_completo"));
                profesor.setAcademia(Academia.getAcademia(set
                        .getString("academia")));
                profesor.setTurno(set.getString("turno").charAt(0));
                profesor.setActivo(set.getBoolean("estado_activo"));
                
                lista.add(profesor);
                profesor = new Profesor();
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la clase DTIDAOImplementacion método "
                    + "getDTI(Academia).");
        }finally{
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            if (querry != null){
                try {
                    querry.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    @Override
    public List<Profesor> getAll() {
        Profesor profesor;
        List lista = null;
        PreparedStatement querry = null;
        ResultSet set;
        Connection con = null;
        String sql = "SELECT * FROM dti ORDER BY nombre_completo ASC";
        
        try{
            profesor = new Profesor();
            lista = new ArrayList<>();
            con = conexion.getConexionOracle();
            querry = con.prepareStatement(sql);
            set = querry.executeQuery();
            set.getMetaData();
            while (set.next()){
                profesor.setId(Integer.parseInt(set.getString("id_dti")));
                profesor.setNombre(set.getString("nombre_completo"));
                profesor.setAcademia(Academia.getAcademia(set
                        .getString("academia")));
                profesor.setTurno(set.getString("turno").charAt(0));
                profesor.setActivo(set.getBoolean("estado_activo"));
                
                lista.add(profesor);
                profesor = new Profesor();
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la clase DTIDAOImplementacion método "
                    + "getAll.");
        }finally{
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            if (querry != null){
                try {
                    querry.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }
}
