package com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Estudiante;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Semestre;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            scaner = new Scanner(archivo, StandardCharsets.UTF_8);
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo.");
            Logger.getLogger(LectorConcentrado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
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
        for (i = 0; i < LINEAS_BASURA && scaner.hasNextLine(); i++){
            scaner.nextLine();
        }
        scaner.useDelimiter(",");
        
        while (scaner.hasNext()){
            saltarCampos(1);
            token = scaner.next();
            if (token.equals("")){
               break; 
            }
            matricula = token;
            
            saltarCampos(1);
            token = scaner.next();
            apellidoP = token;
            
            token = scaner.next();
            apellidoM = token;
            
            token = scaner.next();
            nombre = token;
            
            saltarCampos(1);
            token = scaner.next();
            if(token.equals("")){
                turno = ' ';
                modalidad = 'S';
            }else{
                turno = token.charAt(0);
                modalidad = 'E';
            }
            
            saltarCampos(20);
            token = scaner.next();
            if (token.equals("") || token.equals("---")){
                semestre = Semestre.calcularActual();
            }else{
                semestre = new Semestre(token);
            }
            
            saltarCampos(3);
            token = scaner.next();
            if (token.equals("") || token.equals("---")){
                reinscritas = 0;
            }else{
                reinscritas = Integer.parseInt(token);
            }
            
            token = scaner.next();
            if (token.equals("") || token.equals("---")){
                cubiertas = 0;
            }else{
                cubiertas = Integer.parseInt(token);
            }
            
            scaner.nextLine();
            
            estudiante = new Estudiante();
            estudiante.setMatricula(matricula);
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
        }
        scaner.close();
        return lista;
    }
    
    /**
     * Salta n campos del concentrado de manera segura. De forma que si hay un 
     * caracter '"' dentro del campo csv, salta todas las comas que haya hasta
     * encontrar '"' de nuevo
     * @param n la cantidad de campos que se quiere saltar
     */
    private void saltarCampos(int n){
        int i;
        String token;
        for (i = 0; i < n; i++){
            token = scaner.next();
            if ( (!token.equals("")) && (token.charAt(0) == '"') ){
                while ( (!token.equals("")) && (token.charAt(token.length() - 1) != '"') ){
                    token = scaner.next();
                }
            }
        }
    }
}
