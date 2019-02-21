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
import com.tedu.entity.Country;
import com.tedu.mapper.CountryMapper;
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
public class CountryService {

    public Long selectCountryCount(){
        SqlSessionFactory sessionFactory = MybatisSessionConfig.getSqlSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        try {
            SqlTable table =SqlTable.of("country");
            SqlColumn code = SqlColumn.of("code",table);
            Count count =Count.of(code);
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

    public List<Country> selectAllCountry(){
        SqlSessionFactory sessionFactory = MybatisSessionConfig.getSqlSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        try {
            SqlTable table =SqlTable.of("country");
            SqlColumn col1 = SqlColumn.of("code",table);
            SqlColumn col2 = SqlColumn.of("name",table);
            SqlColumn col3 = SqlColumn.of("continent",table);
            SqlColumn col4 = SqlColumn.of("region",table);
            SqlColumn col5 = SqlColumn.of("surfacearea",table);
            SqlColumn col6 = SqlColumn.of("indepyear",table);
            SqlColumn col7 = SqlColumn.of("population",table);
            SqlColumn col8 = SqlColumn.of("lifeexpectancy",table);
            SqlColumn col9 = SqlColumn.of("gnp",table);
            SqlColumn col10 = SqlColumn.of("gnpold",table);
            SqlColumn col11 = SqlColumn.of("localname",table);
            SqlColumn col12 = SqlColumn.of("governmentform",table);
            SqlColumn col13 = SqlColumn.of("headofstate",table);
            SqlColumn col14 = SqlColumn.of("capital",table);
            SqlColumn col15 = SqlColumn.of("code2",table);
            SelectStatementProvider selectStatement =select(col1,col2,col3,col4,col5
                     ,col6,col7,col8,col9,col10
                     ,col11,col12,col13,col14,col15)
                    .from(table)
                    .build()
                    .render(RenderingStrategy.MYBATIS3);
            List<Country> countries = mapper.selectMany(selectStatement);
            return countries;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }



}
