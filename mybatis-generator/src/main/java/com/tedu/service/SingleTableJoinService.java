/**
 * Copyright (C), 2015-2019
 * FileName: SingleTableJoin
 * Author:   pact
 * Date:     2019/2/21 16:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.tedu.service;

import com.tedu.common.MybatisSessionConfig;
import com.tedu.entity.Country;
import examples.joins.JoinMapper;
import examples.joins.OrderMaster;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tedu.mapper.CityDynamicSqlSupport.city;
import static com.tedu.mapper.CountryDynamicSqlSupport.country;
import static examples.joins.OrderDetailDynamicSQLSupport.orderDetail;
import static examples.joins.OrderMasterDynamicSQLSupport.orderDate;
import static examples.joins.OrderMasterDynamicSQLSupport.orderMaster;
import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * 〈〉
 *
 * @author pact
 * @create 2019/2/21
 * @since 1.0.0
 */
@Service
public class SingleTableJoinService {

    public List<Country> selectCountryCityMany(){
        SqlSessionFactory sqlSessionFactory = MybatisSessionConfig.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            JoinMapper mapper = session.getMapper(JoinMapper.class);
            SelectStatementProvider selectStatement = select(country.code,country.name,city.id,city.countrycode,city.district,city.name,city.population)
                    .from(country, "country")
                    .join(city, "city").on(country.code, equalTo(city.countrycode))
                    .build()
                    .render(RenderingStrategy.MYBATIS3);

            return mapper.selectCountryCityMany(selectStatement);
        }
    }
    public List<OrderMaster> singleTableJoin(){
        SqlSessionFactory sqlSessionFactory = MybatisSessionConfig.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            JoinMapper mapper = session.getMapper(JoinMapper.class);
            SelectStatementProvider selectStatement = select(orderMaster.orderId, orderDate, orderDetail.lineNumber, orderDetail.description, orderDetail.quantity)
                    .from(orderMaster, "om")
                    .join(orderDetail, "od").on(orderMaster.orderId, equalTo(orderDetail.orderId))
                    .build()
                    .render(RenderingStrategy.MYBATIS3);

            List<OrderMaster> rows = mapper.selectMany(selectStatement);
            return rows;
        }
    }
}
