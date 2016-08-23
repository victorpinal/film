package es.vmpr.film;

public class DataQuery {
    
    private String query;
    private boolean mru = false;
    private boolean todo;
    private boolean pend;
    private boolean dupl;
    private String dir;
    
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public boolean isMru() {
        return mru;
    }
    public void setMru(boolean mru) {
        this.mru = mru;
    }
    public boolean isTodo() {
        return todo;
    }
    public void setTodo(boolean todo) {
        this.todo = todo;
    }
    public boolean isPend() {
        return pend;
    }
    public void setPend(boolean pend) {
        this.pend = pend;
    }
    public boolean isDupl() {
        return dupl;
    }
    public void setDupl(boolean dupl) {
        this.dupl = dupl;
    }
    public String getDir() {
        return dir;
    }
    public void setDir(String dir) {
        this.dir = dir;
    }
    
}
