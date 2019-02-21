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

import com.tedu.entity.City;
import com.tedu.service.CityService;
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
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/city/count")
    public Long selectCityCount(){
        return cityService.selectCityTotalNum();
    }

    @RequestMapping(value = "/city/details")
    public List<City> selectAllCity(){
        return cityService.selectAllCity();
    }


}
