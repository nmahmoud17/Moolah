package com.detroitlabs.moolahapp.Services;

import com.detroitlabs.moolahapp.Model.Businesses;
import org.junit.Assert;
import org.junit.Test;


public class YelpServiceTest {

    @Test
    public void testFetchYelpDataShouldReturnErniesMarket() {

        YelpService yelpService = new YelpService();
        Businesses businesses = yelpService.fetchYelpData();

        Assert.assertEquals("Ernie's Market", businesses.getAllYelpData().get(0).getName());

    }
}