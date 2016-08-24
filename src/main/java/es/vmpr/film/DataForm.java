package es.vmpr.film;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataForm {
    
    private ArrayList<DataFilm> films = new ArrayList<DataFilm>();

    public ArrayList<String> getMru() {
        
        ArrayList<String> mru = new ArrayList<String>();
        
        try {
            ResultSet res = MySQL.getInstance().getConnection().createStatement().executeQuery("SELECT DISTINCT ruta FROM `film` WHERE ruta IS NOT NULL;");            
            while (res.next()) {
                mru.add(res.getString(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return mru;
        
    }
    
    public ArrayList<DataFilm> getFilms() {
        
        return films;
        
    }

      
}
