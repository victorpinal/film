package es.vmpr.film;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.filechooser.FileSystemView;

public class DataForm {
    
    private HashMap<String, String> map = new HashMap<String,String>(); //local path maps "devicename -> deviceletter"
    private String query;
    private boolean showOnlyMRU;       
    private boolean showAll;
    private boolean showPend;
    private boolean showDupl;
    private String dirSelected;
    
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public boolean isShowOnlyMRU() {
        return showOnlyMRU;
    }
    public void setShowOnlyMRU(boolean showOnlyMRU) {
        this.showOnlyMRU = showOnlyMRU;
    }
    public boolean isShowAll() {
        return showAll;
    }
    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }
    public boolean isShowPend() {
        return showPend;
    }
    public void setShowPend(boolean showPend) {
        this.showPend = showPend;
    }
    public boolean isShowDupl() {
        return showDupl;
    }
    public void setShowDupl(boolean showDupl) {
        this.showDupl = showDupl;
    }
    public String getDirSelected() {
        return dirSelected;
    }
    public void setDirSelected(String dirSelected) {
        this.dirSelected = dirSelected;
    }    
    
    public DataForm() {
        
        for (File root : File.listRoots()) { //load local devices map                
            map.put(Pattern.compile("\\s\\(.+\\)").matcher(FileSystemView.getFileSystemView().getSystemDisplayName(root)).replaceAll(""), root.getPath());
        }
        
    }       
    

    /**
     * Last used paths from db filtered by local fs
     * @return list of local paths
     */
    public ArrayList<String> getMruList() {
        
        ArrayList<String> mru = new ArrayList<String>();            //db path list        
        String ruta;
                
        try { //load all mru from db
            ResultSet res = MySQL.getInstance().getConnection().createStatement().executeQuery("SELECT DISTINCT ruta FROM `film` WHERE ruta IS NOT NULL;");            
            while (res.next()) {
                ruta = res.getString(1);
                if (!this.showOnlyMRU || map.containsKey(ruta.split("[\\\\/]")[0])) { // insert into mru if path is local
                    mru.add(res.getString(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                              
        return mru;
        
    }
    
    public ArrayList<DataFilm> getFilms() {
        
        ArrayList<DataFilm> films = new ArrayList<DataFilm>();
        
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM vw_film WHERE 1=1");
        if (this.query!="") {
            query.append(String.format(" AND CONCAT(filename ,' ',name,' ',IFNULL(imdb_id,'')) LIKE '%%%s%%'", this.query));
        }
        if (!this.showAll && this.dirSelected!="") {
            query.append(String.format(" AND ruta = '%s'", this.dirSelected.replace("\\", "\\\\")));
        }        
        if (this.showPend) {
            query.append(" AND (LENGTH(imdb_id) = 0 OR imdb_rating IS NULL OR imdb_rating = 0)");
        }
        if (this.showDupl) {
            query.append(" AND duplicados > 1");
        }
        query.append(" ORDER BY imdb_rating DESC, imdb_ratingcount DESC, Id");
        
        try {
            ResultSet res = MySQL.getInstance().getConnection().createStatement().executeQuery(query.toString());            
            while (res.next()) {
                DataFilm film = new DataFilm();
                film.setId(res.getInt(DataFilm.ID));
                film.setFilename(res.getString(DataFilm.FILENAME));
                film.setName(res.getString(DataFilm.NAME));
                film.setRuta(res.getString(DataFilm.RUTA));
                film.setImdb_id(res.getString(DataFilm.IMDB_ID));
                film.setImdb_rating(res.getFloat(DataFilm.IMDB_RATING));
                film.setImdb_ratingcount(res.getInt(DataFilm.IMDB_RATINGCOUNT));
                film.setTotal(res.getInt(DataFilm.TOTAL));
                film.setDuplicados(res.getInt(DataFilm.DUPLICADOS));
                film.setTiene_html(res.getInt(DataFilm.TIENE_HTML));
                film.setTiene_omdb(res.getInt(DataFilm.TIENE_OMDB));    
                films.add(film);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return films;
        
    }

      
}
