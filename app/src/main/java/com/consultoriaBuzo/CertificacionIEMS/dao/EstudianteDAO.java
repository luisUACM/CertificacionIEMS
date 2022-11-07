package com.consultoriaBuzo.CertificacionIEMS.dao;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Estudiante;
import java.util.List;

/**
 *
 * @author Luis Alberto
 */
public interface EstudianteDAO {
    /**
     * Agrega un estudiante a la base de datos
     * @return true si todo salió bien, false si hubo un error
     * @param estudiante el eestudiante que se quiere agregar a la base de datos
     */
    public boolean addEstudiante(Estudiante estudiante);
    
    /**
     * Actualiza la información del estudiante en la base de datos
     * @param estudiante un objeto Profesor que contiene los nuevos datos´del 
     * estudiante
     * @return true si todo salió bien, false si hubo un error
     */
    public boolean updateEstudiante(Estudiante estudiante);
    
    /**
     * Busca a un estudiante en la base de datos por matricula, 
     * devuelve el registro
     * @param matricula la matricula del asesor a buscar
     * @return un objeto Estudiante con los datos del estudiante buscado
     */
    public Estudiante getEstudiante(String matricula);
    
    /**
     * Busca a todos los estudiantes en la base de datos que puedan egresar en 
     * el semestre en curso, esto es: que tengan 30 materias cubiertas y estén
     * activos. Devuelve una lista ordenada con todos los registros.
     * @return una lista con todos los registros de los estudiantes
     */
    public List<Estudiante>getPosiblesEgresados();
}
