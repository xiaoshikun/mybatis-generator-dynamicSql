package com.tedu.mapper;

import com.tedu.entity.City;
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

import static com.tedu.mapper.CityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CityMapper {
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<City> insertStatement);
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CityResult")
    City selectOne(SelectStatementProvider selectStatement);
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CityResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="CountryCode", property="countrycode", jdbcType=JdbcType.CHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.CHAR),
        @Result(column="Population", property="population", jdbcType=JdbcType.INTEGER)
    })
    List<City> selectMany(SelectStatementProvider selectStatement);
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(city);
    }
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, city);
    }
    default int deleteByPrimaryKey(Integer id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, city)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    default int insert(City record) {
        return insert(SqlBuilder.insert(record)
                .into(city)
                .map(id).toProperty("id")
                .map(name).toProperty("name")
                .map(countrycode).toProperty("countrycode")
                .map(district).toProperty("district")
                .map(population).toProperty("population")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    default int insertSelective(City record) {
        return insert(SqlBuilder.insert(record)
                .into(city)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(countrycode).toPropertyWhenPresent("countrycode", record::getCountrycode)
                .map(district).toPropertyWhenPresent("district", record::getDistrict)
                .map(population).toPropertyWhenPresent("population", record::getPopulation)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<City>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, name, countrycode, district, population)
                .from(city);
    }

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<City>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, name, countrycode, district, population)
                .from(city);
    }

    default City selectByPrimaryKey(Integer id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, name, countrycode, district, population)
                .from(city)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(City record) {
        return UpdateDSL.updateWithMapper(this::update, city)
                .set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(countrycode).equalTo(record::getCountrycode)
                .set(district).equalTo(record::getDistrict)
                .set(population).equalTo(record::getPopulation);
    }

    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(City record) {
        return UpdateDSL.updateWithMapper(this::update, city)
                .set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(countrycode).equalToWhenPresent(record::getCountrycode)
                .set(district).equalToWhenPresent(record::getDistrict)
                .set(population).equalToWhenPresent(record::getPopulation);
    }

    default int updateByPrimaryKey(City record) {
        return UpdateDSL.updateWithMapper(this::update, city)
                .set(name).equalTo(record::getName)
                .set(countrycode).equalTo(record::getCountrycode)
                .set(district).equalTo(record::getDistrict)
                .set(population).equalTo(record::getPopulation)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    default int updateByPrimaryKeySelective(City record) {
        return UpdateDSL.updateWithMapper(this::update, city)
                .set(name).equalToWhenPresent(record::getName)
                .set(countrycode).equalToWhenPresent(record::getCountrycode)
                .set(district).equalToWhenPresent(record::getDistrict)
                .set(population).equalToWhenPresent(record::getPopulation)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}