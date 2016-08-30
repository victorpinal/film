package es.vmpr.film;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class InfoAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private static final Logger _log = Logger.getLogger(IndexAction.class.getName());
    private static final String OMDB = "omdb";
    
    private int id;
    private String omdb;
    
    public void setId(int id) {
        this.id = id;
    }
    public String getOmdb() {
        return omdb;
    }
    
    @Override
    public String execute() throws Exception {
        
        _log.entering(this.getClass().getName(), "execute");
        
        try {
            PreparedStatement st = MySQL.getInstance().getConnection().prepareStatement("SELECT omdb FROM film WHERE id=? AND omdb IS NOT NULL");
            st.setInt(1, id);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                omdb = res.getString(OMDB);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        _log.exiting(this.getClass().getName(), "execute");
        
        return SUCCESS;
    }
    
}
