package com.detroitlabs.moolahapp.Services;

import com.detroitlabs.moolahapp.Model.Businesses;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class YelpService {


    public Businesses fetchYelpData(String userInputCityAndCountry){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "BEARER iRtbrQng3VXivm-1VrAHkh5DPWQOomj9raedfqWflsFAUlF4SCHE9fUHuwS-8tnegHzLVKsGTRoH49nWsULC2lvSaonzzoOIY6UuBvO4YijJ1xmpHSmbb-_1qX2GXHYx");
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Businesses> responseEntity =
                restTemplate.exchange("https://api.yelp.com/v3/businesses/search?sort_by=rating&location=" + userInputCityAndCountry
                        , HttpMethod.GET, httpEntity, Businesses.class);

        return responseEntity.getBody();

    }
}
