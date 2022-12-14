package com.consultoriaBuzo.CertificacionIEMS.modelo;

import java.util.EnumSet;

/**
 *
 * @author Luis Alberto
 */
public enum Academia {
    /** 
     * Representa alguna situaci?n extraordinaria o que no se ha seleccionado
     * una academia, por lo general deber?a ser lo segundo
     */
    NO_VALIDO(""),
    /** Representa la academia de la materia de artes*/
    ARTES("artes"),
    /** Representa la academia de la materia de biolog?a*/
    BIOLOGIA("biolog?a"),
    /** Representa la academia de la materia de computaci?n*/
    COMPUTACION("computaci?n"),
    /** Representa la academia de la materia de f?sica*/
    FISICA("f?sica"),
    /** Representa la academia de la materia de filosof?a*/
    FILOSOFIA("filosof?a"),
    /** Representa la academia de la materia de historia*/
    HISTORIA("historia"),
    /** Representa la academia de la materia de ingl?s*/
    INGLES("ingl?s"),
    /** Representa la academia de la materia de lengua y literatura*/
    LENGUA("lengua y literatura"),
    /** Representa la academia de la materia de m?sica*/
    MUSICA("m?sica"),
    /** Representa la academia de la materia de matem?ticas*/
    MATEMATICAS("matem?ticas"),
    /** Representa la academia de la materia de planeaci?n y organizaci?n del estudio*/
    POE("planeaci?n y organizaci?n del estudio"),
    /** Representa la academia de la materia de qu?mica*/
    QUIMICA("qu?mica");
    
    private final String name;
    
    Academia(String name){
        this.name = name;
    }
        
    /**Regresa la academia en forma de String
    * @return el nombre de la academia
    */
    @Override
    public String toString(){
        return name;
    }
    
    /**Regresa la constante de tipo Academia que corresponda con la cadena pasada
     * por par?metro, como si fuera una conversi?n String a Academia
     * @return la Academia correspondiente a la cadena pasada por parr?metro,
     * null si no hay conincidencia
     * @param str el nombre de la academia
     */
    public static Academia getAcademia(String str){
            
        for (Academia element : EnumSet.allOf(Academia.class)) {
            if (element.toString().equals(str)) {
                return element;
            }
        }
        return null;
    }
}
