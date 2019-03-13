package com.detroitlabs.moolahapp.Controller;

import com.detroitlabs.moolahapp.Model.AllCurrencyData;
import com.detroitlabs.moolahapp.Model.BusinessInformation;
import com.detroitlabs.moolahapp.Model.Businesses;
import com.detroitlabs.moolahapp.Services.CurrencyService;
import com.detroitlabs.moolahapp.Services.YelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
        AllCurrencyData allCurrencyData = currencyService.fetchCurrencyInfo();
        Double usdToAud = allCurrencyData.getQuotes().getUSDAUD();
        modelAndView.addObject("currency"
                , usdToAud);
        Businesses businesses = yelpService.fetchYelpData();
        ArrayList<BusinessInformation> businessInformationList = businesses.getAllYelpData();
        modelAndView.addObject("businesses", businessInformationList);

        return modelAndView;
    }

    @RequestMapping("countryAndCurrency")
    public ModelAndView showExchangeRateAndBusinessInfo(@RequestParam("USDollars") Double uSD, @RequestParam("country") String countryCode) {
        ModelAndView modelAndView = new ModelAndView("home");
        AllCurrencyData allCurrencyData = currencyService.fetchCurrencyInfo();

        System.out.println(countryCode);
        if(countryCode.equalsIgnoreCase("USDAUD")){
            Double usdToAud = uSD * allCurrencyData.getQuotes().getUSDAUD();

            modelAndView.addObject("currency", usdToAud);
        }
        return modelAndView;
    }


}
