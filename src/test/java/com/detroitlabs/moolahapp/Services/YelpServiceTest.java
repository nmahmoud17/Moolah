package com.detroitlabs.moolahapp.Services;

import com.detroitlabs.moolahapp.Model.Businesses;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class YelpServiceTest {

    @Test
    public void testFetchYelpDataShouldReturnErniesMarket() {

        YelpService yelpService = new YelpService();
        Businesses businesses = yelpService.fetchYelpData("detroit");

        Assert.assertEquals("Ernie's Market", businesses.getAllYelpData().get(0).getName());

    }

    @Test
    public void calculateYelpDollarSignValueShouldReturn2() {
        YelpService  yelpService = new YelpService();

        int actualResults= yelpService.calculateYelpDollarSignValue(101.00, 1);
        int expectedResults = 2;

        assertEquals(expectedResults, actualResults);
    }

    @Test
    public void calculateYelpDollarSignValueShouldReturn1() {
        YelpService  yelpService = new YelpService();

        int actualResults= yelpService.calculateYelpDollarSignValue(100.00, 1);
        int expectedResults = 1;

        assertEquals(expectedResults, actualResults);
    }
    @Test
    public void calculateYelpDollarSignValueShouldReturn3() {
        YelpService  yelpService = new YelpService();

        int actualResults= yelpService.calculateYelpDollarSignValue(301.00, 1);
        int expectedResults = 3;

        assertEquals(expectedResults, actualResults);
    }
    @Test
    public void calculateYelpDollarSignValueShouldReturn4() {
        YelpService  yelpService = new YelpService();

        int actualResults= yelpService.calculateYelpDollarSignValue(1000.00, 1);
        int expectedResults = 4;

        assertEquals(expectedResults, actualResults);
    }
    @Test
    public void calculateYelpDollarSignValueShouldReturn1EdgeCase() {
        YelpService  yelpService = new YelpService();

        int actualResults= yelpService.calculateYelpDollarSignValue(1.00, 4);
        int expectedResults = 1;

        assertEquals(expectedResults, actualResults);
    }

}