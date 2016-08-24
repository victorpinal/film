package es.vmpr.film;

import java.awt.Image;
import java.io.InputStream;
import java.util.Date;

public class DataFilm {
    
    public static final String ID = "id";
    public static final String FILENAME = "filename";
    public static final String NAME = "name";
    public static final String RUTA = "ruta";
    public static final String IMDB_ID = "imdb_id";
    public static final String IMDB_RATING = "imdb_rating";
    public static final String IMDB_RATINGCOUNT = "imdb_ratingcount";
    public static final String TOTAL = "total";
    public static final String DUPLICADOS = "duplicados";
    public static final String TIENE_HTML = "tiene_html";
    public static final String TIENE_OMDB = "tiene_omdb";
    
    private int id;
    private String filename;
    private String name;
    private String ruta;
    private String imdb_id;
    private float imdb_rating;
    private int imdb_ratingcount;
    private int total;
    private int duplicados;
    private int tiene_html;
    private int tiene_omdb;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRuta() {
        return ruta;
    }
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    public String getImdb_id() {
        return imdb_id;
    }
    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }
    public float getImdb_rating() {
        return imdb_rating;
    }
    public void setImdb_rating(float imdb_rating) {
        this.imdb_rating = imdb_rating;
    }
    public int getImdb_ratingcount() {
        return imdb_ratingcount;
    }
    public void setImdb_ratingcount(int imdb_ratingcount) {
        this.imdb_ratingcount = imdb_ratingcount;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getDuplicados() {
        return duplicados;
    }
    public void setDuplicados(int duplicados) {
        this.duplicados = duplicados;
    }
    public int getTiene_html() {
        return tiene_html;
    }
    public void setTiene_html(int tiene_html) {
        this.tiene_html = tiene_html;
    }
    public int getTiene_omdb() {
        return tiene_omdb;
    }
    public void setTiene_omdb(int tiene_omdb) {
        this.tiene_omdb = tiene_omdb;
    }
        
}
