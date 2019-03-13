package com.detroitlabs.moolahapp.Services;

import com.detroitlabs.moolahapp.Model.AllCurrencyData;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyService {

    public AllCurrencyData fetchCurrencyInfo(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://www.apilayer.net/"+
                "api/live?"+
                "access_key=b679b47cee24c4f4863af866d04e9108", AllCurrencyData.class);


    }
}
