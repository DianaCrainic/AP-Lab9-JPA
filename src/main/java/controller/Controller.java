package controller;

import db.Database;
import java.sql.Connection;

/**
 * Controller class:
 * - responsible for connection to DB
 */
public class Controller {
    private Connection connection = Database.getConnection();

    public Connection getConnection(){
        if(connection == null){
            connection = Database.getInstance().getConnection();
        }
        return connection;
    }
}
