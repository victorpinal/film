package es.vmpr.film;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

/**
 * Created by victormanuel on 03/12/2015.
 */
public class MySQL {

    private static MySQL instance;
    private static final Logger _log = Logger.getLogger(MySQL.class.getName());
    private static String connectionString = "";
    

    private MySQL() {
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            _log.severe("driver not found");
        }

    }
    
    private String loadConnectionString() {
        
        // Read connection data from preferences
        Preferences pref = Preferences.userNodeForPackage(MySQL.class);
        if (pref.get("servidor", null) == null || pref.get("usuario", null) == null || pref.get("password", null) == null) {
            _log.info("connection data not found");            
        } else {
            connectionString = String.format("jdbc:mysql://%1$s:%2$s/peliculas?user=%3$s&password=%4$s", pref.get("servidor", "localhost"),
                    pref.get("puerto", "3306"), pref.get("usuario", null), pref.get("password", null)).toString();
        }
        
        return connectionString;

    }

    public void saveConnectionString(DataConnection arg) {

        _log.info("saving connection data to preferences");
        Preferences pref = Preferences.userNodeForPackage(MySQL.class);
        pref.put("servidor", arg!=null?arg.getMysqlserver():"");
        pref.put("puerto", arg!=null?arg.getMysqlport():"3306");
        pref.put("usuario", arg!=null?arg.getMysqluser():"");
        pref.put("password", arg!=null?arg.getMysqlpwd():"");

    }
    
    public static MySQL getInstance() {      
        return instance==null?new MySQL():instance;
    }

    public Connection getConnection() throws Exception {

        if (connectionString!= "") {
            return DriverManager.getConnection(connectionString);
        } else {                        
            _log.info("connection data empty");
            if (loadConnectionString() != "") {            
                return getConnection();
            } else {
                throw new Exception("connection data not found");
            }
        }

    }

}
