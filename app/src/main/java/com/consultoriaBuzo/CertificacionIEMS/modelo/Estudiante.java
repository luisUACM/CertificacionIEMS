package com.consultoriaBuzo.CertificacionIEMS.modelo;

/**
 *
 * @author Luis Alberto
 */
public class Estudiante {
    
    private String matricula;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private char modalidad;
    private char turno;
    private int cubiertas;
    private int reinscritas;
    private int cubiertasFinal;
    private Semestre semestre;
    private boolean activo;

    /**
     * Crea un estudiante vacío. Con los siguietes valores:
     * matricula = "";
     * nombre = "";
     * apellidoP = "";
     * apellidoM = "";
     * modalidad = ' ';
     * turno = ' ';
     * cubiertas = -1;
     * reinscritas = -1;
     * cubiertasFinal = -1;
     * semestre = null;
     * activo = false;
     */
    public Estudiante() {
        matricula = "";
        nombre = "";
        apellidoP = "";
        apellidoM = "";
        modalidad = ' ';
        turno = ' ';
        cubiertas = -1;
        reinscritas = -1;
        cubiertasFinal = -1;
        semestre = null;
        activo = false;
    }
    
    /**
     * Obtiene la matrícula del estudiante
     * @return la matrícula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del estudiante
     * @param matricula la matrícula a establecer
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    /**
     * Obtiene el nombre del estudiante
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del estudiante
     * @return el apellido paterno
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * Establece el apellido paterno del estudiante
     * @param apellidoP el apellido a establecer
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * Obtiene el apellido materno del estudiante
     * @return el apellido materno
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * Establece el apellido materno del estudiante
     * @param apellidoM el apellido a establecer
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * Obtiene la modalidad del estudiante
     * @return 'E' para escolar o 'S' para semiescolar
     */
    public char getModalidad() {
        return modalidad;
    }

    /**
     * Establece la modalidad.Los únicos valores vállidos son:
     * 'E' o 'e' para escolar 
     * 'S' o 's' para semiescolar
     * @param modalidad la modalidad a establecer
     */
    public void setModalidad(char modalidad) {
        if (modalidad == 'E' || modalidad == 'S'){
            this.modalidad = modalidad;
        }else if (modalidad == 'e' || modalidad == 's'){
            this.modalidad = Character.toUpperCase(modalidad);
        }
    }
    
    /**
     * Obtiene el turno del estudiante
     * @return 'M' para matutino, 'V' para vespertino o ' ' para semi-escolar.
     */
    public char getTurno() {
        return turno;
    }

    /**
    * Establece el turno. Los únicos caracteres válidos son:
    * 'M' para matutino
    * 'V' para vespertino
    * ' ' para semi-escolar.
    * 'm' y 'v' son transformados a mayúsculas.
    * @param turno la academia a establecer.
    */
    public void setTurno(char turno) {
        if (turno == ' ' || turno == 'M' || turno == 'V'){
            this.turno = turno;
        }else if (turno == 'm' || turno == 'b'){
            this.turno = Character.toUpperCase(turno);
        }
    }

    /**
     * Obtiene el número de asignaturas cubiertas del estudiante
     * @return las asignaturas cubiertas del estudiante
     */
    public int getCubiertas() {
        return cubiertas;
    }

    /**
     * Establece el número de asignaturas cubiertas del estudiante
     * @param cubiertas el número a establecer
     */
    public void setCubiertas(int cubiertas) {
        this.cubiertas = cubiertas;
    }

    /**
     * Obtiene el número de asignaturas reinscritas del estudiante
     * @return las asignaturas reinscritas del estudiante
     */
    public int getReinscritas() {
        return reinscritas;
    }

    /**
     * Establece el número de asignaturas reinscritas del estudiante
     * @param reinscritas el número a establecer
     */
    public void setReinscritas(int reinscritas) {
        this.reinscritas = reinscritas;
    }

    /**
     * Obtiene el número de asignaturas cubiertas al final del semestre del 
     * estudiante
     * @return las asignaturas cubiertas al final del semestre del estudiante
     */
    public int getCubiertasFinal() {
        return cubiertasFinal;
    }

    /**
     * Establece el número de asignaturas cubiertas al final del semestre del 
     * estudiante
     * @param cubiertasFinal el número a establecer
     */
    public void setCubiertasFinal(int cubiertasFinal) {
        this.cubiertasFinal = cubiertasFinal;
    }

    /**
     * Obtiene último semestre de reinscripción del estudiante
     * @return el semestre
     */
    public Semestre getSemestre() {
        return semestre;
    }

    /**
     * Establece el último semestre de reinscrición del estudiante
     * @param semestre el semestre a establecer
     */
    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    /**
     * Indica si el estudiante es activo
     * @return el estado de activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece el atributo de activo del estudiante
     * @param activo el valor a establecer
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Método toSting generado automáticamente
     */
    @Override
    public String toString() {
        return "Estudiante{" + "matricula=" + matricula + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", modalidad=" + modalidad + ", turno=" + turno + ", cubiertas=" + cubiertas + ", reinscritas=" + reinscritas + ", cubiertasFinal=" + cubiertasFinal + ", semestre=" + semestre + ", activo=" + activo + '}';
    }
    
    
}
