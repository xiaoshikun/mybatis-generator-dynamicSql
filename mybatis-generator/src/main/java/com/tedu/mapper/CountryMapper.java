package com.tedu.mapper;

import com.tedu.entity.Country;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

import static com.tedu.mapper.CountryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CountryMapper {
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Country> insertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CountryResult")
    Country selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CountryResult", value = {
        @Result(column="Code", property="code", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="Continent", property="continent", jdbcType=JdbcType.CHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.CHAR),
        @Result(column="SurfaceArea", property="surfacearea", jdbcType=JdbcType.REAL),
        @Result(column="IndepYear", property="indepyear", jdbcType=JdbcType.SMALLINT),
        @Result(column="Population", property="population", jdbcType=JdbcType.INTEGER),
        @Result(column="LifeExpectancy", property="lifeexpectancy", jdbcType=JdbcType.REAL),
        @Result(column="GNP", property="gnp", jdbcType=JdbcType.REAL),
        @Result(column="GNPOld", property="gnpold", jdbcType=JdbcType.REAL),
        @Result(column="LocalName", property="localname", jdbcType=JdbcType.CHAR),
        @Result(column="GovernmentForm", property="governmentform", jdbcType=JdbcType.CHAR),
        @Result(column="HeadOfState", property="headofstate", jdbcType=JdbcType.CHAR),
        @Result(column="Capital", property="capital", jdbcType=JdbcType.INTEGER),
        @Result(column="Code2", property="code2", jdbcType=JdbcType.CHAR)
    })
    List<Country> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(country);
    }

    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, country);
    }

    default int deleteByPrimaryKey(String code_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, country)
                .where(code, isEqualTo(code_))
                .build()
                .execute();
    }

    default int insert(Country record) {
        return insert(SqlBuilder.insert(record)
                .into(country)
                .map(code).toProperty("code")
                .map(name).toProperty("name")
                .map(continent).toProperty("continent")
                .map(region).toProperty("region")
                .map(surfacearea).toProperty("surfacearea")
                .map(indepyear).toProperty("indepyear")
                .map(population).toProperty("population")
                .map(lifeexpectancy).toProperty("lifeexpectancy")
                .map(gnp).toProperty("gnp")
                .map(gnpold).toProperty("gnpold")
                .map(localname).toProperty("localname")
                .map(governmentform).toProperty("governmentform")
                .map(headofstate).toProperty("headofstate")
                .map(capital).toProperty("capital")
                .map(code2).toProperty("code2")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    default int insertSelective(Country record) {
        return insert(SqlBuilder.insert(record)
                .into(country)
                .map(code).toPropertyWhenPresent("code", record::getCode)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(continent).toPropertyWhenPresent("continent", record::getContinent)
                .map(region).toPropertyWhenPresent("region", record::getRegion)
                .map(surfacearea).toPropertyWhenPresent("surfacearea", record::getSurfacearea)
                .map(indepyear).toPropertyWhenPresent("indepyear", record::getIndepyear)
                .map(population).toPropertyWhenPresent("population", record::getPopulation)
                .map(lifeexpectancy).toPropertyWhenPresent("lifeexpectancy", record::getLifeexpectancy)
                .map(gnp).toPropertyWhenPresent("gnp", record::getGnp)
                .map(gnpold).toPropertyWhenPresent("gnpold", record::getGnpold)
                .map(localname).toPropertyWhenPresent("localname", record::getLocalname)
                .map(governmentform).toPropertyWhenPresent("governmentform", record::getGovernmentform)
                .map(headofstate).toPropertyWhenPresent("headofstate", record::getHeadofstate)
                .map(capital).toPropertyWhenPresent("capital", record::getCapital)
                .map(code2).toPropertyWhenPresent("code2", record::getCode2)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Country>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2)
                .from(country);
    }

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Country>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2)
                .from(country);
    }

    default Country selectByPrimaryKey(String code_) {
        return SelectDSL.selectWithMapper(this::selectOne, code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2)
                .from(country)
                .where(code, isEqualTo(code_))
                .build()
                .execute();
    }

    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Country record) {
        return UpdateDSL.updateWithMapper(this::update, country)
                .set(code).equalTo(record::getCode)
                .set(name).equalTo(record::getName)
                .set(continent).equalTo(record::getContinent)
                .set(region).equalTo(record::getRegion)
                .set(surfacearea).equalTo(record::getSurfacearea)
                .set(indepyear).equalTo(record::getIndepyear)
                .set(population).equalTo(record::getPopulation)
                .set(lifeexpectancy).equalTo(record::getLifeexpectancy)
                .set(gnp).equalTo(record::getGnp)
                .set(gnpold).equalTo(record::getGnpold)
                .set(localname).equalTo(record::getLocalname)
                .set(governmentform).equalTo(record::getGovernmentform)
                .set(headofstate).equalTo(record::getHeadofstate)
                .set(capital).equalTo(record::getCapital)
                .set(code2).equalTo(record::getCode2);
    }

    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Country record) {
        return UpdateDSL.updateWithMapper(this::update, country)
                .set(code).equalToWhenPresent(record::getCode)
                .set(name).equalToWhenPresent(record::getName)
                .set(continent).equalToWhenPresent(record::getContinent)
                .set(region).equalToWhenPresent(record::getRegion)
                .set(surfacearea).equalToWhenPresent(record::getSurfacearea)
                .set(indepyear).equalToWhenPresent(record::getIndepyear)
                .set(population).equalToWhenPresent(record::getPopulation)
                .set(lifeexpectancy).equalToWhenPresent(record::getLifeexpectancy)
                .set(gnp).equalToWhenPresent(record::getGnp)
                .set(gnpold).equalToWhenPresent(record::getGnpold)
                .set(localname).equalToWhenPresent(record::getLocalname)
                .set(governmentform).equalToWhenPresent(record::getGovernmentform)
                .set(headofstate).equalToWhenPresent(record::getHeadofstate)
                .set(capital).equalToWhenPresent(record::getCapital)
                .set(code2).equalToWhenPresent(record::getCode2);
    }

    default int updateByPrimaryKey(Country record) {
        return UpdateDSL.updateWithMapper(this::update, country)
                .set(name).equalTo(record::getName)
                .set(continent).equalTo(record::getContinent)
                .set(region).equalTo(record::getRegion)
                .set(surfacearea).equalTo(record::getSurfacearea)
                .set(indepyear).equalTo(record::getIndepyear)
                .set(population).equalTo(record::getPopulation)
                .set(lifeexpectancy).equalTo(record::getLifeexpectancy)
                .set(gnp).equalTo(record::getGnp)
                .set(gnpold).equalTo(record::getGnpold)
                .set(localname).equalTo(record::getLocalname)
                .set(governmentform).equalTo(record::getGovernmentform)
                .set(headofstate).equalTo(record::getHeadofstate)
                .set(capital).equalTo(record::getCapital)
                .set(code2).equalTo(record::getCode2)
                .where(code, isEqualTo(record::getCode))
                .build()
                .execute();
    }

    default int updateByPrimaryKeySelective(Country record) {
        return UpdateDSL.updateWithMapper(this::update, country)
                .set(name).equalToWhenPresent(record::getName)
                .set(continent).equalToWhenPresent(record::getContinent)
                .set(region).equalToWhenPresent(record::getRegion)
                .set(surfacearea).equalToWhenPresent(record::getSurfacearea)
                .set(indepyear).equalToWhenPresent(record::getIndepyear)
                .set(population).equalToWhenPresent(record::getPopulation)
                .set(lifeexpectancy).equalToWhenPresent(record::getLifeexpectancy)
                .set(gnp).equalToWhenPresent(record::getGnp)
                .set(gnpold).equalToWhenPresent(record::getGnpold)
                .set(localname).equalToWhenPresent(record::getLocalname)
                .set(governmentform).equalToWhenPresent(record::getGovernmentform)
                .set(headofstate).equalToWhenPresent(record::getHeadofstate)
                .set(capital).equalToWhenPresent(record::getCapital)
                .set(code2).equalToWhenPresent(record::getCode2)
                .where(code, isEqualTo(record::getCode))
                .build()
                .execute();
    }
}