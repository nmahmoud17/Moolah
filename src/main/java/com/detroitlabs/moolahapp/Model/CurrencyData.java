package com.detroitlabs.moolahapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyData {

    private double USDAED;


    public double exchangeUSDollars(double USDollars){
        return USDollars * getUSDAED();
    }

    @JsonProperty("USDAED")
    public double getUSDAED() {
        return USDAED;
    }

    @JsonProperty("USDAED")
    public void setUSDAED(double USDAED) {
        this.USDAED = USDAED;
    }

}
