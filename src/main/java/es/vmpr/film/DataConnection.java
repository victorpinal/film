package es.vmpr.film;

public class DataConnection {

    private String mysqlserver = "localhost";
    private String mysqlport = "3306";
    private String mysqluser;
    private String mysqlpwd;
    
    public String getMysqlserver() {
        return mysqlserver;
    }
    public void setMysqlserver(String mysqlserver) {
        this.mysqlserver = mysqlserver;
    }
    public String getMysqlport() {
        return mysqlport;
    }
    public void setMysqlport(String mysqlport) {
        this.mysqlport = mysqlport;
    }
    public String getMysqluser() {
        return mysqluser;
    }
    public void setMysqluser(String mysqluser) {
        this.mysqluser = mysqluser;
    }
    public String getMysqlpwd() {
        return mysqlpwd;
    }
    public void setMysqlpwd(String mysqlpwd) {
        this.mysqlpwd = mysqlpwd;        
    }       
    
}
