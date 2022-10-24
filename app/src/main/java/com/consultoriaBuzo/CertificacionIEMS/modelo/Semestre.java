package com.consultoriaBuzo.CertificacionIEMS.modelo;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.regex.Pattern;

/**
 *
 * @author Luis Alberto
 */
public class Semestre {
    
    private int inicio;
    private int fin;
    private char letra;

    /**
     * Inicializa el semestre con todos sus datos 
     * @param inicio año de inicio del ciclo escolar
     * @param fin año de fin del ciclo escolar
     * @param letra primer semestre (A) o segundo semestre (B) del ciclo escolar
     */
    public Semestre(int inicio, int fin, char letra) {
        this.inicio = inicio;
        this.fin = fin;
        this.letra = letra;
    }
    
    /**
     * Inicializa un Semestre vacío con los valores:
     * inicio = -1;
     * fin = -1;
     * letra = ' ';
     */
    public Semestre(){
        inicio = -1;
        fin = -1;
        letra = ' ';
    }
    
    /**
     * Inicializa el semestre con una cadena. Si la cadena no 
     * corresponde con el formato de un semestre inicializa un Semestre vacío.
     * @param str la cadena a convertir
     */
    public Semestre(String str){
        String patron = "\\d{4}\\p{Space}-\\p{Space}\\d{4} A|B";
        boolean match = Pattern.matches(patron, str);
        if(match){
            int a1;
            int a2;
            char l;

            a1 = Integer.parseInt(str.substring(0, 4));
            a2 = Integer.parseInt(str.substring(7, 11));
            l = str.substring(12, 13).charAt(0);
            
            inicio = a1;
            fin = a2;
            letra = l;
        }else{
            inicio = -1;
            fin = -1;
            letra = ' ';
        }
    }
    /**
     * Obtiene el año de inicio del semestre
     * @return año de inicio
     */
    public int getInicio() {
        return inicio;
    }

    /**
     * Establece el año de inicio del semestre
     * @param inicio año de inicio
     */
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    /**
     * Obtiene el año de fin del semestre
     * @return año de fin
     */
    public int getFin() {
        return fin;
    }

    /**
     * Establece el año de fin del semestre
     * @param fin año de fin
     */
    public void setFin(int fin) {
        this.fin = fin;
    }

    /**
     * Obtiene la letra del semestre
     * @return letra del semestre
     */
    public char getLetra() {
        return letra;
    }

    /**
     * Establece la letra del semestre
     * Los únicos valores válidos son:
     * 'A' para el primer semestre del ciclo
     * 'B' para el segundo semestre del ciclo
     * 'a' y 'b' son tansformadas a mayúsculas.
     * @param letra año de letra
     */
    public void setLetra(char letra) {
        if (letra == 'A' || letra == 'B'){
            this.letra = letra;
        }else if (letra == 'a' || letra == 'b'){
            this.letra = Character.toUpperCase(letra);
        }
    }
    
    /**
     * Convierte el Semestre a una Strring con el formato
     * IIII - FFFF L
     * Donde:
     * IIII son el año de inicio
     * FFFFF son el año de fin
     * L es la letra
     * @return la String correspondiente al semestre
     */
    @Override
    public String toString() {
        return "" + inicio + " - " + fin + " " + letra;
    }
    
    /**
     * Calcula el semestre en curso con base en la fecha actual, lo devuelve
     * como objeto.
     * @return El semestre en curso
     */
    public static Semestre calcularActual(){
        Semestre semestre;
        LocalDateTime actual = LocalDateTime.now();
        LocalDateTime febrero;
        LocalDateTime agosto;
        febrero = LocalDateTime.of(actual.getYear(), Month.FEBRUARY, 1, 1, 1);
        agosto = LocalDateTime.of(actual.getYear(), Month.AUGUST, 1, 1, 1);
        
        if (actual.isBefore(febrero)){
            semestre = new Semestre(actual.getYear() - 1, actual.getYear(), 'B');
        }else if (actual.isBefore(agosto)){
            semestre = new Semestre(actual.getYear(), actual.getYear() + 1, 'A');
        }else{
            semestre = new Semestre(actual.getYear(), actual.getYear() + 1, 'B');
        }
        return semestre;
    }
    
    /**
     * Calcula el siguiente semestre con base en la fecha actual, lo devuelve
     * como objeto.
     * @return El siguiete semestre
     */
    public static Semestre calcularSiguiente(){
        Semestre semestre = calcularActual();
        if (semestre.getLetra() == 'A'){
            semestre.setLetra('B');
        }else{
            semestre.setInicio(semestre.getInicio() + 1);
            semestre.setFin(semestre.getFin() + 1);
            semestre.setLetra('A');
        }
        return semestre;
    }
    
    /**
     * Calcula el semestre anterior con base en la fecha actual, lo devuelve
     * como objeto.
     * @return El semestre anterior
     */
    public static Semestre calcularAnterior(){
        Semestre semestre = calcularActual();
        if (semestre.getLetra() == 'B'){
            semestre.setLetra('A');
        }else{
            semestre.setInicio(semestre.getInicio() - 1);
            semestre.setFin(semestre.getFin() - 1);
            semestre.setLetra('B');
        }
        return semestre;
    }
    
    /**
     * Calcula el siguiente semestre del pasado por parámetro, lo devuelve
     * como objeto.
     * @param s el semestre del que se quiere calcular el siguiente
     * @return El siguiete semestre
     */
    public static Semestre calcularSiguiente(Semestre s){
        Semestre semestre = s;
        if (semestre.getLetra() == 'A'){
            semestre.setLetra('B');
        }else{
            semestre.setInicio(semestre.getInicio() + 1);
            semestre.setFin(semestre.getFin() + 1);
            semestre.setLetra('A');
        }
        return semestre;
    }
    
    /**
     * Calcula el semestre anterior del pasado por parámetro, lo devuelve
     * como objeto.
     * @param s el semestre del que se quiere calcular el anterior
     * @return El semestre anterior
     */
    public static Semestre calcularAnterior(Semestre s){
        Semestre semestre = s;
        if (semestre.getLetra() == 'B'){
            semestre.setLetra('A');
        }else{
            semestre.setInicio(semestre.getInicio() - 1);
            semestre.setFin(semestre.getFin() - 1);
            semestre.setLetra('B');
        }
        return semestre;
    }
}
