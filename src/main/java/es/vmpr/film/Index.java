package es.vmpr.film;

import java.util.logging.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private static final Logger _log = Logger.getLogger(Index.class.getName());
    private static final String CONNECTION_ERROR = "connection_error";
    
    private DataConnection connectionData;      //db connect. data    
    private DataForm formData = new DataForm(); //data to show on form    
    
    public DataConnection getConnectionData() {
        return connectionData;
    }

    public void setConnectionData(DataConnection connectionData) {
        this.connectionData = connectionData;
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
        
        _log.exiting(this.getClass().getName(), "execute");
        
        return SUCCESS;
    }    
    
}
