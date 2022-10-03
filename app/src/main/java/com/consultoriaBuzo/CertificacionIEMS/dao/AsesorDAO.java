package com.consultoriaBuzo.CertificacionIEMS.dao;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Academia;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Profesor;
import java.util.List;

/**
 *
 * @author Luis Alberto
 */
public interface AsesorDAO {
    /**
     * Agrega un asesor a la base de datos
     * @return true si todo salió bien, false si hubo un error
     * @param asesor el asesor que se quiere agregar a la base de datos
     */
    public boolean addAsesor(Profesor asesor);
    
    /**
     * Actualiza la información del asesor en la base de datos
     * @param asesor un objeto Profesor que contiene los nuevos datos´del asesor
     * @return true si todo salió bien, false si hubo un error
     */
    public boolean updateAsesor(Profesor asesor);
    
    /**
     * Busca a un asesor en la base de datos por nombre, devuelve el registro
     * @param nombre el nombre del asesor a buscar
     * @return un objeto Profesor con los datos del asesor buscado
     */
    public Profesor getAsesor(String nombre);
    
    /**
     * Busca a todos los asesores en la base de datos de una academia,devuelve 
     * una lista con todos los registros con el atributo estado_activo = true
     * @param academia la academia de la que se quieren buscar los asesores
     * @return una lista con todos los registros de los asesores de dicha academia
     */
    public List<Profesor>getAsesor(Academia academia);
    
    /**
     * Busca a todos los asesores en la base de datos,devuelve 
     * una lista con todos los registros con el atributo estado_activo = true
     * @param academia la academia de la que se quieren buscar los asesores
     * @return una lista con todos los registros de los asesores
     */
    public List<Profesor>getAll();
}
