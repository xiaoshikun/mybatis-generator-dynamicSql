/**
 * Copyright (C), 2015-2019
 * FileName: Example
 * Author:   pact
 * Date:     2019/2/19 17:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.tedu.controller;

import com.tedu.entity.Country;
import com.tedu.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈〉
 *
 * @author pact
 * @create 2019/2/19
 * @since 1.0.0
 */
@RestController
@EnableAutoConfiguration
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/country/count")
    public Long selectCityCount(){
        return countryService.selectCountryCount();
    }

    @RequestMapping(value = "/country/details")
    public List<Country> selectAllCity(){
        return countryService.selectAllCountry();
    }


}
