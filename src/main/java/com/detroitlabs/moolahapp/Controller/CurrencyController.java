package com.detroitlabs.moolahapp.Controller;

import com.detroitlabs.moolahapp.Model.AllCurrencyData;
import com.detroitlabs.moolahapp.Model.BusinessInformation;
import com.detroitlabs.moolahapp.Model.Businesses;
import com.detroitlabs.moolahapp.Services.CurrencyService;
import com.detroitlabs.moolahapp.Services.YelpService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @Autowired
    YelpService yelpService;

    @RequestMapping("/")
    public ModelAndView showCurrencyInformation() {
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    @RequestMapping("countryAndCurrency")
    public ModelAndView showExchangeRateAndBusinessInfo(@RequestParam("USDollars") Double uSD,@RequestParam("numberOfDays") int numberOfDays
            , @RequestParam("country") String countryCode, @RequestParam("cityAndCountryLocationInfo") String locationInfo) {
        ModelAndView modelAndView = new ModelAndView("listings");

        Double moneyExchanged = currencyService.convertCurrencyFromUsd(uSD,countryCode);
        modelAndView.addObject("exchangedValue", moneyExchanged);
        modelAndView.addObject("numOfDays", numberOfDays);
        modelAndView.addObject("location",locationInfo);

       int numOfDollarSigns = yelpService.calculateYelpDollarSignValue(uSD, numberOfDays);

        Businesses businesses = yelpService.fetchYelpData(locationInfo, numOfDollarSigns);
        ArrayList<BusinessInformation> businessInformationList = businesses.getAllYelpData();
        modelAndView.addObject("businesses", businessInformationList);

        return modelAndView;
    }

    @RequestMapping("filterListings")
    public ModelAndView showFilteredListing(@RequestParam("locationCity") String searchedCity, @RequestParam("termOptions") String termOption){

        ModelAndView modelAndView = new ModelAndView("listings");
        modelAndView.addObject("exchangedValue", "Listings");
        Businesses businesses = yelpService.fetchYelpDataForFilter(searchedCity, termOption);
        ArrayList<BusinessInformation> businessInformationList = businesses.getAllYelpData();
        modelAndView.addObject("businesses", businessInformationList);
        return modelAndView;
    }



}
