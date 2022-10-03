package com.consultoriaBuzo.CertificacionIEMS.dao;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Academia;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Profesor;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Luis Alberto
 */
public interface DTIDAO {
    /**
     * Agrega un DTI a la base de datos
     * @return true si todo salió bien, false si hubo un error
     * @param dti el DTI que se quiere agregar a la base de datos
     */
    public boolean addDTI(Profesor dti);
    
    /**
     * Actualiza la información del DTI en la base de datos
     * @param dti un objeto Profesor que contiene los nuevos datos del DTI
     * @param id la id del registro del DTI que se quiere actualizar
     * @return true si todo salió bien, false si hubo un error
     */
    public boolean updateDTI(Profesor dti);
    
    /**
     * Busca a un DTI en la base de datos por nombre, devuelve el registro
     * @param nombre el nombre del DTI a buscar
     * @return un objeto Profesor con los datos del DTI buscado
     */
    public Profesor getDTI(String nombre);
    
    /**
     * Busca a todos los DTI en la base de datos de una academia, devuelve una 
     * lista con todos los registros con el atributo estado_activo = true
     * @param academia la academia de la que se quieren buscar los DTI's
     * @return una lista con todos los registros de los DTI de dicha academia
     */
    public List<Profesor>getDTI(Academia academia);
    
    /**
     * Busca a todos los DTI en la base de datos, devuelve una 
     * lista con todos los registros con el atributo estado_activo = true
     * @return una lista con todos los registros de los DTI
     */
    public List<Profesor>getAll();
}
