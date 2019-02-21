/**
 * Copyright (C), 2015-2019
 * FileName: CityService
 * Author:   pact
 * Date:     2019/2/19 18:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.tedu.service;

import com.tedu.common.MybatisSessionConfig;
import com.tedu.entity.City;
import com.tedu.mapper.CityMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.aggregate.Count;
import org.mybatis.dynamic.sql.select.aggregate.CountAll;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.select.SelectDSL.select;

/**
 * 〈〉
 *
 * @author pact
 * @create 2019/2/19
 * @since 1.0.0
 */
@Service
public class CityService {


    public Long selectCityTotalNum(){
        SqlSessionFactory sessionFactory = MybatisSessionConfig.getSqlSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        CityMapper mapper = sqlSession.getMapper(CityMapper.class);
        try {
            SqlTable table =SqlTable.of("city");
            SqlColumn id = SqlColumn.of("id",table);
            Count count =Count.of(id);
            CountAll countAll = new CountAll();
            SelectStatementProvider selectStatement =select(count)
                    .from(table)
                    .build()
                    .render(RenderingStrategy.MYBATIS3);

            return mapper.count(selectStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }

    public List<City> selectAllCity(){
        SqlSessionFactory sessionFactory = MybatisSessionConfig.getSqlSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        CityMapper mapper = sqlSession.getMapper(CityMapper.class);
        try {
            SqlTable table =SqlTable.of("city");
            SqlColumn col1 = SqlColumn.of("id",table);
            SqlColumn col2 = SqlColumn.of("name",table);
            SqlColumn col3 = SqlColumn.of("countrycode",table);
            SqlColumn col4 = SqlColumn.of("district",table);
            SqlColumn col5 = SqlColumn.of("population",table);
            SelectStatementProvider selectStatement =select(col1,col2,col3,col4,col5)
                    .from(table)
                    .build()
                    .render(RenderingStrategy.MYBATIS3);
            List<City> cities = mapper.selectMany(selectStatement);
            return cities;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }



}
