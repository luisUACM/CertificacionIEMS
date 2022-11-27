package com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Estudiante;
import java.util.List;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Luis Alberto
 */
public class CalculadoraDatasets {

    /**
     * Esta matriz se usa para almacenar contadores de cuantas materias 
     * cubiertas tienen los estudiantes. Cada fila es un número dado de 
     * materias cubiertas, empezando por 28, de manera que la última fila 
     * indica el contador de estudiantes con 37 materias cubiertas.
     * Cada columna se usa para un turno, de manera que la primera es matutino,
     * la segunda es vespertino y la tercera es sin turno
     */
    private static int[][] materiasCubiertas = new int[10][3];
    
    /**
     * Genera el data set para la gráfica de candidatos de pastel
     * @param lista la lista de estudiantes sobre la cual se calculará los datos
     * @return el set de datos para la gráfica
     */
    public static PieDataset generarDatasetCandidatosPastel(
        List<Estudiante> lista){
        DefaultPieDataset data = new DefaultPieDataset();
        int matutino = 0;
        int vespertino = 0;
        int semiEscolar = 0;
        
        for (Estudiante e: lista){
            switch (e.getTurno()) {
                case 'M' -> matutino++;
                case 'V' -> vespertino++;
                case ' ' -> semiEscolar++;
                default -> {}
            }
        }
        
        data.setValue("Matutino", matutino);
        data.setValue("Vespertino", vespertino);
        data.setValue("Independiente", semiEscolar);
        
        return data;
    }
    
    /**
    * Genera el data set para la gráfica de materias de pastel
    * @param lista la lista de estudiantes sobre la cual se calcularán los datos
    * @return el set de datos para la gráfica
    */
    public static PieDataset generarDatasetMateriasPastel(
            List<Estudiante> lista){
        DefaultPieDataset data = new DefaultPieDataset();
        
        contarMaterias(lista);
        
        data.setValue("28", materiasCubiertas[0][0] + materiasCubiertas[0][1]
                + materiasCubiertas[0][2]);
        data.setValue("29", materiasCubiertas[1][0] + materiasCubiertas[1][1]
                + materiasCubiertas[1][2]);
        data.setValue("30", materiasCubiertas[2][0] + materiasCubiertas[2][1]
                + materiasCubiertas[2][2]);
        data.setValue("31", materiasCubiertas[3][0] + materiasCubiertas[3][1]
                + materiasCubiertas[3][2]);
        data.setValue("32", materiasCubiertas[4][0] + materiasCubiertas[4][1]
                + materiasCubiertas[4][2]);
        data.setValue("33", materiasCubiertas[5][0] + materiasCubiertas[5][1]
                + materiasCubiertas[5][2]);
        data.setValue("34", materiasCubiertas[6][0] + materiasCubiertas[6][1]
                + materiasCubiertas[6][2]);
        data.setValue("35", materiasCubiertas[7][0] + materiasCubiertas[7][1]
                + materiasCubiertas[7][2]);
        data.setValue("36", materiasCubiertas[8][0] + materiasCubiertas[8][1]
                + materiasCubiertas[8][2]);
        data.setValue("37", materiasCubiertas[9][0] + materiasCubiertas[9][1]
                + materiasCubiertas[9][2]);
        
        return data;
    }
    
