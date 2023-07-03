package com.zullid.convertrail.api.setup;

import java.beans.JavaBean;

@JavaBean
public class Config {

    // Configuración de la API
    private String url;
    private String method;
    private int timer;
    private boolean result;
    private boolean log;

    // Getter y Setters
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public int getTimer() {
        return timer;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }
    public boolean isResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }
    public boolean isLog() {
        return log;
    }
    public void setLog(boolean log) {
        this.log = log;
    }
    @Override
    public String toString() {
        return "Config [url=" + url + ", method=" + method + ", timer=" + timer + ", result=" + result + ", log=" + log
                + "]";
    }

}
