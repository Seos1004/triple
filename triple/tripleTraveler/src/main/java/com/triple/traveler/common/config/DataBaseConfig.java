package com.triple.traveler.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@MapperScan(basePackages="com.triple.traveler.mapper.**", sqlSessionFactoryRef="sqlSessionFactory")
public class DataBaseConfig {
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource DataSource() {
		return new HikariDataSource();
	}
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(
			@Qualifier("dataSource") DataSource dataSource, 
			ApplicationContext applicationContext) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/**/*.xml"));
		
		return sqlSessionFactory.getObject();
	}
	
	@Bean(name="sqlSession")
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
