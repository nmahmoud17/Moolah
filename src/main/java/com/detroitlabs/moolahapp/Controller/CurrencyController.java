package com.detroitlabs.moolahapp.Controller;


import com.detroitlabs.moolahapp.Model.BusinessInformation;
import com.detroitlabs.moolahapp.Model.Businesses;
import com.detroitlabs.moolahapp.Services.CurrencyService;
import com.detroitlabs.moolahapp.Services.YelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;
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
    public ModelAndView showExchangeRateAndBusinessInfo(@RequestParam("USDollars") Double uSD, @RequestParam("numberOfDays") int numberOfDays,
                                                        @RequestParam("country") String countryCode, @RequestParam("cityAndCountryLocationInfo") String locationInfo) {
        ModelAndView modelAndView = new ModelAndView("listings");
        String moneyExchanged = currencyService.convertCurrencyFromUsd(uSD,countryCode);
        Double dailyExchangedBudget = Double.valueOf(moneyExchanged)/numberOfDays;
        int numOfDollarSigns = yelpService.calculateYelpDollarSignValue(uSD, numberOfDays);
        Businesses businesses = yelpService.fetchYelpData(locationInfo, numOfDollarSigns);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedBudget = decimalFormat.format(dailyExchangedBudget);
        modelAndView.addObject("exchangedValue", moneyExchanged);
        modelAndView.addObject("dailyExchangedBudget", formattedBudget);
        modelAndView.addObject("numOfDays", numberOfDays);
        modelAndView.addObject("location",locationInfo);
        ArrayList<BusinessInformation> businessInformationList = businesses.getAllYelpData();
        modelAndView.addObject("businesses", businessInformationList);

        return modelAndView;
    }

    @RequestMapping("filterListings")
    public ModelAndView showFilteredListing(@RequestParam("locationCity") String searchedCity, @RequestParam("termOptions") String termOption){

        ModelAndView modelAndView = new ModelAndView("listings");
        modelAndView.addObject("exchangedValue", "Listings");
        modelAndView.addObject("dailyExchangedBudget", "Explore a new place!");
        Businesses businesses = yelpService.fetchYelpDataForFilter(searchedCity, termOption);
        ArrayList<BusinessInformation> businessInformationList = businesses.getAllYelpData();
        modelAndView.addObject("businesses", businessInformationList);
        return modelAndView;
    }



}
