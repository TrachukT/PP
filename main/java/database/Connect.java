package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public Connection connection() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/MainTermProject";
        String username = "postgres";
        String password = "tania123";
        Connection connection;

        {
            try {
                connection = DriverManager.getConnection(jdbcUrl, username, password);
                //System.out.println("Connected to the server");
            } catch (SQLException e) {
                System.out.println("Can`t connect to the server");
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
