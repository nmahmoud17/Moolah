package com.detroitlabs.moolahapp.Services;

import com.detroitlabs.moolahapp.Model.Businesses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class YelpService {

    @Value("yelpToken")
    String yelpAPIKey;

    public Businesses fetchYelpData(){
    Businesses b = new Businesses();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",  yelpAPIKey);

        return b;
    }
}
