package com.tedu.mapper;

import com.tedu.entity.Countrylanguage;
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

import static com.tedu.mapper.CountrylanguageDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CountrylanguageMapper {
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Countrylanguage> insertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CountrylanguageResult")
    Countrylanguage selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CountrylanguageResult", value = {
        @Result(column="CountryCode", property="countrycode", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Language", property="language", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="IsOfficial", property="isofficial", jdbcType=JdbcType.CHAR),
        @Result(column="Percentage", property="percentage", jdbcType=JdbcType.REAL)
    })
    List<Countrylanguage> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(countrylanguage);
    }

    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, countrylanguage);
    }

    default int deleteByPrimaryKey(String countrycode_, String language_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, countrylanguage)
                .where(countrycode, isEqualTo(countrycode_))
                .and(language, isEqualTo(language_))
                .build()
                .execute();
    }

    default int insert(Countrylanguage record) {
        return insert(SqlBuilder.insert(record)
                .into(countrylanguage)
                .map(countrycode).toProperty("countrycode")
                .map(language).toProperty("language")
                .map(isofficial).toProperty("isofficial")
                .map(percentage).toProperty("percentage")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    default int insertSelective(Countrylanguage record) {
        return insert(SqlBuilder.insert(record)
                .into(countrylanguage)
                .map(countrycode).toPropertyWhenPresent("countrycode", record::getCountrycode)
                .map(language).toPropertyWhenPresent("language", record::getLanguage)
                .map(isofficial).toPropertyWhenPresent("isofficial", record::getIsofficial)
                .map(percentage).toPropertyWhenPresent("percentage", record::getPercentage)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Countrylanguage>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, countrycode, language, isofficial, percentage)
                .from(countrylanguage);
    }

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Countrylanguage>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, countrycode, language, isofficial, percentage)
                .from(countrylanguage);
    }

    default Countrylanguage selectByPrimaryKey(String countrycode_, String language_) {
        return SelectDSL.selectWithMapper(this::selectOne, countrycode, language, isofficial, percentage)
                .from(countrylanguage)
                .where(countrycode, isEqualTo(countrycode_))
                .and(language, isEqualTo(language_))
                .build()
                .execute();
    }

    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Countrylanguage record) {
        return UpdateDSL.updateWithMapper(this::update, countrylanguage)
                .set(countrycode).equalTo(record::getCountrycode)
                .set(language).equalTo(record::getLanguage)
                .set(isofficial).equalTo(record::getIsofficial)
                .set(percentage).equalTo(record::getPercentage);
    }

    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Countrylanguage record) {
        return UpdateDSL.updateWithMapper(this::update, countrylanguage)
                .set(countrycode).equalToWhenPresent(record::getCountrycode)
                .set(language).equalToWhenPresent(record::getLanguage)
                .set(isofficial).equalToWhenPresent(record::getIsofficial)
                .set(percentage).equalToWhenPresent(record::getPercentage);
    }

    default int updateByPrimaryKey(Countrylanguage record) {
        return UpdateDSL.updateWithMapper(this::update, countrylanguage)
                .set(isofficial).equalTo(record::getIsofficial)
                .set(percentage).equalTo(record::getPercentage)
                .where(countrycode, isEqualTo(record::getCountrycode))
                .and(language, isEqualTo(record::getLanguage))
                .build()
                .execute();
    }

    default int updateByPrimaryKeySelective(Countrylanguage record) {
        return UpdateDSL.updateWithMapper(this::update, countrylanguage)
                .set(isofficial).equalToWhenPresent(record::getIsofficial)
                .set(percentage).equalToWhenPresent(record::getPercentage)
                .where(countrycode, isEqualTo(record::getCountrycode))
                .and(language, isEqualTo(record::getLanguage))
                .build()
                .execute();
    }
}