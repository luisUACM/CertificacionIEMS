package com.consultoriaBuzo.CertificacionIEMS.dao;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Academia;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Profesor;

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
     * @param nombre nombre completo del DTI
     * @param estadoActivo true si sigue estando contratado, false de lo contrario
     * @param academia materia que imparte
     * @return true si todo salió bien, false si hubo un error
     */
    public boolean updateDTI(String nombre, Academia academia,boolean estadoActivo);
}
