package dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase auxiliar para inicializar una conexion a la base de datos
 */
public class DBConnector {
    private static final String url = "jdbc:mysql://localhost:3306/companhia";
    private static final String user = "root";
    private static final String passw = "";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, passw);
    }
}
