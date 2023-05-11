package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConnexion {
    public static Connection Connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/sejours";

            String user ="phpmyadmin";
            String password ="84VNNysXkL9QQI7g";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            return conn ;
        } catch (ClassNotFoundException | SQLException  e) {
            // TODO: handle exception
            Logger.getLogger(dbConnexion.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }

}