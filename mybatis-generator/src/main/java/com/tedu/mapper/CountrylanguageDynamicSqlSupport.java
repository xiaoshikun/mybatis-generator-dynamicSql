package com.tedu.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class CountrylanguageDynamicSqlSupport {
    public static final Countrylanguage countrylanguage = new Countrylanguage();
    public static final SqlColumn<String> countrycode = countrylanguage.countrycode;
    public static final SqlColumn<String> language = countrylanguage.language;
    public static final SqlColumn<String> isofficial = countrylanguage.isofficial;
    public static final SqlColumn<Float> percentage = countrylanguage.percentage;
    public static final class Countrylanguage extends SqlTable {
        public final SqlColumn<String> countrycode = column("CountryCode", JDBCType.CHAR);
        public final SqlColumn<String> language = column("Language", JDBCType.CHAR);
        public final SqlColumn<String> isofficial = column("IsOfficial", JDBCType.CHAR);
        public final SqlColumn<Float> percentage = column("Percentage", JDBCType.REAL);
        public Countrylanguage() {
            super("countrylanguage");
        }
    }
}