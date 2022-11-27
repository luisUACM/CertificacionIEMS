package com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion;

import com.consultoriaBuzo.CertificacionIEMS.dao.EstudianteDAO;
import com.consultoriaBuzo.CertificacionIEMS.dao.EstudianteDAOImplementacion;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Estudiante;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase se encarga de leer y escribir archivos. La carpeta en donde la app
 * guarda todos los archivos es la siguiente
 * C:/Users/{NombreUsuario}/appdata/Roaming/CertificacionIEMS 
 * @author Luis Alberto
 */
public class ManagerArchivos {
    
    private final String appData = System.getenv("APPDATA") + 
            "\\CertificacionIEMS";
    
    /**
     * Al inicializar crea la carpeta ~/appdata/Roaming/CertificacionIEMS
     * si es que no existe
     */
    public ManagerArchivos(){
        File carpeta = new File(appData);
        if (! carpeta.exists()){
            carpeta.mkdir();
        }
    }
    
    /**
     * Guarda la lista de matrículas de estudiantes en un archivo txt localizado
     * en appdata. Sobreescribe cualquier archivo ya existente
     * @param lista la lista de estudiantes a guardar
     * @throws java.io.IOException
     */
    public void guardarCandidatos(List<Estudiante> lista) throws IOException{
        File archivo = new File(appData + "\\candidatos.txt");
        String contenido = "";
        FileWriter fWriter = new FileWriter(archivo, false);
        
        if(! archivo.exists()){
            archivo.createNewFile();
        }
        
        for(Estudiante e: lista){
            contenido += e.getMatricula() + " ";
        }
        
        fWriter.write(contenido);
        fWriter.close();
    }
    
    /**
     * Lee el arrchivo candidatos.txt y regresa la lista de los estudiantes,
     * buscandolos por matricula en la base de datos
     * @return la lista con los estudiantes
     * @throws java.io.FileNotFoundException 
     */
    public List<Estudiante> obtenerCandidatos() throws FileNotFoundException{
        File archivo = new File(appData + "\\candidatos.txt");
        Scanner scaner = new Scanner(archivo);
        Estudiante estudiante;
        List<Estudiante> lista = new ArrayList<>();
        String matricula;
        EstudianteDAO dao = new EstudianteDAOImplementacion();
        
        while (scaner.hasNext()){
            matricula = scaner.next();
            estudiante = dao.getEstudiante(matricula);
            lista.add(estudiante);
        }
        return lista;
    }
    
    /**
     * Verifica si ya existe un archivo dentro de appdata con un nombre dado
     * @param file el nombre del archivo que se va a buscar
     * @return true si existe, false si no existe
     */
    public boolean existeArchivo(String file){
        File archivo = new File(appData + "\\" + file);
        return archivo.exists();
    }
}
