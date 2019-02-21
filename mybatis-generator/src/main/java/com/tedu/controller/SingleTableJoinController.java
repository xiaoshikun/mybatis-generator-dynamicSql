/**
 * Copyright (C), 2015-2019
 * FileName: SingleTableJoin
 * Author:   pact
 * Date:     2019/2/21 16:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.tedu.controller;

import com.tedu.entity.Country;
import com.tedu.service.SingleTableJoinService;
import examples.joins.OrderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈〉
 *
 * @author pact
 * @create 2019/2/21
 * @since 1.0.0
 */
@RestController
@EnableAutoConfiguration
public class SingleTableJoinController {
    @Autowired
    private SingleTableJoinService singleTableJoin;

    @RequestMapping(value = "/singleTableJoin")
    public List<OrderMaster> singleTableJoin(){
        return singleTableJoin.singleTableJoin();
    }
    @RequestMapping(value = "/countryCity")
    public List<Country> selectCountryCityMany(){
        return singleTableJoin.selectCountryCityMany();
    }

}
