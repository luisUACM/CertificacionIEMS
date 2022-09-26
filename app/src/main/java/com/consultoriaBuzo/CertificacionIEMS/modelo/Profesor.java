package com.consultoriaBuzo.CertificacionIEMS.modelo;

/**
 *
 * @author Luis Alberto
 */
public class Profesor {
    
    private String nombre;
    private Academia academia;
    private char turno;
    private boolean activo;

    /**
     * Regresa el nombre del profesor
     * @return el nombre del profesor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el atributo del nombre del profesor 
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el valor de la enumeraci�n de Academia del profesor
     * @return la Academia del profesor
     */
    public Academia getAcademia() {
        return academia;
    }

    /**
     * Establece el atributo de academia del profesor 
     * @param academia la academia a establecer
     */
    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    /**
     * Regresa el valor de turno del profesor en forma de caracter:
     * 'M' para matutino
     * 'V' para vespertino
     * ' ' para asesores.
     * @return el turno del profesor
     */
    public char getTurno() {
        return turno;
    }

    /**
    * Establece el atributo de turno del profesor, no se deber�a usar para asesores
    * @param turno la academia a establecer. Los �nicos caracteres v�lidos son:
    * 'M' para matutino
    * 'V' para vespertino
    * ' ' para asesores. 
    * Cualquier otro no ser� tomado en cuenta
    */
    public void setTurno(char turno) {
        if (turno == ' ' || turno == 'M' || turno == 'V'){
            this.turno = turno;
        }
    }

    /**
     * Regresa el estado de activo del profesor como un booleano
     * @return el estado del profesor
     */
    public boolean getActivo() {
        return activo;
    }

    /**
     * Establece el atributo de activo del profesor 
     * @param activo el estado de activo a establecer
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Crea un profesor vac�o con los siguientes valores para los atributos:
     * nombre = ""
     * academia = Academia.NO_VALIDO
     * turno = ' '
     * activo = false
     */
    public Profesor() {
        nombre = "";
        academia = Academia.NO_VALIDO;
        turno = ' ';
        activo = false;
    }

    /**
     * Constructor para asesor, establece los atributos con los valores pasados
     * por par�metro
     * @param nombre el nombre del profesor
     * @param academia la academia y materia que imparte el profesor
     * @param activo el estado de activo del profesor
     */
    public Profesor(String nombre, Academia academia, boolean activo) {
        this.nombre = nombre;
        this.academia = academia;
        this.activo = activo;
    }
    /**
     * Constructor para DTI, establece los atributos con los valores pasados
     * por par�metro
     * @param nombre el nombre del profesor
     * @param academia la academia y materia que imparte el profesor
     * @param turno el turno del profesor
     * @param activo el estado de activo del profesor
     */
    public Profesor(String nombre, Academia academia, char turno, boolean activo) {
        this.nombre = nombre;
        this.academia = academia;
        this.turno = turno;
        this.activo = activo;
    }

    /**
     * Regresa al profesor en forma de String, muestra todos sus atributos.
     * @return una String que contiene los datos del profesor
     */
    @Override
    public String toString() {
        return "" + nombre + academia + ", turno " + turno + ", activo =" + activo;
    }
}
