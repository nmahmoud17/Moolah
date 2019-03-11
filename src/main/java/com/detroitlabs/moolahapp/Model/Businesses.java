package com.detroitlabs.moolahapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Businesses {

    @JsonProperty("businesses")
    private ArrayList<BusinessInformation> allYelpData = new ArrayList<>();

    public ArrayList<BusinessInformation> getAllYelpData() {
        return allYelpData;
    }

    public void setAllYelpData(ArrayList<BusinessInformation> allYelpData) {
        this.allYelpData = allYelpData;
    }
}
