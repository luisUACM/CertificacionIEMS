package com.consultoriaBuzo.CertificacionIEMS.modelo;

/**
 *
 * @author Luis Alberto
 */
public enum Academia {
    /** 
     * Representa alguna situación extraordinaria o que no se ha seleccionado
     * una academia, por lo general debería ser lo segundo
     */
    NO_VALIDO(""),
    /** Representa la academia de la materia de artes*/
    ARTES("artes"),
    /** Representa la academia de la materia de biología*/
    BIOLOGIA("biología"),
    /** Representa la academia de la materia de computación*/
    COMPUTACION("computación"),
    /** Representa la academia de la materia de física*/
    FISICA("física"),
    /** Representa la academia de la materia de filosofía*/
    FILOSOFIA("filosofía"),
    /** Representa la academia de la materia de historia*/
    HISTORIA("historia"),
    /** Representa la academia de la materia de inglés*/
    INGLES("inglés"),
    /** Representa la academia de la materia de lengua y literatura*/
    LENGUA("lengua y literatura"),
    /** Representa la academia de la materia de música*/
    MUSICA("música"),
    /** Representa la academia de la materia de matemáticas*/
    MATEMATICAS("matemáticas"),
    /** Representa la academia de la materia de planeación y organización del estudio*/
    POE("planeación y organización del estudio"),
    /** Representa la academia de la materia de química*/
    QUIMICA("química");
    
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
}
