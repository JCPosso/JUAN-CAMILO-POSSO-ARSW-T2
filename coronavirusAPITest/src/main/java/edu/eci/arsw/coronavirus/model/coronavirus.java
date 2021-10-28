package edu.eci.arsw.coronavirus.model;

public class coronavirus {
    private long time;
    private String stringjson;
    public coronavirus(long time, String stringjson) {
        this.stringjson = stringjson;
        this.time = time;
    }
    public long getTime() {
        return time;
    }
    public String getStringJson() {
        return stringjson;
    }
}