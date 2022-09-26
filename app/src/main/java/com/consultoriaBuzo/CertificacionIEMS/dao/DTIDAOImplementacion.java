package com.consultoriaBuzo.CertificacionIEMS.dao;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Academia;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Profesor;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
            System.out.println("Error en clase DTIDAO método addDTI.");
        }finally{
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DTIDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return exito;
    }

    @Override
    public boolean updateDTI(String nombre, Academia academia, boolean estadoActivo) {
        return true;
    }
    
    
}
