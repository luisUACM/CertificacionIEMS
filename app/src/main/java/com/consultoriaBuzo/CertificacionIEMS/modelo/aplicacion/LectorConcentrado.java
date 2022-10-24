package com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Estudiante;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Semestre;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Luis Alberto
 */
public class LectorConcentrado {
    
    private static final int LINEAS_BASURA = 5;
    private Scanner scaner;

    /**
     * Inicializa el escaner con el archivo del concentrado.
     * @param archivo el archivo de concentrado a leer
     */
    public LectorConcentrado(File archivo) {
        try {
            scaner = new Scanner(archivo);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir el archivo.");
            Logger.getLogger(LectorConcentrado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Obtiene una lista de estudiantes leyendo la información del concentrado.
     * @return la lista de estudiantes.
     */
    public List<Estudiante> obtenerLista(){
        ArrayList lista = new ArrayList<>();
        Estudiante estudiante;
        int i;
        String token;
        String matricula;
        String nombre;
        String apellidoP;
        String apellidoM;
        char modalidad;
        char turno;
        int cubiertas;
        int reinscritas;
        Semestre semestre;
        Pattern patron = Pattern.compile("[^,],");
        for (i = 0; i < LINEAS_BASURA && scaner.hasNextLine(); i++){
            scaner.nextLine();
        }
        System.out.println("Despues for");
        //scaner.useDelimiter(",");
        
        while(scaner.hasNext(patron)){
            System.out.println("while");
            scaner.next();
            token = scaner.next();
            token = token.substring(0, token.length());
            matricula = token;
            
            scaner.next();
            token = scaner.next();
            token = token.substring(0, token.length());
            apellidoP = token;
            
            token = scaner.next();
            token = token.substring(0, token.length());
            apellidoM = token;
            
            token = scaner.next();
            token = token.substring(0, token.length());
            nombre = token;
            
            scaner.next();
            token = scaner.next();
            token = token.substring(0, token.length());
            if(token.equals("")){
                turno = ' ';
                modalidad = 'S';
            }else{
                turno = token.charAt(0);
                modalidad = 'E';
            }
            
            scaner.next();  //Son necesarias, hay campos inútiles
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            scaner.next();
            token = scaner.next();
            token = token.substring(0, token.length());
            semestre = new Semestre(token);
            
            scaner.next();
            scaner.next();
            scaner.next();
            token = scaner.next();
            token = token.substring(0, token.length());
            reinscritas = Integer.parseInt(token);
            
            token = scaner.next();
            token = token.substring(0, token.length());
            cubiertas = Integer.parseInt(token);
            
            scaner.nextLine();
            
            estudiante = new Estudiante();
            estudiante.setMatricula(matricula);
            estudiante.setMatricula(token);
            estudiante.setNombre(nombre);
            estudiante.setApellidoP(apellidoP);
            estudiante.setApellidoM(apellidoM);
            estudiante.setModalidad(modalidad);
            estudiante.setTurno(turno);
            estudiante.setCubiertas(cubiertas);
            estudiante.setReinscritas(reinscritas);
            estudiante.setCubiertasFinal(cubiertas);
            estudiante.setSemestre(semestre);
            estudiante.setActivo(true);
            lista.add(estudiante);
            
            if(scaner.hasNext(",,,,,,,")){
               break; 
            }
        }
        
        return lista;
    }
    
}
