package com.detroitlabs.moolahapp.Services;

import com.detroitlabs.moolahapp.Model.Businesses;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class YelpService {


    public Businesses fetchYelpData(String userInputCityAndCountry, int numberOfDollarSigns){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "BEARER iRtbrQng3VXivm-1VrAHkh5DPWQOomj9raedfqWflsFAUlF4SCHE9fUHuwS-8tnegHzLVKsGTRoH49nWsULC2lvSaonzzoOIY6UuBvO4YijJ1xmpHSmbb-_1qX2GXHYx");
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Businesses> responseEntity =
                restTemplate.exchange("https://api.yelp.com/v3/businesses/search?sort_by=rating&location=" + userInputCityAndCountry + "&price=" + numberOfDollarSigns
                        , HttpMethod.GET, httpEntity, Businesses.class);

        return responseEntity.getBody();

    }

    public Businesses fetchYelpDataForFilter(String userInputCityAndCountry, String term){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "BEARER iRtbrQng3VXivm-1VrAHkh5DPWQOomj9raedfqWflsFAUlF4SCHE9fUHuwS-8tnegHzLVKsGTRoH49nWsULC2lvSaonzzoOIY6UuBvO4YijJ1xmpHSmbb-_1qX2GXHYx");
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Businesses> responseEntity =
                restTemplate.exchange("https://api.yelp.com/v3/businesses/search?sort_by=rating&location=" + userInputCityAndCountry + "&term=" + term
                        , HttpMethod.GET, httpEntity, Businesses.class);

        return responseEntity.getBody();

    }


    public int calculateYelpDollarSignValue(Double usdAmount, int numberOfDays){
        int numberOfDollarSigns;
        int dailyAmount = (int) (usdAmount/numberOfDays);
        if(dailyAmount <= 100){
            numberOfDollarSigns = 1;
        } else if(dailyAmount >= 101 && dailyAmount <= 300){
            numberOfDollarSigns = 2;
        } else if(dailyAmount >= 301 && dailyAmount <= 800){
            numberOfDollarSigns = 3;
        } else {
            numberOfDollarSigns = 4;
        }


        return numberOfDollarSigns;

    }
}
