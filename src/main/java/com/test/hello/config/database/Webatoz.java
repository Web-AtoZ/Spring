package com.test.hello.config.database;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.webatoz")
@EnableJpaRepositories(
        entityManagerFactoryRef = "webatoz"+"EntityManagerFactory",
        transactionManagerRef = "webatoz"+"TransactionManager",
        basePackages = {DatabaseConfig.BASE_MAPPER_PACKAGE_PREFIX + ".webatoz"}
)
public class Webatoz extends DatabaseConfig{

    // 데이터베이스 위치 확인
    final String name = "webatoz";
    final String packageToScan = "com.test.hello.database."+ name;

    @Bean(name = name + "DataSource")
    @Primary
    public DataSource dataSource() {
        return new LazyConnectionDataSourceProxy(new HikariDataSource(this));
    }

    /* -----------------mybatis 셋팅------------------------------------- */
    @Bean(name = name + "SessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(name + "DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        setConfigureSqlSessionFactory(sessionFactoryBean, dataSource);

        return sessionFactoryBean.getObject();
    }


    @Bean(name = name + "SqlSessionTemplate")
    public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier(name + "SessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /* -----------------JPA 셋팅------------------------------------- */
    @Bean(name = name + "EntityManagerFactory")
    @Primary
    public EntityManagerFactory entityManagerFactory(@Qualifier(name + "DataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan(packageToScan);
        factory.setPersistenceUnitName(name);
        setConfigureEntityManagerFactory(factory);

        return factory.getObject();
    }


    @Bean(name = name + "TransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(@Qualifier(name + "EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory);

        return tm;
    }
}