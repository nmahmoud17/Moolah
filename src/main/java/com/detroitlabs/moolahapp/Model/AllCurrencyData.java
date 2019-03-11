package com.detroitlabs.moolahapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllCurrencyData {

        private Quotes quotes;


        @JsonProperty("quotes")
        public Quotes getQuotes() {
            return quotes;
        }

        @JsonProperty("quotes")
        public void setQuotes(Quotes quotes) {
            this.quotes = quotes;
        }
    }

