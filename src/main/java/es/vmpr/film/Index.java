package es.vmpr.film;

import java.util.logging.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private static final Logger _log = Logger.getLogger(Index.class.getName());
    private static final String CONNECTION_ERROR = "connection_error";
    
    private DataConnection connectionData;  //db connect. data    
    private DataQuery queryData;            //search query & data
    private String[] folders = {"D:\\Video","C:\\Video"};
    
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

    public String[] getFolders() {
        return folders;
    }

    public void setFolders(String[] folders) {
        this.folders = folders;
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
