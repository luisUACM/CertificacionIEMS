package com.consultoriaBuzo.CertificacionIEMS.dao;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Estudiante;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Semestre;
import com.consultoriaBuzo.CertificacionIEMS.persistencia.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Alberto
 */
public class EstudianteDAOImplementacion implements EstudianteDAO {

    ConexionOracle conexion;

    /** 
     * Crea un nuevo objeto de la clase ConexionOracle para usarse al conectar
     * en el resto de métodos
     */
    public EstudianteDAOImplementacion() {
        conexion = new ConexionOracle();
    }
    
    @Override
    public boolean addEstudiante(Estudiante estudiante) {
        boolean exito = false;
        Statement stm = null;
        Connection con = null;
        String sql;
        
        sql = "INSERT INTO estudiante (matricula, nombre, apellido_p, "
                + "apellido_m, modalidad, turno, asig_c, asig_reins, "
                + "asig_c_final, ultimo_semestre) VALUES "
                + "('" + estudiante.getMatricula() + "', '" 
                + estudiante.getNombre() +  "', '"
                + estudiante.getApellidoP() + "', '"
                + estudiante.getApellidoM() + "', '" 
                + estudiante.getModalidad() + "', '" 
                + estudiante.getTurno() + "', '" 
                + estudiante.getCubiertas() + "', '" 
                + estudiante.getReinscritas() + "', '" 
                + estudiante.getCubiertasFinal() + "', '"
                + estudiante.getSemestre() + "')";
        
        try {
            con = conexion.getConexionOracle();
            stm = con.createStatement();
            stm.execute(sql);
            exito = true;
                
        }catch (SQLException ex){
            System.out.println("Error en clase EstudianteDAOImplementacion método "
                    + "addEstudiante.");
            System.out.println(ex);
        }finally{
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        
        return exito;
    }

    @Override
    public boolean updateEstudiante(Estudiante estudiante) {
        boolean exito = false;
        Statement stm = null;
        Connection con = null;
        char activo;
        String sql;
        
        if (estudiante.isActivo()){
            activo = 'Y';
        }else{
            activo = 'N';
        }
        
        sql = "UPDATE estudiante SET "
                + "nombre = '" + estudiante.getNombre() + "', " 
                + "apellido_p = '" + estudiante.getApellidoP() + "', "
                + "apellido_m = '" + estudiante.getApellidoM() + "', "
                + "modalidad = '" + estudiante.getModalidad() + "', "
                + "turno = '" + estudiante.getTurno() + "', "
                + "asig_c = '" + estudiante.getCubiertas() + "', "
                + "asig_reins ='" + estudiante.getReinscritas() + "', "
                + "asig_c_final = '" + estudiante.getCubiertasFinal() + "', "
                + "ultimo_semestre = '" + estudiante.getSemestre() + "', "
                + "estado_activo = '" + activo + "' "
                + "WHERE matricula = '" + estudiante.getMatricula() + "'";
        
        try {
            con = conexion.getConexionOracle();
            stm = con.createStatement();
            stm.execute(sql);
            exito = true;
                
        }catch (SQLException ex){
            System.out.println("Error en clase EstudianteDAOImplementacion método "
                    + "updateEstudiante.");
            System.out.println(ex);
        }finally{
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        
        return exito;
    }

    @Override
    public Estudiante getEstudiante(String matricula) {
        Estudiante estudiante = null;
        Connection con = null;
        PreparedStatement querry = null;
        ResultSet set = null;
        String sql = "SELECT * FROM estudiante WHERE matricula = '" 
                + matricula + "'";
        
        try{
            con = conexion.getConexionOracle();
            querry = con.prepareStatement(sql);
            set = querry.executeQuery();
            if (set.next()){
                estudiante = new Estudiante();
                estudiante.setMatricula(matricula);
                estudiante.setNombre(set.getString("nombre"));
                estudiante.setApellidoP(set.getString("apellido_p"));
                estudiante.setApellidoM(set.getString("apellido_m"));
                estudiante.setModalidad(set.getString("modalidad").charAt(0));
                estudiante.setTurno(set.getString("turno").charAt(0));
                estudiante.setCubiertas(Integer.parseInt(
                        set.getString("asig_c")));
                estudiante.setReinscritas(Integer.parseInt(
                        set.getString("asig_reins")));
                estudiante.setCubiertasFinal(Integer.parseInt(
                        set.getString("asig_c_final")));
                estudiante.setSemestre(new Semestre(
                        set.getString("ultimo_semestre")));
                estudiante.setActivo(set.getBoolean("estado_activo"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la clase EstudianteDAOImplementacion "
                    + "método getEstudiante");
            System.out.println(ex);
        }finally{
            if (set != null){
                try {
                    set.close();
                } catch (SQLException ex) {
                }
            }
            if (querry != null){
                try {
                    querry.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        return estudiante;
    }

    @Override
    public List<Estudiante> getPosiblesEgresados() {
        List<Estudiante> lista = new ArrayList<>();
        Estudiante estudiante;
        Connection con = null;
        PreparedStatement querry = null;
        ResultSet set = null;
        String sql = "SELECT * FROM estudiante WHERE asig_c > 28 AND "
                + "estado_activo = 'Y' ORDER BY matricula ASC";
        
        try{
            con = conexion.getConexionOracle();
            querry = con.prepareStatement(sql);
            set = querry.executeQuery();
            while (set.next()){
                estudiante = new Estudiante();
                estudiante.setMatricula(set.getString("matricula"));
                estudiante.setNombre(set.getString("nombre"));
                estudiante.setApellidoP(set.getString("apellido_p"));
                estudiante.setApellidoM(set.getString("apellido_m"));
                estudiante.setModalidad(set.getString("modalidad").charAt(0));
                estudiante.setTurno(set.getString("turno").charAt(0));
                estudiante.setCubiertas(Integer.parseInt(
                        set.getString("asig_c")));
                estudiante.setReinscritas(Integer.parseInt(
                        set.getString("asig_reins")));
                estudiante.setCubiertasFinal(Integer.parseInt(
                        set.getString("asig_c_final")));
                estudiante.setSemestre(new Semestre(
                        set.getString("ultimo_semestre")));
                estudiante.setActivo(set.getBoolean("estado_activo"));
                lista.add(estudiante);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la clase EstudianteDAOImplementacion "
                    + "método getEstudiante");
            System.out.println(ex);
        }finally{
            if (set != null){
                try {
                    set.close();
                } catch (SQLException ex) {
                }
            }
            if (querry != null){
                try {
                    querry.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        return lista;
    }
    
}
