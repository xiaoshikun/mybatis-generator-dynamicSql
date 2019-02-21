package com.tedu.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class CountryDynamicSqlSupport {
    public static final Country country = new Country();
    public static final SqlColumn<String> code = country.code;
    public static final SqlColumn<String> name = country.name;
    public static final SqlColumn<String> continent = country.continent;
    public static final SqlColumn<String> region = country.region;
    public static final SqlColumn<Float> surfacearea = country.surfacearea;
    public static final SqlColumn<Short> indepyear = country.indepyear;
    public static final SqlColumn<Integer> population = country.population;
    public static final SqlColumn<Float> lifeexpectancy = country.lifeexpectancy;
    public static final SqlColumn<Float> gnp = country.gnp;
    public static final SqlColumn<Float> gnpold = country.gnpold;
    public static final SqlColumn<String> localname = country.localname;
    public static final SqlColumn<String> governmentform = country.governmentform;
    public static final SqlColumn<String> headofstate = country.headofstate;
    public static final SqlColumn<Integer> capital = country.capital;
    public static final SqlColumn<String> code2 = country.code2;
    public static final class Country extends SqlTable {
        public final SqlColumn<String> code = column("Code", JDBCType.CHAR);
        public final SqlColumn<String> name = column("Name", JDBCType.CHAR);
        public final SqlColumn<String> continent = column("Continent", JDBCType.CHAR);
        public final SqlColumn<String> region = column("Region", JDBCType.CHAR);
        public final SqlColumn<Float> surfacearea = column("SurfaceArea", JDBCType.REAL);
        public final SqlColumn<Short> indepyear = column("IndepYear", JDBCType.SMALLINT);
        public final SqlColumn<Integer> population = column("Population", JDBCType.INTEGER);
        public final SqlColumn<Float> lifeexpectancy = column("LifeExpectancy", JDBCType.REAL);
        public final SqlColumn<Float> gnp = column("GNP", JDBCType.REAL);
        public final SqlColumn<Float> gnpold = column("GNPOld", JDBCType.REAL);
        public final SqlColumn<String> localname = column("LocalName", JDBCType.CHAR);
        public final SqlColumn<String> governmentform = column("GovernmentForm", JDBCType.CHAR);
        public final SqlColumn<String> headofstate = column("HeadOfState", JDBCType.CHAR);
        public final SqlColumn<Integer> capital = column("Capital", JDBCType.INTEGER);
        public final SqlColumn<String> code2 = column("Code2", JDBCType.CHAR);
        public Country() {
            super("country");
        }
    }
}