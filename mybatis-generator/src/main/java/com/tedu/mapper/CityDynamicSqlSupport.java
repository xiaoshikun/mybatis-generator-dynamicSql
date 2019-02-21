package com.tedu.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class CityDynamicSqlSupport {
    public static final City city = new City();
    public static final SqlColumn<Integer> id = city.id;
    public static final SqlColumn<String> name = city.name;
    public static final SqlColumn<String> countrycode = city.countrycode;
    public static final SqlColumn<String> district = city.district;
    public static final SqlColumn<Integer> population = city.population;
    public static final class City extends SqlTable {
        public final SqlColumn<Integer> id = column("ID", JDBCType.INTEGER);
        public final SqlColumn<String> name = column("Name", JDBCType.CHAR);
        public final SqlColumn<String> countrycode = column("CountryCode", JDBCType.CHAR);
        public final SqlColumn<String> district = column("District", JDBCType.CHAR);
        public final SqlColumn<Integer> population = column("Population", JDBCType.INTEGER);
        public City() {
            super("city");
        }
    }
}