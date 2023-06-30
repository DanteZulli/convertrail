package com.zullid.convertrail.csv;

import com.opencsv.bean.CsvBindByPosition;

public class CsvBeans {
@CsvBindByPosition(position = 0)
    private String LatD;
@CsvBindByPosition(position = 1)
    private String LatM;
@CsvBindByPosition(position = 2)
    private String LatS;
@CsvBindByPosition(position = 3)
    private String NS;
@CsvBindByPosition(position = 4)
    private String LonD;
@CsvBindByPosition(position = 5)
    private String LonM;
@CsvBindByPosition(position = 6)
    private String LonS;
@CsvBindByPosition(position = 7)
    private String EW;
@CsvBindByPosition(position = 8)
    private String City;
@CsvBindByPosition(position = 9)
    private String State;

    public String getLatD() {
        return LatD;
    }

    public void setLatD(String LatD) {
        this.LatD = LatD;
    }

    public String getLatM() {
        return LatM;
    }

    public void setLatM(String LatM) {
        this.LatM = LatM;
    }

    public String getLatS() {
        return LatS;
    }

    public void setLatS(String LatS) {
        this.LatS = LatS;
    }

    public String getNS() {
        return NS;
    }

    public void setNS(String NS) {
        this.NS = NS;
    }

    public String getLonD() {
        return LonD;
    }

    public void setLonD(String LonD) {
        this.LonD = LonD;
    }

    public String getLonM() {
        return LonM;
    }

    public void setLonM(String LonM) {
        this.LonM = LonM;
    }

    public String getLonS() {
        return LonS;
    }

    public void setLonS(String LonS) {
        this.LonS = LonS;
    }

    public String getEW() {
        return EW;
    }

    public void setEW(String EW) {
        this.EW = EW;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    @Override
    public String toString() {
        return "CsvBeans [LatD=" + LatD + ", LatM=" + LatM + ", LatS=" + LatS + ", NS=" + NS + ", LonD=" + LonD + ", LonM=" + LonM + ", LonS=" + LonS + ", EW=" + EW + ", City=" + City + ", State=" + State + ", ]";
    }
}