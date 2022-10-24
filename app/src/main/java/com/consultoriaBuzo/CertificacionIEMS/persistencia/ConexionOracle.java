package com.consultoriaBuzo.CertificacionIEMS.persistencia;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Luis Alberto
 */
public class ConexionOracle {
    private final String jdbcUrl;
    private final String userid;
    private final String password;
    private Connection conn;

    /**
     * Constructor que inicializa todos los atributos para que conecten con la
     * base de datos local
     */
    public ConexionOracle() {
        jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        userid = "luis";
        password = "123456";
        conn = null;
    }
    
    /**
     * Conecta con la base de datos y regresa la conexion física 
     * @return la conexión física a la base de datos
     * @throws java.sql.SQLException
     */
    public Connection getConexionOracle() throws SQLException{
        OracleDataSource  ds;
        ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        conn = ds.getConnection(userid,password);
        return conn;
    }
}
