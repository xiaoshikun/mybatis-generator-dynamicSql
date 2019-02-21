/**
 * Copyright (C), 2015-2019
 * FileName: MybatisSessionConfig
 * Author:   pact
 * Date:     2019/2/20 12:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.tedu.common;

import com.tedu.mapper.CityMapper;
import com.tedu.mapper.CountryMapper;
import com.tedu.mapper.CountrylanguageMapper;
import examples.joins.JoinMapper;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.stereotype.Component;

/**
 * 〈〉
 * @author pact
 * @create 2019/2/20
 * @since 1.0.0
 */
@Component
public class MybatisSessionConfig {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/world";
    private static final String USER = "root";
    private static final String PASSWD = "root";

    public static SqlSessionFactory getSqlSessionFactory(){
        SqlSessionFactory sessionFactory =null;
        try {
            UnpooledDataSource ds = new UnpooledDataSource(DRIVER,URL,USER,PASSWD);
            Environment environment = new Environment("test",new JdbcTransactionFactory(),ds);
            Configuration configuration = new Configuration(environment);
            configuration.addMapper(CityMapper.class);
            configuration.addMapper(CountryMapper.class);
            configuration.addMapper(CountrylanguageMapper.class);
            configuration.addMapper(JoinMapper.class);
            sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            return sessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
