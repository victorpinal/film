package es.vmpr.film;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private static final Logger _log = Logger.getLogger(Index.class.getName());
    private static final String CONNECTION_ERROR = "connection_error";
    
    private DataConnection connectionData;  //db connect. data    
    private DataQuery queryData;            //search query & data
    private DataForm formData = new DataForm();              //data to show on form    
    
    public DataConnection getConnectionData() {
        return connectionData;
    }

    public void setConnectionData(DataConnection connectionData) {
        this.connectionData = connectionData;
    }

    public DataQuery getQueryData() {
        return queryData;
    }

    public void setQueryData(DataQuery queryData) {
        this.queryData = queryData;
    }

    public DataForm getFormData() {
        return formData;
    }

    public void setFormData(DataForm formData) {
        this.formData = formData;
    }

    /****************************************/ 
    
    @Override
    public String execute() throws Exception {
        
        _log.entering(this.getClass().getName(), "execute");
        
        if (connectionData != null) { //write preferences if passed as arg
            MySQL.getInstance().saveConnectionString(connectionData);
        }
        
        try { //check db connection
            MySQL.getInstance().getConnection();            
        } catch (Exception e) {
            return CONNECTION_ERROR;
        }
        
        if (queryData != null) { // make searh
            loadFilms();
        }
        
        _log.exiting(this.getClass().getName(), "execute");
        
        return SUCCESS;
    }    
    
    /**
     * load films from db using query data
     */
    private void loadFilms() {
        
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM vw_film WHERE 1=1");
        if (queryData.getQuery()!="") {
            query.append(String.format(" AND CONCAT(filename ,' ',name,' ',IFNULL(imdb_id,'')) LIKE '%%%s%%'", queryData.getQuery()));
        }
        if (!queryData.isTodo() && queryData.getDir()!="") {
            query.append(String.format(" AND ruta = '%s'", queryData.getDir().replace("\\", "\\\\")));
        }        
        if (queryData.isPend()) {
            query.append(" AND (LENGTH(imdb_id) = 0 OR imdb_rating IS NULL OR imdb_rating = 0)");
        }
        if (queryData.isDupl()) {
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
                formData.getFilms().add(film);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
