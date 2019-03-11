package com.detroitlabs.moolahapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotes {

    private double USDEUR;
    private double USDAUD;
    private double USDCNY;
    private double USDCAD;
    private double USDBRL;


    @JsonProperty("USDEUR")
    public double getUSDEUR() {
        return USDEUR;
    }

    @JsonProperty("USDEUR")
    public void setUSDEUR(double USDEUR) {
        this.USDEUR = USDEUR;
    }
    @JsonProperty("USDAUD")
    public double getUSDAUD() {
        return USDAUD;
    }
    @JsonProperty("USDAUD")
    public void setUSDAUD(double USDAUD) {
        this.USDAUD = USDAUD;
    }
    @JsonProperty("USDCNY")
    public double getUSDCNY() {
        return USDCNY;
    }
    @JsonProperty("USDCNY")
    public void setUSDCNY(double USDCNY) {
        this.USDCNY = USDCNY;
    }
    @JsonProperty("USDCAD")
    public double getUSDCAD() {
        return USDCAD;
    }
    @JsonProperty("USDCAD")
    public void setUSDCAD(double USDCAD) {
        this.USDCAD = USDCAD;
    }
    @JsonProperty("USDBRL")
    public double getUSDBRL() {
        return USDBRL;
    }
    @JsonProperty("USDBRL")
    public void setUSDBRL(double USDBRL) {
        this.USDBRL = USDBRL;
    }
}
