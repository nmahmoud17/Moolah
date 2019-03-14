package com.detroitlabs.moolahapp.Services;

import com.detroitlabs.moolahapp.Model.AllCurrencyData;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Component
public class CurrencyService {

    public AllCurrencyData fetchCurrencyInfo(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://www.apilayer.net/"+
                "api/live?"+
                "access_key=b679b47cee24c4f4863af866d04e9108", AllCurrencyData.class);


    }


    public Double convertCurrencyFromUsd(Double uSDollars, String countryCode){
        AllCurrencyData allCurrencyData = fetchCurrencyInfo();

        HashMap<String, Double> currencyInfo = new HashMap<>();
        currencyInfo.put("USDAUD", allCurrencyData.getQuotes().getUSDAUD());
        currencyInfo.put("USDEUR", allCurrencyData.getQuotes().getUSDEUR());
        currencyInfo.put("USDBRL", allCurrencyData.getQuotes().getUSDBRL());
        currencyInfo.put("USDCAD", allCurrencyData.getQuotes().getUSDCAD());
        currencyInfo.put("USDCNY", allCurrencyData.getQuotes().getUSDCNY());
            if(currencyInfo.containsKey(countryCode)){
               return uSDollars * currencyInfo.get(countryCode);
            }
        return null;
        }


    }

