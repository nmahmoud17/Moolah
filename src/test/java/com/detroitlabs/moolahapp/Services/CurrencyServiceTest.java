package com.detroitlabs.moolahapp.Services;

import com.detroitlabs.moolahapp.Model.AllCurrencyData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class CurrencyServiceTest {


    @Test
    public void testCurrencyLayerAPIResponseShouldBe200(){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AllCurrencyData> results = restTemplate.getForEntity("http://www.apilayer.net/"+
                "api/live?"+
                "access_key=b679b47cee24c4f4863af866d04e9108", AllCurrencyData.class);
        Assert.assertEquals(200, results.getStatusCodeValue());

    }


    @Test
    public void convertCurrencyFromUsd() {
        CurrencyService currencyService = new CurrencyService();
       Double actualResult = currencyService.convertCurrencyFromUsd(1.0, "USDCAD");
       Double expectedResult = 1.332201;
      assertEquals(expectedResult,actualResult);

    }
}