    /**
    * Genera el data set para la gráfica de materias de barras
    * @param lista la lista de estudiantes sobre la cual se calcularán los datos
    * @return el set de datos para la gráfica
    */
    public static CategoryDataset generarDatasetMateriasBarras(
            List<Estudiante> lista){
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        String matutino = "Matutino";
        String vespertino = "Vespertino";
        String sinTurno = "Independiente";
        
        contarMaterias(lista);
        data.addValue(materiasCubiertas[0][0], matutino, "28");
        data.addValue(materiasCubiertas[1][0], matutino, "29");
        data.addValue(materiasCubiertas[2][0], matutino, "30");
        data.addValue(materiasCubiertas[3][0], matutino, "31");
        data.addValue(materiasCubiertas[4][0], matutino, "32");
        data.addValue(materiasCubiertas[5][0], matutino, "33");
        data.addValue(materiasCubiertas[6][0], matutino, "34");
        data.addValue(materiasCubiertas[7][0], matutino, "35");
        data.addValue(materiasCubiertas[8][0], matutino, "36");
        data.addValue(materiasCubiertas[9][0], matutino, "37");
        
        data.addValue(materiasCubiertas[0][1], vespertino, "28");
        data.addValue(materiasCubiertas[1][1], vespertino, "29");
        data.addValue(materiasCubiertas[2][1], vespertino, "30");
        data.addValue(materiasCubiertas[3][1], vespertino, "31");
        data.addValue(materiasCubiertas[4][1], vespertino, "32");
        data.addValue(materiasCubiertas[5][1], vespertino, "33");
        data.addValue(materiasCubiertas[6][1], vespertino, "34");
        data.addValue(materiasCubiertas[7][1], vespertino, "35");
        data.addValue(materiasCubiertas[8][1], vespertino, "36");
        data.addValue(materiasCubiertas[9][1], vespertino, "37");
        
        data.addValue(materiasCubiertas[0][2], sinTurno, "28");
        data.addValue(materiasCubiertas[1][2], sinTurno, "29");
        data.addValue(materiasCubiertas[2][2], sinTurno, "30");
        data.addValue(materiasCubiertas[3][2], sinTurno, "31");
        data.addValue(materiasCubiertas[4][2], sinTurno, "32");
        data.addValue(materiasCubiertas[5][2], sinTurno, "33");
        data.addValue(materiasCubiertas[6][2], sinTurno, "34");
        data.addValue(materiasCubiertas[7][2], sinTurno, "35");
        data.addValue(materiasCubiertas[8][2], sinTurno, "36");
        data.addValue(materiasCubiertas[9][2], sinTurno, "37");

        return data;
    }
    
    /**
    * Llena la matriz contarMaterias como se especificó en el atributo
    * @param lista la fuente de la información con la que se llenará la matriz
    */
    private static void contarMaterias(List<Estudiante> lista){
        materiasCubiertas = new int[10][3];
        for (Estudiante e: lista){
            switch (e.getTurno()) {
                case 'M':
                    switch (e.getCubiertas()) {
                        case 28 -> materiasCubiertas[0][0]++;
                        case 29 -> materiasCubiertas[1][0]++;
                        case 30 -> materiasCubiertas[2][0]++;
                        case 31 -> materiasCubiertas[3][0]++;
                        case 32 -> materiasCubiertas[4][0]++;
                        case 33 -> materiasCubiertas[5][0]++;
                        case 34 -> materiasCubiertas[6][0]++;
                        case 35 -> materiasCubiertas[7][0]++;
                        case 36 -> materiasCubiertas[8][0]++;
                        case 37 -> materiasCubiertas[9][0]++;
                        default -> {}
                    }   
                    break;
                    
                case 'V':
                    switch (e.getCubiertas()) {
                        case 28 -> materiasCubiertas[0][1]++;
                        case 29 -> materiasCubiertas[1][1]++;
                        case 30 -> materiasCubiertas[2][1]++;
                        case 31 -> materiasCubiertas[3][1]++;
                        case 32 -> materiasCubiertas[4][1]++;
                        case 33 -> materiasCubiertas[5][1]++;
                        case 34 -> materiasCubiertas[6][1]++;
                        case 35 -> materiasCubiertas[7][1]++;
                        case 36 -> materiasCubiertas[8][1]++;
                        case 37 -> materiasCubiertas[9][1]++;
                        default -> {}
                    }   
                    break;
                    
                case ' ':
                    switch (e.getCubiertas()) {
                        case 28 -> materiasCubiertas[0][2]++;
                        case 29 -> materiasCubiertas[1][2]++;
                        case 30 -> materiasCubiertas[2][2]++;
                        case 31 -> materiasCubiertas[3][2]++;
                        case 32 -> materiasCubiertas[4][2]++;
                        case 33 -> materiasCubiertas[5][2]++;
                        case 34 -> materiasCubiertas[6][2]++;
                        case 35 -> materiasCubiertas[7][2]++;
                        case 36 -> materiasCubiertas[8][2]++;
                        case 37 -> materiasCubiertas[9][2]++;
                        default -> {}
                    }   
                    break;
                    
                default: 
                    break;
            }
        }
    }
}
