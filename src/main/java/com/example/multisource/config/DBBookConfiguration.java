package com.example.multisource.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.example.multisource.model.Book;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multisource.repository.book",
        entityManagerFactoryRef = "dbBookEntityManagerFactory"
)
public class DBBookConfiguration {

    @Bean
    @ConfigurationProperties("spring.second-datasource")
    public DataSourceProperties dbBookDataSourceProperties() {

        return new DataSourceProperties();
    }

    @Bean("dbBookDataSource")
    @ConfigurationProperties("spring.second-datasource.configuration")
    public DataSource dbBookDataSource() {

        return dbBookDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Bean(name = "dbBookEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dbBookEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {

        return builder
                .dataSource(dbBookDataSource())
                .packages(Book.class)
                .build();
    }
}
