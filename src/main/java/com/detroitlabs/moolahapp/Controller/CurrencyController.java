package com.detroitlabs.moolahapp.Controller;

import com.detroitlabs.moolahapp.Model.AllCurrencyData;
import com.detroitlabs.moolahapp.Services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @RequestMapping("/")
    public ModelAndView showCurrencyInformation(){
        ModelAndView modelAndView = new ModelAndView("home");
       AllCurrencyData allCurrencyData = currencyService.fetchCurrencyInfo();
       Double usdToAud= allCurrencyData.getQuotes().getUSDAUD();
       modelAndView.addObject("currency"
               , usdToAud);

        return modelAndView;
    }

}
